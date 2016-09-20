package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Profile")
public class ProfileUI_Controller {
	
	@RequestMapping("main")
	public String showProfileUI(){
		return "profileUI";
	}
	
	@RequestMapping("modify")
	public String modifyAccount(){
		return "profileUI";
	}
	
	@RequestMapping("write")
	public String write(){
		return "profileUI";
	}
	
	@RequestMapping()
	public String drawer(){
		return "profileUI";
	}
}
