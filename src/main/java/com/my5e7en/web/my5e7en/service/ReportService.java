package com.my5e7en.web.my5e7en.service;

import com.my5e7en.web.my5e7en.controller.dto.ReportCreateFormDto;
import com.my5e7en.web.my5e7en.entity.Report;

public interface ReportService extends My5e7enService<Report, Long> {

	Report create(ReportCreateFormDto reportCreateFormDto);

	Report update(Long id, ReportCreateFormDto reportCreateFormDto);
}
