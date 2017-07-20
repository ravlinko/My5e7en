package com.my5e7en.web.my5e7en.service;

import com.my5e7en.web.my5e7en.controller.dto.ReportCreateFormDto;
import com.my5e7en.web.my5e7en.entity.Report;
import com.my5e7en.web.my5e7en.repository.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultReportService extends DefaultService<Report, Long> implements ReportService {
	@Autowired
	public DefaultReportService(ReportRepository repository) {
		super(repository);
	}

	@Override
	public Report create(ReportCreateFormDto reportCreateFormDto) {
		final Report report = new Report()
				.setName(reportCreateFormDto.getName())
				.setData(reportCreateFormDto.getData());
		return getRepository().save(report);
	}

	@Override
	public Report update(Long id, ReportCreateFormDto reportCreateFormDto) {
		final Report report = getById(id)
				.setName(reportCreateFormDto.getName())
				.setData(reportCreateFormDto.getData());
		return getRepository().save(report);
	}


}
