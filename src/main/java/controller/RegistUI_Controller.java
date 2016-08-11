package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberInfo;
import service.SignUpEmailService;

@Controller
@RequestMapping("/regist")
public class RegistUI_Controller {
	private SignUpEmailService signUpEmailService;
	
	public RegistUI_Controller(SignUpEmailService singUpEmailService){
		this.signUpEmailService = singUpEmailService;
	}

	@RequestMapping("main")
	public String showRegistUI() {
		return "RegistUI";
	}

	@RequestMapping(value = "SignUpEmail/step1")
	public String SignUpEmailStep1() {
		return "SignUpEmailStep1";
	}
	
	@RequestMapping("SignUpEmail/step2")
		public String SignUpEmailStep2(@RequestParam(value="agree1", defaultValue="false") Boolean agree1,
				@RequestParam(value="agree2", defaultValue="false") Boolean agree2){
			if(!agree1 || !agree2)
				return "redirect:/regist/main";
					
			return "SingUpEmailStep2";
		}
	
	@RequestMapping("SignUpEmail/step3")
	public String SignUpEmailStep3(MemberInfo memberInfo){
		Date toDay = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		memberInfo.setReg_date(sdf.format(toDay));
		
		signUpEmailService.SignUp(memberInfo);
		
		return null;
	}

	/*
	@RequestMapping("SignUpKaKao")
	public void SingUpKaKao(){
		
	}
	@RequestMapping("SignUpFaceBook")
	public void SingUpFaceBook(){
		
	}
	*/
}
