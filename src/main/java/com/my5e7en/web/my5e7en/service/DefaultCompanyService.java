package com.my5e7en.web.my5e7en.service;


import com.my5e7en.web.my5e7en.controller.dto.CompanyCreateFormDto;
import com.my5e7en.web.my5e7en.entity.Company;
import com.my5e7en.web.my5e7en.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCompanyService extends DefaultService<Company, Long> implements CompanyService {

	@Autowired
	public DefaultCompanyService(CompanyRepository repository) {
		super(repository);
	}

	@Override
	public Company create(CompanyCreateFormDto companyCreateFormDto) {
		final Company company = new Company()
				.setName(companyCreateFormDto.getName())
				.setEmail(companyCreateFormDto.getEmail())
				.setAddress(companyCreateFormDto.getAddress());
		return getRepository().save(company);
	}

	@Override
	public Company update(Long id, CompanyCreateFormDto companyCreateFormDto) {
		final Company company = getById(id)
				.setName(companyCreateFormDto.getName())
				.setEmail(companyCreateFormDto.getEmail())
				.setAddress(companyCreateFormDto.getAddress());
		return getRepository().save(company);
	}
}
