package com.my5e7en.web.my5e7en.controller;

import com.my5e7en.web.my5e7en.controller.dto.UserCreateFormDto;
import com.my5e7en.web.my5e7en.controller.validator.UserCreateFormValidator;
import com.my5e7en.web.my5e7en.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users" )
public class UsersController extends DefaultMy5evenController<UserCreateFormDto, UserService> {
	@Autowired
	public UsersController(UserService userService) {
		super(userService);
	}

	@Override
	public String getViewsPrefix() {
		return "users";
	}

	@Override
	public String getListModelName() {
		return "users";
	}
}
