package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contents")
public class ContentsUI_Controller {

	@RequestMapping("/main")
	public String contenstsUI() {
		return "ContentsUI";
	}

	@RequestMapping("getFile")
	public void getFile(FileVo file) {
		System.out.println(file.getFile().getOriginalFilename());
	}
}