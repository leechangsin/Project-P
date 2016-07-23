package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberInfoDao;
import exceptions.NotFindEmailException;
import exceptions.NotMatchPasswdException;
import service.LoginRequestService;
import table.MemberInfo;
import validator.LoginRequestValidator;

@Controller
@RequestMapping("/login")
public class LoginUI_Controller {
	private MemberInfoDao memberInfoDao;
	
	public LoginUI_Controller(MemberInfoDao memberInfoDao){
		this.memberInfoDao = memberInfoDao;
	}

	@RequestMapping("main")
	public String showLoginUI(Model model) {
		model.addAttribute("memberInfo", new MemberInfo());
		return "LoginUI";
	}//end login(Model model)

	@RequestMapping("loginRequest")
	public String loginRequest(MemberInfo memberInfo, Errors errors, Model model) {
		new LoginRequestValidator().validate(memberInfo, errors);
		if(errors.hasErrors())
			return "LoginUI";
		
		String email = memberInfo.getEmail();
		String passwd = memberInfo.getPasswd();
		try{
			System.out.println("이메일 : " + email);
			System.out.println("비밀번호 : " + passwd);
			LoginRequestService.authenticate(memberInfoDao, email, passwd);
			//변수명을 Login_Email_Text -> MainUI에서 받는 변수명으로 변경해야함.
			model.addAttribute("Login_Email_Text", email);
			return "MainUI";
		}catch(NotFindEmailException e){
			e.printStackTrace();
			return "LoginUI";
		}catch(NotMatchPasswdException e){
			e.printStackTrace();
			return "LoginUI";
		}//end try
	}//end loginRequest(MemberInfo memberInfo, Errors errors)
}//end class LoginUI_Controller