package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexUI_Controller {

	@RequestMapping("/")
	public String indexUI(Model model) {
		return "IndexUI";
	}

	@RequestMapping("/index")
	public String index() {
		return "IndexUI";
	}
}