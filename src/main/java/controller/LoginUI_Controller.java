package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberInfo;
import service.LoginRequestService;
import validator.LoginRequestValidator;

@Controller
@RequestMapping("/login")
public class LoginUI_Controller {

	@RequestMapping("main")
	public String login(Model model) {
		return "LoginUI";
	}//end login(Model model)

	@RequestMapping("loginRequest")
	public String loginRequest(MemberInfo memberInfo, Errors errors, Model model) {
		new LoginRequestValidator().validate(memberInfo, errors);
		if(errors.hasErrors())
			return "main";
		
		try{
			LoginRequestService.Login(memberInfo);
			//변수명을 Login_Email_Text -> MainUI에서 받는 변수명으로 변경해야함.
			model.addAttribute("Login_Email_Text", memberInfo.getEmail());
			return "MainUI";
		}catch(Exception e){
			return "main";
		}//end try
	}//end loginRequest(MemberInfo memberInfo, Errors errors)
}//end class LoginUI_Controller