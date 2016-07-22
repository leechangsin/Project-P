package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import table.MemberInfo;


public class LoginRequestValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return LoginRequestValidator.class.isAssignableFrom(arg0);
	}//supports(Class<?> arg0)

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		//검사대상객체
		MemberInfo memberInfo = (MemberInfo) target;
		
		//email이 비어있다면 검사대상객체의 email프로퍼티의 에러코드로 required를 추가
		if (memberInfo.getEmail() == null || memberInfo.getEmail().trim().isEmpty())
			errors.rejectValue("email", "required");
		//password가 비어있다면 검사대상객체의 password프로퍼티의 에러코드로 required를 추가
		if(memberInfo.getPasswd() == null || memberInfo.getPasswd().trim().isEmpty())
			errors.rejectValue("passwd", "required");
		
	}//validate(Object target, Errors errors)
} //class LoginRequestValidator