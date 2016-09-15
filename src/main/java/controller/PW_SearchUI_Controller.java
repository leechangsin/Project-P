package controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.EmailForm;
import exceptions.NotFindEmailException;
import service.PW_SearchService;

@Controller
@RequestMapping("/PW_Search")
public class PW_SearchUI_Controller {
	PW_SearchService pw_searchService;
	
	public PW_SearchUI_Controller(PW_SearchService pw_searchService){
		this.pw_searchService = pw_searchService;
	}

	@RequestMapping("main")
	public String ShowPW_SearchUI(Model model){
		model.addAttribute(new EmailForm());
		return "PW_SearchUI";
	}
	
	@RequestMapping("inputCode")
	public String inputCode(EmailForm emailForm, Errors errors, Model model){
		String emailAddress = emailForm.getFirstEmail() + "@" + emailForm.getSecondEmail();
		
		try{
			pw_searchService.selectByEmail(emailAddress);
			EmailForm reciver = pw_searchService.setEmail(emailAddress);
			MimeMessage mimeMessage = pw_searchService.setMimeMessage(reciver);
			pw_searchService.sendEmail(mimeMessage);
		} catch(NotFindEmailException e){
			e.printStackTrace();
			return ShowPW_SearchUI(model);
		} catch(MessagingException e){
			e.printStackTrace();
			return ShowPW_SearchUI(model);
		}
		
		model.addAttribute("emailAddress", emailAddress);
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