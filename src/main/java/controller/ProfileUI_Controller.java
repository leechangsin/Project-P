package controller;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD
=======
import org.springframework.ui.Model;
>>>>>>> Design/#22
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Profile")
public class ProfileUI_Controller {
	
	@RequestMapping("main")
	public String showProfileUI(){
		return "profileUI";
	}
	
	@RequestMapping("modify")
	public String modifyAccount(Model model){
		return "modify";
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
