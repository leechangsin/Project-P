package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import command.Contents;
import dao.ContentsDao;

@Controller
public class SearchUI_Contents_Controller {
	private ContentsDao contenstDao;

	public SearchUI_Contents_Controller(ContentsDao contenstDao) {
		this.contenstDao = contenstDao;
	}

	@RequestMapping("/search/contents")
	public String Search_Contents(@ModelAttribute("SearchModelContents") Contents contents, Model model) {
		List<Contents> contests = contenstDao.selectByTitle(contents.getTitle());

		model.addAttribute("contests", contests);

		return "SearchUI_Contents";
	}
}
