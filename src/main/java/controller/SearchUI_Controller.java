package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import command.Contents;
import command.Member;
import service.SearchService;

@Controller
@RequestMapping("/Search")
public class SearchUI_Controller {
	private SearchService searchService;

	public SearchUI_Controller(SearchService searchService) {
		this.searchService = searchService;
	}
	
	@RequestMapping("main")
	public String main(){
		return "SearchUI";
	}
	
	@RequestMapping("search_users")
	public String Search_Users(HttpServletRequest request, Model model) {
		String requestType = request.getParameter("requestType");
		String keyword = request.getParameter("keyword");
		
		if(requestType.equals("사용자")){
			List<Member> results = searchService.selecyByNickname(keyword);
			model.addAttribute("results", results);
			return "SearchUI_Member";
		}else{
			List<Contents> results = searchService.selecyByTitle(keyword);
			model.addAttribute("results", results);
			return "SearchUI_Contents";
		}
	}
	
	@RequestMapping("getMemberImage")
	public ResponseEntity<byte[]> getMemberImage(HttpServletRequest request){
		String nickname = (String) request.getParameter("nickname");
		
		Map<String, Object> hashMap = searchService.getMemberImage(nickname);
		if(hashMap != null){
			byte[] image = (byte[]) hashMap.get("image");
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.IMAGE_PNG);
			return new ResponseEntity<byte[]>(image, httpHeaders, HttpStatus.OK);
		}
		
		return null;
	}
}
