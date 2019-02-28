package com.my5e7en.web.my5e7en.repository;

import com.my5e7en.web.my5e7en.entity.SecurityRole;
import com.my5e7en.web.my5e7en.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindOneUserByEmail() {
        User admin = new User();
        admin.setFirstName("John");
        admin.setLastName("Doe");
        admin.setPhone("0000000000");
        admin.setEmail("admin@unittest");
        admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
        admin.setRole(SecurityRole.ADMIN);
        admin.setReports(Collections.emptyList());
        final User savedAdmin = userRepository.save(admin);

        User user = new User();
        user.setFirstName("Jessica");
        user.setLastName("Doe");
        user.setPhone("0000000001");
        user.setEmail("employee@unittest");
        user.setPassword(new BCryptPasswordEncoder().encode("employee"));
        user.setRole(SecurityRole.COMPANY_EMPLOYER);
        userRepository.save(user);

        User retrievedAdmin = userRepository.findOneByEmail("admin@unittest");

        assertEquals("First name", savedAdmin.getFirstName(), retrievedAdmin.getFirstName());
        assertEquals("Last name", savedAdmin.getLastName(), retrievedAdmin.getLastName());
        assertEquals("Phone", savedAdmin.getPhone(), retrievedAdmin.getPhone());
        assertEquals("Email", savedAdmin.getEmail(), retrievedAdmin.getEmail());
        assertEquals("Password", savedAdmin.getPassword(), retrievedAdmin.getPassword());
        assertEquals("User role", savedAdmin.getRole(), retrievedAdmin.getRole());
    }

}