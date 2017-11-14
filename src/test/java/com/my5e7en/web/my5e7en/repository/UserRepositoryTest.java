package com.my5e7en.web.my5e7en.repository;

import com.my5e7en.web.my5e7en.entity.SecurityRole;
import com.my5e7en.web.my5e7en.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindOneUserByEmail() throws Exception {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPhone("0000000000");
        user.setEmail("admin@unittest");
        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        user.setRole(SecurityRole.ADMIN);
        final User savedUser = userRepository.save(user);

        user.setFirstName("Jessica");
        user.setLastName("Doe");
        user.setPhone("0000000001");
        user.setEmail("employee@unittest");
        user.setPassword(new BCryptPasswordEncoder().encode("employee"));
        user.setRole(SecurityRole.COMPANY_EMPLOYER);
        userRepository.save(user);

        User retrievedUser = userRepository.findOneByEmail("admin@unittest");

        System.out.println(new BCryptPasswordEncoder().encode("demo@localhost"));
        System.out.println(new BCryptPasswordEncoder().encode("john@localhost"));

        System.out.println(new BCryptPasswordEncoder().matches("john@localhost", new BCryptPasswordEncoder().encode("john@localhost")));

        assertThat(savedUser, is(equalTo(retrievedUser)));
    }

}