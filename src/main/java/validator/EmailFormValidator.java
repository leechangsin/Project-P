package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.EmailForm;

public class EmailFormValidator implements Validator {
	// 이메일 형식을 검사하기 위한 정규표현식
	private static final String firstEmailRegEx = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*";
	private static final String secondEmailRegEx = "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern firstEmailPattern;
	private Pattern secondEmailPattern;

	public EmailFormValidator() {
		firstEmailPattern = Pattern.compile(firstEmailRegEx);
		secondEmailPattern = Pattern.compile(secondEmailRegEx);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return EmailFormValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		EmailForm emailForm = (EmailForm) target;
		Matcher firstEmailMatcher = firstEmailPattern.matcher(emailForm.getFirstEmail());
		Matcher secondEmailMatcher = secondEmailPattern.matcher(emailForm.getSecondEmail());
		//이메일 주소입력 중 @ 앞과 뒤의 입력란에 입력하지 않았거나 공백, 화이트스페이스로만 이루어져있다면 커맨드 객체자체에 에러코드(글로벌에러코드)를 부착
		if(emailForm.getFirstEmail() == null || emailForm.getFirstEmail().trim().isEmpty()){
			errors.reject("required");
		} else if(emailForm.getSecondEmail() == null || emailForm.getSecondEmail().trim().isEmpty()){
			errors.reject("required");
		} //이메일 입력은 하였지만 형식에 맞지 않는다면 글로벌에러코드를 부착
		  else if(!firstEmailMatcher.matches()){ 
			errors.reject("bedEmail");
		} else if(!secondEmailMatcher.matches()){
			errors.reject("bedEmail");
		}
	}// end validate(Object target, Errors errors)
}