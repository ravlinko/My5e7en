package com.my5e7en.web.my5e7en.repository;


import com.my5e7en.web.my5e7en.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByEmail(String email);
}
