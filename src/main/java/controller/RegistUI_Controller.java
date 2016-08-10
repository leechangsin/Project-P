package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/regist")
public class RegistUI_Controller {

	@RequestMapping("main")
	public String showRegistUI() {
		return "RegistUI";
	}

	@RequestMapping("SignUpEmail")
	public String SignUpEmail() {
		return "SignUpUI";
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
