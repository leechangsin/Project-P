package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.Member;
import command.MemberInfo;
import command.ModifyForm;
import exceptions.AlreadyExistAccountException;
import exceptions.AlreadyExistNicknameException;
import service.ModifyService;
import validator.ModifyFormValidator;

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
	
	@RequestMapping("modifyProcess")
	public String modifyProcess(ModifyForm modifyForm, Errors errors, HttpServletRequest request){
		String originalPasswd = String.valueOf(request.getParameter("originalPasswd"));
		String modifyFormPasswd = modifyForm.getPasswd();
		if(modifyService.comparePasswd(originalPasswd, modifyFormPasswd))
			modifyForm.setPasswdChanged(true);
		
		new ModifyFormValidator().validate(modifyForm, errors);
		if(errors.hasErrors())
			return "modify";
		
		try{
			modifyService.checkEmail(modifyForm.getEmail());
			modifyService.checkNickName(modifyForm.getNickname());
		} catch(AlreadyExistAccountException e){//modifyService.checkEmail에서 발생
			e.printStackTrace();
			errors.rejectValue("email", "alreadyExistEmail");
			return "modify";
		} catch(AlreadyExistNicknameException e){//modifyService.checkNickName에서 발생
			e.printStackTrace();
			errors.rejectValue("nickname", "alreadyExistNickname");
		}
		
		modifyService.updateAccount(modifyForm);
		
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
