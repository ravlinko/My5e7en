package com.my5e7en.web.my5e7en.controller.validator;

import com.my5e7en.web.my5e7en.controller.dto.UserCreateFormDto;
import com.my5e7en.web.my5e7en.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


@Component
public class UserCreateFormValidator implements Validator {

	private final UserService userService;

	@Autowired
	public UserCreateFormValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UserCreateFormDto.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCreateFormDto form = (UserCreateFormDto) target;
		validatePasswords(errors, form);
		validateEmail(errors, form);
	}

	private void validatePasswords(Errors errors, UserCreateFormDto form) {
		if (!form.getPassword().equals(form.getPasswordRepeated())) {
			errors.reject("password.no_match", "Passwords do not match" );
		}
	}

	private void validateEmail(Errors errors, UserCreateFormDto form) {
		if (Optional.ofNullable(userService.getUserByEmail(form.getEmail())).isPresent()) {
			errors.reject("email.exists", "User with this email already exists" );
		}
	}
}
