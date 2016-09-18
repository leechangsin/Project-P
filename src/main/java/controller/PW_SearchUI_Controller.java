package controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.CodeAuth;
import command.EmailForm;
import command.PasswdSet;
import dao.MemberInfoDao;
import exceptions.NotFindCodeException;
import exceptions.NotFindEmailException;
import exceptions.NotMatchEmailException;
import service.PW_SearchService;
import validator.CodeAuthValidator;
import validator.EmailFormValidator;
import validator.PasswdSetValidator;

@Controller
@RequestMapping("/PW_Search")
public class PW_SearchUI_Controller {
	PW_SearchService pw_searchService;
	MemberInfoDao memberInfoDao;

	public PW_SearchUI_Controller(PW_SearchService pw_searchService, MemberInfoDao memberInfoDao) {
		this.pw_searchService = pw_searchService;
		this.memberInfoDao = memberInfoDao;
	}
	//비밀번호 변경 메인화면
	//비밀번호를 찾을 이메일을 입력하는 화면
	@RequestMapping("main")
	public String ShowPW_SearchUI(Model model) {
		model.addAttribute("emailForm", new EmailForm());
		return "PW_SearchUI";
	}
	//비밀번호를 찾을 이메일이 DB에 존재하면 암호코드를 이메일로 발송한다. 이메일에 발송된 암호코드를 입력할 수 있는 화면을 출력
	@RequestMapping("inputCode")
	public String inputCode(EmailForm emailForm, Errors errors, Model model) {
		new EmailFormValidator().validate(emailForm, errors);
		if (errors.hasErrors())
			return "PW_SearchUI";

		String emailAddress = emailForm.getFirstEmail() + "@" + emailForm.getSecondEmail();
		emailForm.setEmailAddress(emailAddress);

		try {
			pw_searchService.selectByEmail(emailAddress);
			EmailForm reciver = pw_searchService.setEmail(emailAddress);
			MimeMessage mimeMessage = pw_searchService.setMimeMessage(reciver);
			pw_searchService.sendEmail(mimeMessage);
		} catch (NotFindEmailException e) {
			e.printStackTrace();
			errors.reject("NotFindEmail");
			return "PW_SearchUI";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "PW_SearchUI";
		}

		CodeAuth codeAuth = new CodeAuth();
		codeAuth.setEmailAddress(emailAddress);
		model.addAttribute("codeAuth", codeAuth);
		return "inputCode";
	}

	//암호코드를 기준으로 DB에서 암호코드가 존재하는지 찾는다. 존재하면 비밀번호변경 화면 출력
	@RequestMapping("inputPW")
	public String inputPW(CodeAuth codeAuth, Errors errors, Model model) {
		new CodeAuthValidator().validate(codeAuth, errors);
		if (errors.hasErrors())
			return "inputCode";

		try {
			//사용자가 입력한 코드로 PWSearch테이블을 검색한다. 검색 결과는 사용자가 입력한 코드에 맞는 이메일이 반환된다.
			CodeAuth resultNewPWSet = pw_searchService.selectByCode(codeAuth.getReciveCode());
			//DB에 코드와 맞는 이메일을 가지고 사용자가 입력했던 이메일과 비교하여 다르면 예외를 발생시킨다.
			//예를 들어 사용자가 ycs318@naver.com 이메일의 비밀번호 찾기를 할 경우 PWSearch테이블에 
			//code=1234567890, email=ycs318@naver.com 이라는 튜플이 생긴다.
			//PWSearch테이블에 code = 1123456789, email=sksmsdi@gmail.com 이라는 튜플이 존재하고 있다고 할 떄,
			//사용자가 암호코드 입력 단계에서 123456789를 입력할 수 있지만, 고의 또는 실수로 1123456789를 입력할 경우
			//sksmsdi@gmail.com 계정의 비밀번호가 바뀌게된다. 그래서 사용자가 입력한 code값을 가지고 PWSearch테이블에서 튜플을
			//검색한 뒤 해당 튜플의 이메일값과 사용자가 비밀번호 찾기를 요청했던 이메일과 비교해 맞는지 확인하는 절차가 필요하다.
			pw_searchService.confirmCode(resultNewPWSet.getEmailAddress(), codeAuth.getEmailAddress());
		} catch (NotFindCodeException e) {
			e.printStackTrace();
			errors.rejectValue("reciveCode", "bedCode");
			return "inputCode";
		} catch (NotMatchEmailException e) {
			e.printStackTrace();
			errors.rejectValue("reciveCode", "bedCode");
			return "inputCode";
		}

		PasswdSet passwdSet = new PasswdSet();
		passwdSet.setEmailAddress(codeAuth.getEmailAddress());
		model.addAttribute("passwdSet", passwdSet);
		return "inputPW";
	}
	//비밀번호변경 화면에서 패스워드를 두 차례 올바르게 입력했다면 DB에 비밀번호변경 실행 변경이 완료되면 메인UI로 이동
	@RequestMapping("changePW")
	public String changePW(PasswdSet passwdSet, Errors errors, Model model) {
		new PasswdSetValidator().validate(passwdSet, errors);
		if (errors.hasErrors())
			return "inputPW";

		pw_searchService.updatePasswd(passwdSet.getEmailAddress(), passwdSet.getPasswd());
		pw_searchService.deleteCode(passwdSet.getEmailAddress());

		model.addAttribute("email", passwdSet.getEmailAddress());
		return "IndexUI";
	}
}