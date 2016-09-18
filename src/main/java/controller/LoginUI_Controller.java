package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.Member;
import command.MemberInfo;
import exceptions.NotFindEmailException;
import exceptions.NotMatchPasswdException;
import service.LoginRequestService;
import validator.MemberInfoValidator;

@Controller
@RequestMapping("/login")
public class LoginUI_Controller {
	private LoginRequestService loginRequestService;
	
	public LoginUI_Controller(LoginRequestService loginRequestService){
		this.loginRequestService = loginRequestService;
	}

	@RequestMapping("main")
	public String showLoginUI(Model model) {
		//LoginUI뷰에서 커멘드객체를 사용하여 사용자가 보내는 값을 받고 있고, 커멘드 객체의 프로퍼티에 에러코드를
		//달아 이를 출력하고 있으므로 커맨드 객체를 생성해서 넘겨주어야한다.
		//이에 따른 커맨드 객체를 생성하여 넘겨준다.
		if(!model.containsAttribute("memberInfo"))
			model.addAttribute("memberInfo", new MemberInfo());
		return "LoginUI";
	}//end login(Model model)

	@RequestMapping("loginRequest")
	public String loginRequest(MemberInfo memberInfo, Errors errors, Model model) {
		new MemberInfoValidator().validate(memberInfo, errors);
		if(errors.hasErrors())
			return "LoginUI";
		
		String email = memberInfo.getEmail();
		String passwd = memberInfo.getPasswd();
		try{
			loginRequestService.emailAuthenticate(email, passwd);
			Member member = loginRequestService.selectByEmail(email);
			model.addAttribute("member", member);
		}catch(NotFindEmailException e){
			e.printStackTrace();
			return "LoginUI";
		}catch(NotMatchPasswdException e){
			e.printStackTrace();
			return "LoginUI";
		}//end try
		
		return "/Project-P/index";
	}//end loginRequest(MemberInfo memberInfo, Errors errors)
}//end class LoginUI_Controller
