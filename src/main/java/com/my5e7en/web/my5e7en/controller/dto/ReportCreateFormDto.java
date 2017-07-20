package com.my5e7en.web.my5e7en.controller.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class ReportCreateFormDto implements My5e7enDto {

	private String id;

	@NotEmpty
	private String name = "";

	@NotEmpty
	private String data = "";

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public ReportCreateFormDto setId(String id) {
		this.id = id;
		return this;
	}

	public ReportCreateFormDto setName(String name) {
		this.name = name;
		return this;
	}

	public String getData() {
		return data;
	}

	public ReportCreateFormDto setData(String data) {
		this.data = data;
		return this;
	}
}