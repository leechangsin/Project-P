package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.ModifyStoreForm;

public class ModifyStoreFormValidator implements Validator{
	private static final String emailRegEx =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	
	public ModifyStoreFormValidator(){
		pattern = Pattern.compile(emailRegEx);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ModifyStoreFormValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ModifyStoreForm modifyStoreForm = (ModifyStoreForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		if (!errors.hasErrors()) {
			Matcher matcher = pattern.matcher(modifyStoreForm.getEmail());
			if (!matcher.matches())
				errors.rejectValue("email", "bedEmail");
		} else if (!errors.hasErrors())
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", "required");
		else if (!errors.hasErrors()) {
			if (modifyStoreForm.getPasswdChanged()) {
				String passwd = modifyStoreForm.getPasswd();
				String confirmPasswd = modifyStoreForm.getConfirmPasswd();
				if (!passwd.equals(confirmPasswd))
					ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", "bedConfirmPasswd");
			}
		} else if (!errors.hasErrors())
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickname", "required");
		else if (!errors.hasErrors())
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "intro", "required");
	}
}