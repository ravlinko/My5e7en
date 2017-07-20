package com.my5e7en.web.my5e7en.controller.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class UserCreateFormDto extends UserDto {

	@NotEmpty
	private String password = "";

	@NotEmpty
	private String passwordRepeated = "";


	public String getPassword() {
		return password;
	}

	public UserCreateFormDto setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public UserCreateFormDto setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
		return this;
	}

}