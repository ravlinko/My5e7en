package com.my5e7en.web.my5e7en.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "REPORT")
@Data
@EqualsAndHashCode
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String data;

	@CreationTimestamp
	@Column(insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User owner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;

	public Report setOwner(User owner) {
		this.owner = owner;
		if (!owner.getReports().contains(this)) {
			owner.addReport(this);
		}
		if (!owner.getCompany().getReports().contains(this)) {
			owner.getCompany().addReport(this);
		}
		return this;
	}

	public Company getCompany() {
		return company;
	}

	public Report setCompany(Company company) {
		this.company = company;
		if (!company.getReports().contains(this)) {
			company.addReport(this);
		}
		return this;
	}
}
