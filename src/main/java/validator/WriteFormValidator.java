package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.WriteForm;

public class WriteFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WriteFormValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		
		WriteForm writeForm = (WriteForm) target;
		if(!errors.hasErrors())
			if(writeForm.getTitle().length() > 20)
				errors.rejectValue("title", "too long title");
		if(!errors.hasErrors())
			if(writeForm.getContent().length() > 100)
				errors.rejectValue("content", "too long title");
	}
}