package com.my5e7en.web.my5e7en.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String getHomePage() {
		return "redirect:/dashboard";
	}
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "index";
	}
}
