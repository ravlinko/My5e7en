package com.my5e7en.web.my5e7en.repository;


import com.my5e7en.web.my5e7en.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}