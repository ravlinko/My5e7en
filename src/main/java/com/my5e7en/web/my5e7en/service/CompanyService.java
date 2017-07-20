package com.my5e7en.web.my5e7en.service;


import com.my5e7en.web.my5e7en.controller.dto.CompanyCreateFormDto;
import com.my5e7en.web.my5e7en.entity.Company;

public interface CompanyService extends My5e7enService<Company, Long> {
	Company create(CompanyCreateFormDto companyCreateFormDto);

	Company update(Long id, CompanyCreateFormDto companyCreateFormDto);
}
