package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.Member;
import command.MemberInfo;
import dao.MemberDao;
import service.SignUpEmailService;
import validator.MemberInfoValidator;
import validator.MemberValidator;

@Controller
@RequestMapping("/regist")
public class RegistUI_Controller {
	private SignUpEmailService signUpEmailService;
	private MemberDao memberDao;
	
	public RegistUI_Controller(SignUpEmailService singUpEmailService, MemberDao memberDao){
		this.signUpEmailService = singUpEmailService;
		this.memberDao = memberDao;
	}

	@RequestMapping("main")
	public String showRegistUI() {
		return "RegistUI";
	}

	/*
	 * 각 step에서 보여지는 뷰 페이지
	 * step1 = 약관동의, step2 = 회원 개인정보 입력, step3 = 회원 계정정보 입력, step4 = 가입완료
	 * 
	 * 각 STEP을 넘어간 후에 각 STEP에서 요구하는 값을 검사함
	 * step1에서 약관동의 화면이 보여지지만 약관동의를 눌렀는지 안눌렀는지는 step2에서 검사함
	 * step2에서 DB의 memberInfo(회원 개인정보)의 내용을 입력하지만 memberInfo에 필요한 내용을 모두 입력하였는지
	 * 아닌지는 step3에서 검사함
	 */
	
	//step1 = 약관동의 화면을 보여줌
	@RequestMapping(value = "SignUpEmail/step1")
	public String SignUpEmailStep1() {
		return "SignUpEmailStep1";
	}
	
	/* step2 = 회원 개인정보를 입력하는 화면을 보여줌
	 * 그와 동시에 step1(약관동의 화면)에서 2개의 약관에 동의를 했나 안했나 검사
	 * 하나라도 약관동의를 하지 않았다면 step1로 돌아감
	 */
	@RequestMapping("SignUpEmail/step2")
		public String SignUpEmailStep2(@RequestParam(value="agree1", defaultValue="false") Boolean agree1,
				@RequestParam(value="agree2", defaultValue="false") Boolean agree2, Model model){
			if(!agree1 || !agree2)
				return "redirect:/regist/main";
			
			//step2에서 쓸 커맨드객체 생성 및 전달
			model.addAttribute("memberInfo", new MemberInfo());
			return "SignUpEmailStep2";
		}
	
	/* step3 = 회원 계정정보를 입력하는 화면을 보여줌
	 * 그와 동시에 step2(회원 개인정보입력 화면)에서 개인정보를 하나라도 입력하지 않았다면 step2로 돌아감
	 * 개인정보를 모두 입력했다면 DB에 개인정보 저장
	 */
	@RequestMapping("SignUpEmail/step3")
	public String SignUpEmailStep3(MemberInfo memberInfo, Errors error){
		//커맨드 객체값 검증
		new MemberInfoValidator().validate(memberInfo, error);
		//검증에서 에러가 발생했다면 step2로 이동
		if(error.hasErrors())
			return "SignUpEmailStep2";
		//에러가 발생하지 않았다면 오늘 날짜를 불러와서 memberInfo에 삽입
		Date toDay = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		memberInfo.setReg_date(sdf.format(toDay));
		//DB에 사용자가 입력한 개인정보 저장
		signUpEmailService.signUpMemberInfo(memberInfo);
		
		return "SignUpEmailStep3";
	}
	
	/* step4 = 가입성공 여부를 보여주는 화면
	 * 그와 동시에 step3(회원 계정정보입력 화면)에서 nickname을 입력하지 않았다면 step3로 돌아감
	 * nickname을 입력했다면 DB에 닉네임, 자기소개, 사진을 저장
	 */
	@RequestMapping("SignUpEmail/step4")
	public String SignUpEmailStep4(Member member, Errors error, FileVo fileVo){
		//커멘드 객체값 검증
		new MemberValidator().validate(member, error);
		//검증에서 에러가 발생했다면 step3로 이동
		if(error.hasErrors())
			return "SignUpEmailStep3";
		
		//SignUpEmailStep3뷰에서 사용자가 사진을 업로드하였다면 사진을 DB에 업로드함
		try {
			Map<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("picture", fileVo.getPictureFile().getBytes());
			memberDao.savePicture(hashMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "SignUpEmailStep4";
	}

	/*
	@RequestMapping("SignUpKaKao")
	public void SingUpKaKao(){
		
	}
	@RequestMapping("SignUpFaceBook")
	public void SingUpFaceBook(){
		
	}
	*/
}
