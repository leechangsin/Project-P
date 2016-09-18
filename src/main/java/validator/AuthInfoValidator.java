package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.AuthInfo;

public class AuthInfoValidator implements Validator {
	//이메일 형식을 검사하기 위한 정규표현식
	private static final String emailRegEx =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	
	public AuthInfoValidator(){
		pattern = Pattern.compile(emailRegEx);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return AuthInfoValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		AuthInfo authInfo = (AuthInfo) target;
		//이메일이 입력되지 않았거나 공백문자로만 되어있다면 authInfo커맨드 객체의 email프로퍼티에 required 에러를 달아줌
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		//이메일의 형식을 검사하기 위한 절차
		if (!errors.hasErrors()) {
			Matcher matcher = pattern.matcher(authInfo.getEmail());
			if (!matcher.matches())
				errors.rejectValue("email", "bedEmail");
		}
		if(! errors.hasErrors())
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", "required");
	}

}
