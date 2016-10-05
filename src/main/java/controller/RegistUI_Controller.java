package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * 각 STEP을 넘어간 후에 전 STEP에서 요구하는 값을 검사함 step1에서 약관동의 화면이 보여지지만 
	 * 약관동의를 눌렀는지 안눌렀는지는 step2에서 검사함 
	 * step2에서 DB의 memberInfo(회원 개인정보)의 내용을 입력하지만 
	 * memberInfo에 필요한 내용을 모두 입력하였는지 아닌지는 step3에서 검사함
	 */

	// step1 = 약관동의 화면을 보여줌
	@RequestMapping(value = "SignUpEmail/step1")
	public String SignUpEmailStep1() {
		//약관동의 여부는 뷰에서 input태그의 required속성으로 확인한다.
		return "SignUpEmailStep1";
	}

	/*
	 * step2 = 회원 개인정보를 입력하는 화면을 보여줌 그와 동시에 step1(약관동의 화면)에서 
	 * 2개의 약관에 동의를 했나 안했나 검사함. 하나라도 약관동의를 하지 않았다면 step1로 돌아감
	 */
	@RequestMapping("SignUpEmail/step2")
	public String SignUpEmailStep2(Model model) {
		//step2뷰에서 생년월일 선택에 쓸 년,월,일을 생성하고 전달
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
		
		//step2뷰에서 성별 선택에 쓸 남,여를 생성하고 전달
		List<String> sex = new ArrayList<>();
		sex.add("남자");
		sex.add("여자");
		model.addAttribute("sex", sex);
		
		// step2에서 쓸 커맨드객체 생성 및 전달
		// 이렇게 커맨드 객체를 생성하는 이유는 step3에서 step2때 입력한 memberInfo값을 검증하게되는데
		// 검증에 실패(이메일 공백 또는 중복, 비밀번호 공백 또는 비밀번호 확인란과 불일치)가 발생하면 기존의 입력값을 불러와
		// step2에 표시하고 왜 검증에 실패했는지 사용자에게 보여줘야하기 때문에...
		// 무조건 new MemberInfo()로 넘겨버리면 사용자가 기존에 입력한값, 검증실패이유를 보여주지 못함...
		if(!model.containsAttribute("memberInfo"))
			model.addAttribute("memberInfo", new MemberInfo());
		//최종적으로 원하는 코드는 이메일중복 또는 비밀번호 불일치가 발생하면 이메일 또는 비밀번호를 지우고
		//검증 실패 이유를 띄워주고 싶으나 구현 실패... 현재는 기존의 값이 다 출력되고 검증실패 이유만 노출된다.
		
		return "SignUpEmailStep2";
	}
	
	/*
	 * step3 = 회원 계정정보를 입력하는 화면을 보여줌 그와 동시에 step2(회원 개인정보입력 화면)에서 개인정보를 하나라도
	 * 입력하지 않았다면 step2로 돌아감 개인정보를 모두 입력했다면 DB에 개인정보 저장
	 */
	@RequestMapping("SignUpEmail/step3")
	public String SignUpEmailStep3(MemberInfo memberInfo, Errors error, HttpSession session, Model model) {
		// 커맨드 객체값 검증
		// 정규표현식을 사용해서 이메일, 비밀번호형식을 검사하는 코드를 커맨드 객체값 검증에 추가할 것
		new MemberInfoValidator().validate(memberInfo, error);
		// 검증에서 에러가 발생했다면 step2로 이동
		if (error.hasErrors()){
			return SignUpEmailStep2(model);
		}

		// 이메일 중복 검사하는 단계
		try {
			signUpEmailService.checkEmail(memberInfo.getEmail());
		} catch (AlreadyExistAccountException e) {
			//이메일 중복이 발생됬다면 커맨드 객체의 email프로퍼티 AlreadyExist에러코드를 달아줌
			error.rejectValue("email", "alreadyExistEmail");
			return SignUpEmailStep2(model);
		}
		// 사용자가 입력한 생년월일을 birth_date에 저장
		String year = memberInfo.getYear();
		String month = memberInfo.getMonth();
		String day = memberInfo.getDay();
		if(month.length() == 1)
			month = "0" + month;
		String Birth_date = year + "-" + month + "-" + day;
		memberInfo.setBirth_date(Birth_date);

		// 오늘 날짜를 불러와서 memberInfo에 삽입
		Date toDay = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		memberInfo.setReg_date(sdf.format(toDay));

		// step3에서 member커맨드 객체를 사용하므로 커맨드 객체를 생성해서 모델로 넘겨줌
		// 커맨드 객체를 이렇게 생성하는 이유는 SignUpEmail/step2 참고...
		if(!model.containsAttribute("member"))
			model.addAttribute("member", new Member());
		// step4에서 회원 개인정보,계정정보를 DB에 저장한다.
		// step4에서 회원 개인정보 저장하기 위해 session에 memberInfo를 담아서 전달
		session.setAttribute("memberInfo", memberInfo);

		return "SignUpEmailStep3";
	}
	
	/*
	 * step4 = 가입성공 여부를 보여주는 화면 
	 * 그와 동시에 step3(회원 계정정보입력 화면)에서 nickname을 입력하지 않았다면 step3로 돌아감 
	 * nickname을 입력했다면 DB에 닉네임, 자기소개, 사진을 저장
	 */

	@RequestMapping("SignUpEmail/step4")
	public String SignUpEmailStep4(Member member, Errors error, FileVo fileVo, HttpSession session, Model model) {
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");
		
		//커맨드 객체를 검사해서 값에 빈값이 없는지 검사
		new MemberValidator().validate(member, error);
		if(error.hasErrors())
			return SignUpEmailStep3(memberInfo, error, session, model);
			//return "SignUpEmailStep3";
		// 닉네임 중복검사
		try {
			signUpEmailService.checkNickname(member.getNickname(), RequestType.signUpMember);
		} catch (AlreadyExistNicknameException e) {
			error.rejectValue("nickname", "alreadyExistNickname");
			return SignUpEmailStep3(memberInfo, error, session, model);
			//return "SignUpEmailStep3";
		}

		try {
			if(!fileVo.getPictureFile().isEmpty())
				member.setPicture(fileVo.getPictureFile().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 사용자가 입력한 개인정보를 DB에 저장
		signUpEmailService.signUpMemberInfo(memberInfo);
		// 사용자가 입력한 계정정보를 DB에 저장
		member.setEmail(memberInfo.getEmail());
		signUpEmailService.signUpMember(member);
		
		session.setAttribute("member", member);
		
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