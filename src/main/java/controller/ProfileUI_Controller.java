package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import command.Member;
import command.MemberInfo;
import command.ModifyStoreForm;
import command.WriteForm;
import exceptions.AlreadyExistAccountException;
import exceptions.AlreadyExistNicknameException;
import service.ModifyService;
import service.ProfileService;
import service.WriteService;
import validator.ModifyStoreFormValidator;
import validator.WriteFormValidator;

@Controller
@RequestMapping("/Profile")
public class ProfileUI_Controller {
	private ModifyService modifyService;
	private ProfileService profileService;
	private WriteService writeService;
	
	public ProfileUI_Controller(ModifyService modifyService, ProfileService profileService, WriteService writeService){
		this.modifyService = modifyService;
		this.profileService = profileService;
		this.writeService = writeService;
	}
	
	@RequestMapping("main")
	public String showProfileUI(){
		return "ProfileUI";
	}
	
	@RequestMapping("modify")
	public String modifyAccount(HttpSession session, Model model){
		if(!model.containsAttribute("modifyStoreForm")){
			Member member = (Member) session.getAttribute("member");
			MemberInfo memberInfo = modifyService.selecyByEmail(member.getEmail());
			ModifyStoreForm modifyStoreForm = modifyService.setModifyStoreForm(memberInfo, member);
			
			model.addAttribute("modifyStoreForm", modifyStoreForm);
		}
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
		
		return "modify";
	}
	
	@RequestMapping("modifyProcess")
	public String modifyProcess(ModifyStoreForm modifyStoreForm, Errors errors, HttpServletRequest request, FileVo fileVo, HttpSession session, Model model){
		String originalEmail = request.getParameter("originalEmail");
		String originalPasswd = request.getParameter("originalPasswd");
		String originalNickname = request.getParameter("originalNickname");
		
		modifyStoreForm.setEmailChanged(modifyService.compareEmail(originalEmail, modifyStoreForm.getEmail()));
		modifyStoreForm.setPasswdChanged(modifyService.comparePasswd(originalPasswd, modifyStoreForm.getPasswd()));
		modifyStoreForm.setNicknameChanged(modifyService.compareNickname(originalNickname, modifyStoreForm.getNickname()));
		
		new ModifyStoreFormValidator().validate(modifyStoreForm, errors);
		if(errors.hasErrors()){
			FieldError fieldError = errors.getFieldError();
			if(fieldError.getField().equals("email"))
				modifyStoreForm.setEmail(originalEmail);
			else if(fieldError.getField().equals("passwd"))
				modifyStoreForm.setPasswd(originalPasswd);
			else if(fieldError.getField().equals("nickname"))
				modifyStoreForm.setNickname(originalNickname);
			
			return modifyAccount(session, model);
		}
		
		try{
			if(modifyStoreForm.getEmailChanged())
				modifyService.checkEmail(modifyStoreForm.getEmail());
			if(modifyStoreForm.getNicknameChanged())
				modifyService.checkNickName(modifyStoreForm.getNickname());
			if(!fileVo.getPictureFile().isEmpty())
				modifyStoreForm.setPicture(fileVo.getPictureFile().getBytes());
			//else
				//비어있다면 원래 사진을 넣는 방식...?
		} catch(AlreadyExistAccountException e){//modifyService.checkEmail에서 발생
			e.printStackTrace();
			errors.rejectValue("email", "alreadyExistEmail");
			return modifyAccount(session, model);
		} catch(AlreadyExistNicknameException e){//modifyService.checkNickName에서 발생
			e.printStackTrace();
			errors.rejectValue("nickname", "alreadyExistNickname");
			return modifyAccount(session, model);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return modifyAccount(session, model);
		}
		
		modifyService.updateAccount(modifyStoreForm, originalEmail);
		
		return modifyAccount(session, model);
	}
	
	@RequestMapping("deleteProcess")
	public String deleteAccount(HttpSession session){
		Member member = (Member) session.getAttribute("member");
		modifyService.deleteAccount(member.getEmail());
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping("write")
	public String write(Model model){
		model.addAttribute("writeForm", new WriteForm());
		return "write";
	}
	
	@RequestMapping("writeProcess")
	public String writeProcess(WriteForm writeForm, Errors errors,HttpServletRequest request,HttpSession session,FileVo fileVo){
		new WriteFormValidator().validate(writeForm, errors);
		if(errors.hasErrors())
			return "write";
		
		writeService.setWriteForm(writeForm, request, session, fileVo);
		
			try {
				if(!fileVo.getPictureFile().isEmpty())
					writeForm.setPicture(fileVo.getPictureFile().getBytes());
				if(!fileVo.getVideoFile().isEmpty())
					writeForm.setVideo(fileVo.getVideoFile().getBytes());
				
				writeService.insertContets(writeForm);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return "redirect:/Profile/drawer";
	}
	
	@RequestMapping()
	public String drawer(){
		return "ProfileUI";
	}
	
	@RequestMapping("getProfileImage")
	public ResponseEntity<byte[]> getProfileImage(HttpSession session){
		byte[] image = null;
		
		Member member = (Member) session.getAttribute("member");
		String nickname = member.getNickname();
		Map<String, Object> hashMap = profileService.getProfileImage(nickname);
		if(hashMap != null)
			image = (byte[]) hashMap.get("picture");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(image, httpHeaders, HttpStatus.OK);
	}
}