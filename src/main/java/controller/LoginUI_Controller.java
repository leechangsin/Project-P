package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.AuthInfo;
import command.Member;
import exceptions.NotFindEmailException;
import exceptions.NotMatchPasswdException;
import service.LoginRequestService;
import validator.AuthInfoValidator;

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
		if(!model.containsAttribute("authInfo"))
			model.addAttribute("authInfo", new AuthInfo());
		return "LoginUI";
	}//end login(Model model)

	@RequestMapping("loginRequest")
	public String loginRequest(AuthInfo authInfo, Errors errors, HttpSession session) {
		new AuthInfoValidator().validate(authInfo, errors);
		if(errors.hasErrors())
			return "LoginUI";
			
		String email = authInfo.getEmail();
		String passwd = authInfo.getPasswd();
		try{
			loginRequestService.emailAuthenticate(email, passwd);
			Member member = loginRequestService.selectByEmail(email);
			session.setAttribute("member", member);
		}catch(NotFindEmailException e){
			e.printStackTrace();
			errors.rejectValue("email", "NotFindEmail");
			return "LoginUI";
		}catch(NotMatchPasswdException e){
			e.printStackTrace();
			errors.rejectValue("passwd", "NotMatchPasswd");
			return "LoginUI";
		}//end try
		
		return "redirect:/";
	}//end loginRequest(MemberInfo memberInfo, Errors errors)
	
	@RequestMapping("logout")
	public String logoutRequest(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}//end class LoginUI_Controller
