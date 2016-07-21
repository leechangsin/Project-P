package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/regist")
public class RegisterUI_Controller {

	@RequestMapping("main")
	public String Register(Model model){
		
		return "RegistUI";
	}
	
	
}
