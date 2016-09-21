package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		
		//modify뷰에서 생년월일 선택에 쓸 년,월,일을 생성하고 전달
		Calendar calendar = Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		List<String> year = new ArrayList<>();
		List<String> month = new ArrayList<>();
		List<String> day = new ArrayList<>();
		for (int i = nowYear; i >= nowYear - 100; i--)
			year.add(String.valueOf(i));
		for (int i = 1; i <= 12; i++)
			month.add(String.valueOf(i));
		for (int i = 1; i <= 31; i++)
			day.add(String.valueOf(i));

		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		
		//modify뷰에서 성별 선택에 쓸 남,여를 생성하고 전달
		List<String> sex = new ArrayList<>();
		sex.add("남자");
		sex.add("여자");
		model.addAttribute("sex", sex);
		
		model.addAttribute("modifyForm", modifyForm);
		return "modify";
	}
	
	@RequestMapping("modifyProcess")
	public String modifyProcess(ModifyForm modifyForm, Errors errors, HttpServletRequest request, FileVo fileVo){
		modifyForm.setEmailChanged( modifyService.compareEmail(request.getParameter("originalEmail"), modifyForm.getEmail()) );
		modifyForm.setPasswdChanged( modifyService.comparePasswd(request.getParameter("originalPasswd"), modifyForm.getPasswd()) );
		modifyForm.setNicknameChanged( modifyService.compareNickname(request.getParameter("originalNickname"), modifyForm.getNickname()) );
		
		new ModifyFormValidator().validate(modifyForm, errors);
		if(errors.hasErrors())
			return "modify";
		
		try{
			if(modifyForm.getEmailChanged())
				modifyService.checkEmail(modifyForm.getEmail());
			if(modifyForm.getNicknameChanged())
				modifyService.checkNickName(modifyForm.getNickname());
			if(!fileVo.getPictureFile().isEmpty())
				modifyForm.setPicture(fileVo.getPictureFile().getBytes());
		} catch(AlreadyExistAccountException e){//modifyService.checkEmail에서 발생
			e.printStackTrace();
			errors.rejectValue("email", "alreadyExistEmail");
			return "modify";
		} catch(AlreadyExistNicknameException e){//modifyService.checkNickName에서 발생
			e.printStackTrace();
			errors.rejectValue("nickname", "alreadyExistNickname");
			return "modify";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "modify";
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
