package com.my5e7en.web.my5e7en.service;


import com.my5e7en.web.my5e7en.entity.User;
import com.my5e7en.web.my5e7en.service.model.CurrentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
	private final UserService userService;

	@Autowired
	public CurrentUserDetailsService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = Optional.ofNullable(userService.getUserByEmail(email))
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
		return new CurrentUser(user);
	}
}
