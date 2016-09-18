package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.MemberInfo;

public class MemberInfoValidator implements Validator {
	//이메일 형식을 검사하기 위한 정규표현식
	private static final String emailRegEx =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	
	public MemberInfoValidator(){
		pattern = Pattern.compile(emailRegEx);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MemberInfoValidator.class.isAssignableFrom(clazz);
	}//supports(Class<?> arg0)

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		//검사대상객체
		MemberInfo memberInfo = (MemberInfo) target;
		//이메일이 입력되지 않았거나 공백문자로만 되어있다면 memberInfo커맨드 객체의 email프로퍼티에
		//required 에러를 달아줌
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		//이메일의 형식을 검사하기 위한 절차
		if(!errors.hasErrors()){
			Matcher matcher = pattern.matcher(memberInfo.getEmail());
			if(!matcher.matches())
				errors.rejectValue("email", "bedEmail");
		}
		//커맨드 객체의 비밀번호, 비밀번호 확인란의 값 검증
		if(!errors.hasErrors())
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", "required");
		if(!errors.hasErrors())
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPasswd", "required");
		//비밀번호와 비밀번호 확인란의 값이 같지 않다면...
		if(!errors.hasErrors())
			if(!memberInfo.getPasswd().equals(memberInfo.getConfirmPasswd()))
				errors.rejectValue("confirmPasswd", "bedConfirmPasswd");
	}//validate(Object target, Errors errors)
} //class LoginRequestValidator