package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberInfoDao;
import exceptions.NotFindEmailException;
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
		return "LoginUI";
	}//end login(Model model)

	@RequestMapping("loginRequest")
	public String loginRequest(MemberInfo memberInfo, Errors errors, Model model) {
		new LoginRequestValidator().validate(memberInfo, errors);
		if(errors.hasErrors())
			return "main";
		
		String email = memberInfo.getEmail();
		String password = memberInfo.getPasswd();
		try{
			LoginRequestService.authenticate(memberInfoDao, email, password);
			//변수명을 Login_Email_Text -> MainUI에서 받는 변수명으로 변경해야함.
			model.addAttribute("Login_Email_Text", email);
			return "MainUI";
		}catch(NotFindEmailException e){
			return "main";
		}//end try
	}//end loginRequest(MemberInfo memberInfo, Errors errors)
}//end class LoginUI_Controller