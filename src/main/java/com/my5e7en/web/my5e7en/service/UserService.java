package com.my5e7en.web.my5e7en.service;

import com.my5e7en.web.my5e7en.controller.dto.UserCreateFormDto;
import com.my5e7en.web.my5e7en.entity.User;

public interface UserService extends My5e7enService<User, Long> {
	User getUserByEmail(String email);

	User create(UserCreateFormDto userCreateForm);

	User update(Long id, UserCreateFormDto userCreateForm);
}
