package com.my5e7en.web.my5e7en;

import com.my5e7en.web.my5e7en.entity.SecurityRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class My5e7enSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/public/**").permitAll()
				.antMatchers("/", "/dashboard").authenticated()
				.antMatchers("/users/**").hasAnyAuthority(SecurityRole.ADMIN.name())
				.antMatchers("/companies/**").hasAnyAuthority(SecurityRole.ADMIN.name(), SecurityRole.COMPANY_OWNER.name())
				.antMatchers("/user/**").permitAll()
				.antMatchers("/h2-console").permitAll()
				.anyRequest().permitAll()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/dashboard")
				.failureUrl("/login-error")
				.permitAll()
				.and()
				.logout()
				.logoutSuccessUrl("/").permitAll();
	}


	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		return new SpringSecurityDialect();
	}
}
