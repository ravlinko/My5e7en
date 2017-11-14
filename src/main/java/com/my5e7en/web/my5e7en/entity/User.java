package com.my5e7en.web.my5e7en.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@Data
@EqualsAndHashCode
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "owner")
    private List<Report> reports;

    public User setCompany(Company company) {
        this.company = company;
        if (!company.getUsers().contains(this)) {
            company.addUser(this);
        }
        return this;
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
}
