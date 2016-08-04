package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.Contents;
import command.PwdChange;
import dao.ContentsDao;
import validator.PwdChangeValidator;


@Controller
@RequestMapping("/edit/changePassword")
public class PwdChange_Controller {

	private ChangePasswordService changePasswordService;

	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("command")PwdChange pwdCmd){
		return "edit/changePwdFrom";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command")PwdChange pwdCmd,Errors errors, HttpSession session){
		new PwdChangeValidator().validate(pwdCmd, errors);
		
		if(errors.hasErrors()){
			return "edit/changePwdFrom";
		}
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		try{
			changePasswordService.changePassord(authInfo.getEmail(),
			pwdCmd.getCurrentPassword(),pwdCmd.getNewPassword());
			return "edit/changePwd";
		}catch(IdPasswordNorMatchingException e){
			errors.rejectValue("currentPassword,"notMatching");
			return "edit/changePawForm";
		}
	}
	
}
