package com.my5e7en.web.my5e7en.controller.dto;


import com.my5e7en.web.my5e7en.entity.SecurityRole;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class UserDto implements My5e7enDto {
	private String id;

	@NotEmpty
	private String firstName = "";

	@NotEmpty
	private String lastName = "";

	@NotEmpty
	private String email = "";

	@NotEmpty
	private String phone = "";

	@NotNull
	private String role = SecurityRole.COMPANY_EMPLOYER.toString();

	public String getId() {
		return id;
	}

	public UserDto setId(String id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public UserDto setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public UserDto setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserDto setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public UserDto setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getRole() {
		return role;
	}

	public UserDto setRole(String role) {
		this.role = role;
		return this;
	}
}
