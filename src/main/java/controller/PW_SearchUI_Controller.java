package controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import command.Email;
import exceptions.NotFindEmailException;
import service.PW_SearchService;

@Controller
@RequestMapping("/PW_searchUI")
public class PW_SearchUI_Controller {
	PW_SearchService pw_searchService;
	
	public PW_SearchUI_Controller(PW_SearchService pw_searchService){
		this.pw_searchService = pw_searchService;
	}
	
	@RequestMapping("main")
	public String ShowPW_SearchUI(){
		return "PW_SearchUI";
	}
	
	@RequestMapping("inputCode")
	public String inputCode(){
		try{
			pw_searchService.selectByEmail("");
			Email reciver = pw_searchService.setEmail("");
			MimeMessage mimeMessage = pw_searchService.setMimeMessage(reciver);
			pw_searchService.sendEmail(mimeMessage);
		} catch(NotFindEmailException e){
			e.printStackTrace();
			return ShowPW_SearchUI();
		} catch(MessagingException e){
			e.printStackTrace();
			return ShowPW_SearchUI();
		}
		
		return "inputCode";
	}
	
	@RequestMapping("inputPW")
	public String PWChange(){
		return "inputPW";
	}
	
	@RequestMapping("changePW")
	public String changePW(){
		return "changePW";
	}
}