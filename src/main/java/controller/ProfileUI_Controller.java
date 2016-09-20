package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Profile")
public class ProfileUI_Controller {

	@RequestMapping("main")
	public String showProfileUI(){
		return "ProfileUI";
	}
	
	@RequestMapping("modify")
	public String modifyAccount(Model model){
		
		return "modify";
	}
}
