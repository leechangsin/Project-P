package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/PW_Search")
public class PW_SearchUI_Controller {

	@RequestMapping("main")
	public String ShowPW_SearchUI(){
		return "PW_SearchUI";
	}
}
