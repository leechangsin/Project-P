package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import command.MemberInfo;


public class MemberInfoValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return MemberInfoValidator.class.isAssignableFrom(arg0);
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
		//birth_date가 비어있다면 검사대상객체의 birth_date프로퍼티의 에러코드로 required를 추가
		if(memberInfo.getBirth_date() == null || memberInfo.getBirth_date().trim().isEmpty())
			errors.rejectValue("birth_date", "required");
		//sex가 비어있다면검사대상객체의 sex프로퍼티의 에러코드로 required를 추가
		if(memberInfo.getSex() == null || memberInfo.getSex().trim().isEmpty())
			errors.reject("sex", "required");
	}//validate(Object target, Errors errors)
} //class LoginRequestValidator