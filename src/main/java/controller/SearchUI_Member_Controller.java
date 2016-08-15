package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import command.Member;
import dao.MemberDao;

@Controller
public class SearchUI_Member_Controller {
	private MemberDao memberDao;

	public SearchUI_Member_Controller(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping("/search/members")
	public String Search_Members(@ModelAttribute("SearchModel") Member member, Model model) {
		List<Member> members = memberDao.searchByName(member.getNickname());

		model.addAttribute("members", members);

		return "SearchUI_Member";
	}
}
