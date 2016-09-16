package controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.EmailForm;
import dao.MemberInfoDao;
import exceptions.NotFindCodeException;
import exceptions.NotFindEmailException;
import exceptions.NotMatchPasswdException;
import service.PW_SearchService;

@Controller
@RequestMapping("/PW_Search")
public class PW_SearchUI_Controller {
	PW_SearchService pw_searchService;
	MemberInfoDao memberInfoDao;
	
	public PW_SearchUI_Controller(PW_SearchService pw_searchService, MemberInfoDao memberInfoDao){
		this.pw_searchService = pw_searchService;
		this.memberInfoDao = memberInfoDao;
	}
	//비밀번호 변경 메인화면
	//비밀번호를 찾을 이메일을 입력하는 화면
	@RequestMapping("main")
	public String ShowPW_SearchUI(Model model){
		model.addAttribute(new EmailForm());
		return "PW_SearchUI";
	}
	//비밀번호를 찾을 이메일이 DB에 존재하면 암호코드를 이메일로 발송한다.
	//이메일에 발송된 암호코드를 입력할 수 있는 화면을 출력
	@RequestMapping("inputCode")
	public String inputCode(EmailForm emailForm, Errors errors, Model model){
		String emailAddress = emailForm.getFirstEmail() + "@" + emailForm.getSecondEmail();

		try{
			pw_searchService.selectByEmail(emailAddress);
			EmailForm reciver = pw_searchService.setEmail(emailAddress);
			MimeMessage mimeMessage = pw_searchService.setMimeMessage(reciver);
			pw_searchService.sendEmail(mimeMessage);
		} catch(NotFindEmailException e){
			/* 미완성 코드...
			 * 사용자가 입력한 이메일이 DB에 없다면 없다는 메세지를 출력하고
			 * PW_SearchUI뷰를 보여줘야한다.
			 * */
			e.printStackTrace();
			return ShowPW_SearchUI(model);
		} catch(MessagingException e){
			e.printStackTrace();
			return ShowPW_SearchUI(model);
		}
		
		model.addAttribute("emailAddress", emailAddress);
		return "inputCode";
	}

	//암호코드를 기준으로 DB에서 암호코드가 존재하는지 찾는다. 존재하면 비밀번호변경 화면 출력
	@RequestMapping("inputPW")
	public String inputPW(HttpServletRequest request, Model model){
		String emailAddress = request.getParameter("emailAddress");
		String reciveCode = request.getParameter("reciveCode");
		
		try{
			pw_searchService.selectByCode(reciveCode);
		} catch(NotFindCodeException e){
			e.printStackTrace();
			/* 미완성 코드...
			 * 암호코드를 잘못입력했다면 암호코드를 잘못입력했다는 메세지를 출력하고
			 * inputCode뷰를 보여줘야한다.
			 * */
			ShowPW_SearchUI(model);
		}
		
		model.addAttribute("emailAddress", emailAddress);
		return "inputPW";
	}
	//비밀번호변경 화면에서 패스워드를 두 차례 올바르게 입력했다면 DB에 비밀번호변경 실행
	//변경이 완료되면 메인UI로 이동
	@RequestMapping("changePW")
	public String changePW(HttpServletRequest request, Model model){
		String emailAddress = request.getParameter("emailAddress");
		String passwd = request.getParameter("passwd");
		String rePasswd = request.getParameter("rePasswd");
		
		try{
			pw_searchService.confirmPasswd(passwd, rePasswd);
			pw_searchService.updatePasswd(emailAddress, passwd);
			pw_searchService.deleteCode(emailAddress);
		} catch(NotMatchPasswdException e){
			e.printStackTrace();
			/*미완성 코드... 
			 * 두 차례의 비밀번호 입력이 틀렸다면은 inputPW뷰로가서 비밀번호가 틀렸다는 내용을 출력해야함...
			 * */
			inputPW(request, model);
		}
		
		model.addAttribute("email", emailAddress);
		return "IndexUI";
	}
}