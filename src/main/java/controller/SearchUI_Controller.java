package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.Member;
import dao.MemberDao;

@Controller
public class SearchUI_Controller {
	private MemberDao memberDao;
	

	public SearchUI_Controller(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping("/search/main")
	public String Search_main(@ModelAttribute("search_model")String id, Model model){
	
		List<Member> members = memberDao.searchByName(id);
		
		model.addAttribute("members",members);
		
		return "SearchUI";
	}
}
