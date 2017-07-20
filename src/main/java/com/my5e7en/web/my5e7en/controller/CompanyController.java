package com.my5e7en.web.my5e7en.controller;

import com.my5e7en.web.my5e7en.controller.dto.CompanyCreateFormDto;
import com.my5e7en.web.my5e7en.entity.Company;
import com.my5e7en.web.my5e7en.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/companies")
public class CompanyController extends DefaultMy5evenController<CompanyCreateFormDto, CompanyService> {

	@Autowired
	public CompanyController(CompanyService companyService) {
		super(companyService);
	}

	@RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		final Company company = getService().getById(id);
		return new ModelAndView(getViewsPrefix().concat("/edit"), "form", new CompanyCreateFormDto()
				.setId(Long.toString(id))
				.setName(company.getName())
				.setEmail(company.getEmail())
				.setAddress(company.getAddress()))
				.addObject("users", company.getUsers())
				.addObject("reports", company.getReports());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("form") CompanyCreateFormDto form) {
		getService().create(form);
		return "redirect:/companies";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.POST)
	public String update(@PathVariable Long id, @Valid @ModelAttribute("form") CompanyCreateFormDto form) {
		getService().update(id, form);
		return "redirect:/companies";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView createPage() {
		return new ModelAndView(getViewsPrefix().concat("/create"), "form", new CompanyCreateFormDto());
	}

	@Override
	public String getViewsPrefix() {
		return "companies";
	}

	@Override
	public String getListModelName() {
		return "companies";
	}

}
