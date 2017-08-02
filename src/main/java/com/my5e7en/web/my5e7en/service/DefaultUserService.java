package com.my5e7en.web.my5e7en.service;

import com.my5e7en.web.my5e7en.controller.dto.UserCreateFormDto;
import com.my5e7en.web.my5e7en.entity.SecurityRole;
import com.my5e7en.web.my5e7en.entity.User;
import com.my5e7en.web.my5e7en.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService extends DefaultService<User, Long> implements UserService {
	private static final Logger log = LoggerFactory.getLogger(DefaultUserService.class);

	@Autowired
	public DefaultUserService(UserRepository userRepository) {
		super(userRepository);
	}

	@Override
	public User getUserByEmail(String email) {
		return ((UserRepository) getRepository()).findOneByEmail(email);
	}

	@Override
	public User create(UserCreateFormDto userCreateForm) {
		User user = new User()
				.setFirstName(userCreateForm.getFirstName())
				.setLastName(userCreateForm.getLastName())
				.setPhone(userCreateForm.getPhone())
				.setEmail(userCreateForm.getEmail())
				.setPassword(new BCryptPasswordEncoder().encode(userCreateForm.getPassword()))
				.setRole(SecurityRole.valueOf(userCreateForm.getRole().toUpperCase()));
		log.info("User: " + user.getEmail() + " password: " + user.getPassword());
		return getRepository().save(user);
	}

	@Override
	public User update(Long id, UserCreateFormDto userCreateForm) {
		User user = getById(id)
				.setFirstName(userCreateForm.getFirstName())
				.setLastName(userCreateForm.getLastName())
				.setPhone(userCreateForm.getPhone())
				.setEmail(userCreateForm.getEmail())
				.setPassword(new BCryptPasswordEncoder().encode(userCreateForm.getPassword()))
				.setRole(SecurityRole.valueOf(userCreateForm.getRole().toUpperCase()));
		return getRepository().save(user);
	}
}
