package com.my5e7en.web.my5e7en.controller;

import com.my5e7en.web.my5e7en.controller.dto.ReportCreateFormDto;
import com.my5e7en.web.my5e7en.entity.Report;
import com.my5e7en.web.my5e7en.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/reports")
public class ReportController extends DefaultMy5evenController<ReportCreateFormDto, ReportService> {

	@Autowired
	public ReportController(ReportService reportService) {
		super(reportService);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("form") ReportCreateFormDto form) {
		getService().create(form);
		return "redirect:/reports";
	}

	@RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		final Report report = getService().getById(id);
		return new ModelAndView(getViewsPrefix().concat("/edit"), "form", new ReportCreateFormDto()
				.setId(Long.toString(id))
				.setName(report.getName())
				.setData(report.getData()));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.POST)
	public String update(@PathVariable Long id, @Valid @ModelAttribute("form") ReportCreateFormDto form) {
		getService().update(id, form);
		return "redirect:/reports";
	}


	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView createPage() {
		return new ModelAndView(getViewsPrefix().concat("/create"), "form", new ReportCreateFormDto());
	}


	@Override
	public String getViewsPrefix() {
		return "reports";
	}

	@Override
	public String getListModelName() {
		return "reports";
	}

}
