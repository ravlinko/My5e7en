package com.my5e7en.web.my5e7en.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY")
@Data
@EqualsAndHashCode
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

    @OneToMany(mappedBy = "company")
    private List<User> users;

    @OneToMany(mappedBy = "company")
    private List<Report> reports;

    public Company addUser(User user) {
        this.users.add(user);
        if (user.getCompany() != this) {
            user.setCompany(this);
        }
        return this;
    }

    public Company addReport(Report report) {
        this.reports.add(report);
        if (!report.getCompany().equals(this)) {
            report.setCompany(this);
        }
        return this;
    }
}
