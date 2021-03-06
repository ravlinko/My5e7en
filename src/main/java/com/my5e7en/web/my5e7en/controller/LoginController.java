package com.my5e7en.web.my5e7en.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login-error", method = RequestMethod.GET)
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
}