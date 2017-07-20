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
		final User savedUser = userRepository.save(new User()
				.setFirstName("John" )
				.setLastName("Doe" )
				.setPhone("0000000000" )
				.setEmail("admin@unittest" )
				.setPassword(new BCryptPasswordEncoder().encode("admin" ))
				.setRole(SecurityRole.ADMIN)
		);
		userRepository.save(new User()
				.setFirstName("Jessica" )
				.setLastName("Doe" )
				.setPhone("0000000001" )
				.setEmail("employee@unittest" )
				.setPassword(new BCryptPasswordEncoder().encode("employee" ))
				.setRole(SecurityRole.COMPANY_EMPLOYER)
		);

		User retrievedUser = userRepository.findOneByEmail("admin@unittest" );

		System.out.println(new BCryptPasswordEncoder().encode("demo@localhost"));
		System.out.println(new BCryptPasswordEncoder().encode("john@localhost"));

		System.out.println(new BCryptPasswordEncoder().matches("john@localhost", new BCryptPasswordEncoder().encode("john@localhost")));

		assertThat(savedUser, is(equalTo(retrievedUser)));
	}

}