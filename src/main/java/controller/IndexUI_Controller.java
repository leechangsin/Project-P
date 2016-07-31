package controller;

import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import command.Member;
import dao.MemberDao;
import dao.MemberInfoDao;
import exceptions.NotFindEmailException;

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