package com.my5e7en.web.my5e7en.controller;

import com.my5e7en.web.my5e7en.controller.dto.My5e7enDto;
import com.my5e7en.web.my5e7en.service.My5e7enService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public abstract class DefaultMy5evenController<D extends My5e7enDto, S extends My5e7enService> implements My5e7enController<D> {

	private final S service;

	public DefaultMy5evenController(S service) {
		this.service = service;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		return new ModelAndView(getViewsPrefix().concat("/list"), getListModelName(), getService().getAll());
	}

	public abstract String getViewsPrefix();

	public abstract String getListModelName();

	public S getService() {
		return service;
	}
}
