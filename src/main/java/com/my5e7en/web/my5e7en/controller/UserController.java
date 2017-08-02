package com.my5e7en.web.my5e7en.controller;

import com.my5e7en.web.my5e7en.controller.dto.UserCreateFormDto;
import com.my5e7en.web.my5e7en.controller.dto.UserDto;
import com.my5e7en.web.my5e7en.controller.validator.UserCreateFormValidator;
import com.my5e7en.web.my5e7en.entity.User;
import com.my5e7en.web.my5e7en.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private final UserService userService;
	@Autowired
	private final UserCreateFormValidator userCreateFormValidator;

	@Autowired
	public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
		this.userService = userService;
		this.userCreateFormValidator = userCreateFormValidator;
	}

	@InitBinder("form")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userCreateFormValidator);
	}

	//	@PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)" )
	@RequestMapping("/{id}")
	public ModelAndView getUserPage(@PathVariable Long id) {
		return new ModelAndView("user", "user", Optional.ofNullable(userService.getById(id))
				.orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
	}

	//	@PreAuthorize("hasAuthority('ADMIN')" )
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage() {
		return new ModelAndView("users/create", "form", new UserCreateFormDto());
	}

	//	@PreAuthorize("hasAuthority('ADMIN')" )
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateFormDto form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "users/create";
		}
		try {
			userService.create(form);
		} catch (DataIntegrityViolationException e) {
			bindingResult.reject("email.exists", "Email already exists");
			return "users/create";
		}
		return "redirect:/users";
	}

	@RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
	private ModelAndView editPage(@PathVariable Long id) {
		final User user = userService.getById(id);
		return new ModelAndView("users/edit", "form", new UserCreateFormDto()
				.setId(Long.toString(id))
				.setEmail(user.getEmail())
				.setFirstName(user.getFirstName())
				.setLastName(user.getLastName())
				.setPhone(user.getPhone())
				.setRole(user.getRole().toString())).addObject("reports", user.getReports());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String edit(@PathVariable Long id, @ModelAttribute("form") UserCreateFormDto form) {
		userService.update(id, form);
		return "redirect:/users";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registrationPage() {
		UserCreateFormDto newUser = new UserCreateFormDto();
		return new ModelAndView("registration", "form", newUser);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String signUp(@Valid @ModelAttribute("form") UserCreateFormDto user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		try {
			userService.create(user);
		} catch (DataIntegrityViolationException e) {
			bindingResult.reject("email.exists", "Email already exists");
			return "registration";
		}
		return "redirect:/";
	}
}
