package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import command.PwdChange;

public class PwdChangeValidator implements Validator{
	
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return PwdChange.class.isAssignableFrom(arg0);
	}//supports(Class<?> arg0)
	
	@Override
	public void validate(Object target, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword","required");
		ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
	}

}
