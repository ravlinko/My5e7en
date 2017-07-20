package com.my5e7en.web.my5e7en.controller;

import com.my5e7en.web.my5e7en.controller.dto.My5e7enDto;

import org.springframework.web.servlet.ModelAndView;

public interface My5e7enController<D extends My5e7enDto> {

	ModelAndView getAll();
}
