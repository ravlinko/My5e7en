package com.my5e7en.web.my5e7en.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER" )
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(nullable = false)
	private String phone;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private SecurityRole role;
	@Column(name = "password", nullable = false)
	private String password;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="company_id")
	private Company company;

	@OneToMany(mappedBy="owner")
	private List<Report> reports;

	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public SecurityRole getRole() {
		return role;
	}

	public User setRole(SecurityRole role) {
		this.role = role;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public Company getCompany() {
		return company;
	}

	public User setCompany(Company company) {
		this.company = company;
		if (!company.getUsers().contains(this)) {
			company.addUser(this);
		}
		return this;
	}

	public List<Report> getReports() {
		return reports;
	}

	public User addReport(Report report) {
		this.reports.add(report);
		if (!report.getOwner().equals(this)) {
			report.setOwner(this);
		}
		if (!company.getReports().contains(report)) {
			company.addReport(report);
		}
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;

		User user = (User) o;

		if (!getId().equals(user.getId())) return false;
		return getEmail().equals(user.getEmail());
	}

	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getEmail().hashCode();
		return result;
	}

}
