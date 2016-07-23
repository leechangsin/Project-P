package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginUI_Controller {

	@RequestMapping("main")
	public String login(Model model) {
		model.addAttribute("Login_Email_Text", "이메일을 입력하세요.");
		model.addAttribute("Login_PW_Text", "비밀번호를 입력하세요.");

		return "LoginUI";
	}
}