package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.fabric.xmlrpc.base.Member;

import dao.MemberDao;

@Controller
@RequestMapping("search")
public class SearchUI_Controller {
	MemberDao memberdao = new MemberDao();
	@RequestMapping("main")
	public String Search_main(Model model, @RequestParam(value="id", required = false)String id){
		model.addAttribute("greeting","안녕하세요");
		model.addAttribute("test1",id);
		return "SearchUI";
	}
	
	@RequestMapping("notPage")
	public String Search_notPage(Model model){
		return "Search_not_pageUI";
	}
}
