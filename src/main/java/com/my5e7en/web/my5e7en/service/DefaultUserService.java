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
    public DefaultUserService(final UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public User getUserByEmail(String email) {
        return ((UserRepository) getRepository()).findOneByEmail(email);
    }

    @Override
    public User create(UserCreateFormDto userCreateForm) {
        User user = new User();
        user.setFirstName(userCreateForm.getFirstName());
        user.setLastName(userCreateForm.getLastName());
        user.setPhone(userCreateForm.getPhone());
        user.setEmail(userCreateForm.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userCreateForm.getPassword()));
        user.setRole(SecurityRole.valueOf(userCreateForm.getRole().toUpperCase()));
        log.info("User: " + user.getEmail() + " password: " + user.getPassword());
        return getRepository().save(user);
    }

    @Override
    public User update(Long id, UserCreateFormDto userCreateForm) {
        User user = getById(id);
        user.setFirstName(userCreateForm.getFirstName());
        user.setLastName(userCreateForm.getLastName());
        user.setPhone(userCreateForm.getPhone());
        user.setEmail(userCreateForm.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userCreateForm.getPassword()));
        user.setRole(SecurityRole.valueOf(userCreateForm.getRole().toUpperCase()));
        return getRepository().save(user);
    }
}
