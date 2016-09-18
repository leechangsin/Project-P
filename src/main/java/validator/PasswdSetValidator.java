package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.PasswdSet;

public class PasswdSetValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return PasswdSetValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPasswd", "required");
		
		PasswdSet passwdSet = (PasswdSet) target;
		String passwd = passwdSet.getPasswd();
		String confirmPasswd = passwdSet.getConfirmPasswd();
		if(!passwd.equals(confirmPasswd))
			errors.rejectValue("confirmPasswd", "bedConfirmPasswd");
	}
}