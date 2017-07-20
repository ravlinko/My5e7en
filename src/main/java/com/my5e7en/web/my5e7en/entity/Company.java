package com.my5e7en.web.my5e7en.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String address;

	@OneToMany(mappedBy="company")
	private List<User> users;

	@OneToMany(mappedBy = "company")
	private List<Report> reports;

	public Long getId() {
		return id;
	}

	public Company setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Company setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Company setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Company setAddress(String address) {
		this.address = address;
		return this;
	}

	public List<User> getUsers() {
		return users;
	}

	public Company addUser(User user) {
		this.users.add(user);
		if (user.getCompany() != this) {
			user.setCompany(this);
		}
		return this;
	}

	public List<Report> getReports() {
		return reports;
	}

	public Company addReport(Report report) {
		this.reports.add(report);
		if (!report.getCompany().equals(this)){
			report.setCompany(this);
		}
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Company)) return false;

		Company company = (Company) o;

		if (!getId().equals(company.getId())) return false;
		return getEmail().equals(company.getEmail());
	}

	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getEmail().hashCode();
		return result;
	}
}
