package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/search")
public class SearchUI_Controller {

		@RequestMapping("main")
		public String Register(Model model){
			
			return "SearchUI";
		}// 검색부분 메인 화면
		
		
		
		
} 
	

