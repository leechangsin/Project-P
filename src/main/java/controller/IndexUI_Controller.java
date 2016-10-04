package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.IndexService;


@Controller
@RequestMapping("/")
public class IndexUI_Controller {
	private IndexService indexService;
	
	public IndexUI_Controller(IndexService indexService){
		this.indexService = indexService;
	}
	

	@RequestMapping("/")
	public String indexUI(Model model) {
		List<String> con_ids = indexService.getAllCon_id();
		List<String> titles = indexService.getAllTitle();
		List<String> texts = indexService.getAllText();
		
		model.addAttribute("con_ids", con_ids);
		model.addAttribute("titles", titles);
		model.addAttribute("texts", texts);
		return "index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("testUI")
	public String testUI(){
		return "testUI";
	}
}