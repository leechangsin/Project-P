package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import command.Member;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return MemberValidator.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		//검사대상객체
		Member member = (Member) target;

		//nickname이 비어있다면 검사대상객체의 nickname프로퍼티의 에러코드로 required를 추가
		if (member.getNickname() == null || member.getNickname().trim().isEmpty())
			errors.rejectValue("nickname", "required");
	}
}