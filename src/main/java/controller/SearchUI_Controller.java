package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import command.Member;
import command.RequestType;
import dao.MemberDao;

@Controller
@RequestMapping("/Search")
public class SearchUI_Controller {
	private MemberDao memberDao;

	public SearchUI_Controller(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@RequestMapping("main")
	public String main(){
		return "SearchUI";
	}
	
	@RequestMapping("search_users")
	public void Search_Users(HttpServletRequest request, Model model) {
		String requestType = request.getParameter("requestType");
		String keyword = request.getParameter("keyword");
		
		System.out.println("requestType = " + requestType);
		System.out.println("keyword = " + keyword);
	}
/*
	@RequestMapping("search_users")
	public String Search_Members(HttpServletRequest request, Model model) {
		String nickname = request.getParameter("nickname");
		List<Member> members = memberDao.selectByNickName(nickname, RequestType.Search_Members);

		model.addAttribute("results", members);

		return "SearchUI_Member";
	}
*/
}
