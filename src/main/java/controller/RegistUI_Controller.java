package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.Member;
import command.MemberInfo;
import command.RequestType;
import exceptions.AlreadyExistAccountException;
import exceptions.AlreadyExistNicknameException;
import service.SignUpEmailService;
import validator.MemberInfoValidator;
import validator.MemberValidator;

@Controller
@RequestMapping("/regist")
public class RegistUI_Controller {
	private SignUpEmailService signUpEmailService;

	public RegistUI_Controller(SignUpEmailService singUpEmailService) {
		this.signUpEmailService = singUpEmailService;
	}

	@RequestMapping("main")
	public String showRegistUI() {
		return "RegistUI";
	}

	/*
	 * 각 step에서 보여지는 뷰 페이지 
	 * step1 = 약관동의, step2 = 회원 개인정보 입력, step3 = 회원 계정정보 입력, step4 = 가입완료
	 * 
	 * 각 STEP을 넘어간 후에 각 STEP에서 요구하는 값을 검사함 step1에서 약관동의 화면이 보여지지만 
	 * 약관동의를 눌렀는지 안눌렀는지는 step2에서 검사함 
	 * step2에서 DB의 memberInfo(회원 개인정보)의 내용을 입력하지만 
	 * memberInfo에 필요한 내용을 모두 입력하였는지 아닌지는 step3에서 검사함
	 */

	// step1 = 약관동의 화면을 보여줌
	@RequestMapping(value = "SignUpEmail/step1")
	public String SignUpEmailStep1() {
		return "SignUpEmailStep1";
	}

	/*
	 * step2 = 회원 개인정보를 입력하는 화면을 보여줌 그와 동시에 step1(약관동의 화면)에서 
	 * 2개의 약관에 동의를 했나 안했나 검사함. 하나라도 약관동의를 하지 않았다면 step1로 돌아감
	 */
	@RequestMapping("SignUpEmail/step2")
	public String SignUpEmailStep2(@RequestParam(value = "agree1", defaultValue = "false") Boolean agree1,
			@RequestParam(value = "agree2", defaultValue = "false") Boolean agree2, Model model) {
		if (!agree1 || !agree2)
			return "redirect:/regist/main";

		// step2에서 쓸 커맨드객체 생성 및 전달
		model.addAttribute("memberInfo", new MemberInfo());
		return "SignUpEmailStep2";
	}
	
	/*
	 * step3 = 회원 계정정보를 입력하는 화면을 보여줌 그와 동시에 step2(회원 개인정보입력 화면)에서 개인정보를 하나라도
	 * 입력하지 않았다면 step2로 돌아감 개인정보를 모두 입력했다면 DB에 개인정보 저장
	 */
	@RequestMapping("SignUpEmail/step3")
	public String SignUpEmailStep3(MemberInfo memberInfo, Errors error, HttpSession session, Model model) {
		// 커맨드 객체값 검증
		new MemberInfoValidator().validate(memberInfo, error);
		// 검증에서 에러가 발생했다면 step2로 이동
		if (error.hasErrors())
			return "SignUpEmailStep2";
		// 개인정보를 모두 입력했지만 이메일 중복검사를 해야한다.
		// 이메일 중복 검사하는 단계
		try {
			// 이메일 중복이 발생된다면 예외가 발생되므로 try, catch문을 사용
			signUpEmailService.checkEmail(memberInfo.getEmail());
		} catch (AlreadyExistAccountException e) {
			// 이메일 중복이 발생됬다면 커맨드 객체의 email프로퍼티 AlreadyExist에러코드를 달아줌
			error.rejectValue("email", "alreadyExistEmail");
			return "SignUpEmailStep2";
		}

		// 에러가 발생하지 않았다면 오늘 날짜를 불러와서 memberInfo에 삽입
		Date toDay = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		memberInfo.setReg_date(sdf.format(toDay));

		// step3에서 member커맨드 객체를 사용하므로 커맨드 객체를 생성해서 모델로 넘겨줌
		model.addAttribute("member", new Member());
		// step4에서 회원가입을 진행하기 위해 session에 memberInfo를 담아서 전달
		session.setAttribute("memberInfo", memberInfo);

		return "SignUpEmailStep3";
	}
	
	/*
	 * step4 = 가입성공 여부를 보여주는 화면 그와 동시에 step3(회원 계정정보입력 화면)에서 nickname을 입력하지 않았다면
	 * step3로 돌아감 nickname을 입력했다면 DB에 닉네임, 자기소개, 사진을 저장
	 */
	@RequestMapping("SignUpEmail/step4")
	public String SignUpEmailStep4(Member member, Errors error, FileVo fileVo, Model model, HttpSession session) {
		// 커멘드 객체값 검증
		new MemberValidator().validate(member, error);
		// 검증에서 에러가 발생했다면 step3로 이동
		/* 이 메서드에서 오류가 발생함 오류의 이유는 모름.
		if (error.hasErrors())
			return "SignUpEmailStep3";
		*/
		// 닉네임 중복검사
		try {
			signUpEmailService.checkNickname(member.getNickname(), RequestType.signUpMember);
		} catch (AlreadyExistNicknameException e) {
			error.rejectValue("nickname", "alreadyExistNickname");
			return "SignUpEmailStep3";
		}

		/*
		 * 미구현, 우선 사진이 없는 상태에서 DB에 업로드가 성공된 뒤에 구현하기 //SignUpEmailStep3뷰에서 사용자가
		 * 사진을 업로드하였다면 사진을 DB에 업로드함 try { Map<String, Object> hashMap = new
		 * HashMap<String, Object>(); hashMap.put("picture",
		 * fileVo.getPictureFile().getBytes()); memberDao.savePicture(hashMap);
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");

		// 사용자가 입력한 개인정보를 DB에 저장
		signUpEmailService.signUpMemberInfo(memberInfo);

		// 사용자가 입력한 계정정보를 DB에 저장
		member.setEmail(memberInfo.getEmail());
		signUpEmailService.signUpMember(member);

		// xxx님 회원가입에 성공했습니다. 라고 뷰에 출력하기 위해 model로 전달
		model.addAttribute("nickName", member.getNickname());

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
