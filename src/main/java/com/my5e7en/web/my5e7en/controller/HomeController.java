package com.my5e7en.web.my5e7en.controller;

import com.my5e7en.web.my5e7en.entity.User;
import com.my5e7en.web.my5e7en.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String getHomePage() {
		return "redirect:/dashboard";
	}

	@RequestMapping("/dashboard")
	public ModelAndView dashboard(final Principal principal) {
		final User user = userService.getUserByEmail(principal.getName());
		return new ModelAndView("index", "user", user)
				.addObject("reports", user.getReports());
	}
}
