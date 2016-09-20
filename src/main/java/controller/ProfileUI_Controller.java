package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import command.Member;
import command.MemberInfo;
import command.ModifyForm;
import service.ModifyService;

@Controller
@RequestMapping("/Profile")
public class ProfileUI_Controller {
	private ModifyService modifyService;
	
	public ProfileUI_Controller(ModifyService modifyService){
		this.modifyService = modifyService;
	}
	
	@RequestMapping("main")
	public String showProfileUI(){
		return "ProfileUI";
	}
	
	@RequestMapping("modify")
	public String modifyAccount(HttpSession session, Model model){
		Member member = (Member) session.getAttribute("member");
		MemberInfo memberInfo = modifyService.selecyByEmail(member.getEmail());
		ModifyForm modifyForm = modifyService.setModifyForm(memberInfo, member);
		
		model.addAttribute("modifyForm", modifyForm);
		return "modify";
	}
	
	@RequestMapping("write")
	public String write(){
		return "ProfileUI";
	}
	
	@RequestMapping()
	public String drawer(){
		return "ProfileUI";
	}
}
