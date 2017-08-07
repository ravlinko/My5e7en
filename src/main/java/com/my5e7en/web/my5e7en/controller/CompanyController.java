package com.my5e7en.web.my5e7en.controller;

import com.my5e7en.web.my5e7en.controller.dto.CompanyCreateFormDto;
import com.my5e7en.web.my5e7en.entity.Company;
import com.my5e7en.web.my5e7en.entity.SecurityRole;
import com.my5e7en.web.my5e7en.entity.User;
import com.my5e7en.web.my5e7en.service.CompanyService;
import com.my5e7en.web.my5e7en.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

import javax.validation.Valid;

@Controller
@RequestMapping("/companies")
public class CompanyController {

	private CompanyService companyService;
	private final UserService userService;

	@Autowired
	public CompanyController(CompanyService companyService, UserService userService) {
		this.companyService = companyService;
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(final Principal principal) {
		User user = userService.getUserByEmail(principal.getName());
		if (user.getRole().equals(SecurityRole.ADMIN)) {
			return new ModelAndView(getViewsPrefix().concat("/index"), getListModelName(), companyService.getAll());
		} else if (user.getRole().equals(SecurityRole.COMPANY_OWNER)) {
			return new ModelAndView(getViewsPrefix().concat("/index"), "company", user.getCompany());
		}
		throw new UnsupportedOperationException();
	}

	@RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		final Company company = companyService.getById(id);
		return new ModelAndView(getViewsPrefix().concat("/edit"), "form", new CompanyCreateFormDto()
				.setId(Long.toString(id))
				.setName(company.getName())
				.setEmail(company.getEmail())
				.setAddress(company.getAddress()))
				.addObject("users", company.getUsers())
				.addObject("reports", company.getReports());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@ModelAttribute("form") CompanyCreateFormDto form) {
		companyService.create(form);
		return "redirect:/companies";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.POST)
	public String update(@PathVariable Long id, @Valid @ModelAttribute("form") CompanyCreateFormDto form) {
		companyService.update(id, form);
		return "redirect:/companies";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView createPage() {
		return new ModelAndView(getViewsPrefix().concat("/create"), "form", new CompanyCreateFormDto());
	}

	private String getViewsPrefix() {
		return "companies";
	}

	private String getListModelName() {
		return "companies";
	}

}
