package com.my5e7en.web.my5e7en.controller.dto;

import com.my5e7en.web.my5e7en.entity.User;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class CompanyCreateFormDto implements My5e7enDto {

	private String id;

	@NotEmpty
	private String name = "";

	@NotEmpty
	private String email = "";

	@NotEmpty
	private String address = "";

	@NotEmpty
	private List<User> employers;

	public String getId() {
		return id;
	}

	public CompanyCreateFormDto setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public CompanyCreateFormDto setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public CompanyCreateFormDto setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public CompanyCreateFormDto setAddress(String address) {
		this.address = address;
		return this;
	}

	public List<User> getEmployers() {
		return employers;
	}

	public CompanyCreateFormDto setEmployers(List<User> employers) {
		this.employers = employers;
		return this;
	}
}