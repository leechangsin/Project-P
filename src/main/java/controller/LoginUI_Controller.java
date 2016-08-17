package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.MemberInfo;
import dao.MemberInfoDao;
import exceptions.NotFindEmailException;
import exceptions.NotMatchPasswdException;
import service.LoginRequestService;
import validator.MemberInfoValidator;

@Controller
@RequestMapping("/login")
public class LoginUI_Controller {
	private MemberInfoDao memberInfoDao;
	
	public LoginUI_Controller(MemberInfoDao memberInfoDao){
		this.memberInfoDao = memberInfoDao;
	}

	@RequestMapping("main")
	public String showLoginUI(Model model) {
		//LoginUI뷰에서 커멘드객체를 사용하여 사용자가 보내는 값을 받고 있고, 커멘드 객체의 프로퍼티에 에러코드를
		//달아 이를 출력하고 있으므로 커맨드 객체를 생성해서 넘겨주어야한다.
		//이에 따른 커맨드 객체를 생성하여 넘겨준다.
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
			LoginRequestService.authenticate(memberInfoDao, email, passwd);
			//변수명을 Login_Email_Text -> MainUI에서 받는 변수명으로 변경해야함.
			model.addAttribute("Login_Email_Text", email);
			return "IndexUI";
		}catch(NotFindEmailException e){
			e.printStackTrace();
			return "LoginUI";
		}catch(NotMatchPasswdException e){
			e.printStackTrace();
			return "LoginUI";
		}//end try
	}//end loginRequest(MemberInfo memberInfo, Errors errors)
	
	@RequestMapping("goRegistUI")
	public String goRegistUI(){
		return "/Project-P/RegistUI";
	}
}//end class LoginUI_Controller
