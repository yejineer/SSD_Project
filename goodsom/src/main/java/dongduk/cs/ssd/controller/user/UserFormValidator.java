package dongduk.cs.ssd.controller.user;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import dongduk.cs.ssd.domain.User;

/**
 * @author Yejin Lee
 * @since 2020.05.07
 */
public class UserFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object obj, Errors errors) {
		UserForm userForm = (UserForm)obj; 
		User user = userForm.getUser();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.email", "EMAIL_REQUIRED", "Email is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.userName", "USER_NAME_REQUIRED", "User name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.nickName", "NICKNAME_REQUIRED", "Nickname is required.");
		
		if (userForm.isNewUser()) {
//			user.setStatus("OK");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.username", "USER_ID_REQUIRED", "User ID is required.");
			if (user.getPasswd() == null || user.getPasswd().length() < 1 ||
					!user.getPasswd().equals(userForm.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH",
					 "Passwords did not match or were not provided. Matching passwords are required.");
			}
		}
		else if (user.getPasswd() != null && user.getPasswd().length() > 0) {
			if (!user.getPasswd().equals(userForm.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH", "Passwords did not match. Matching passwords are required.");
			}
		}
	}
}
