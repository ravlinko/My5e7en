package com.my5e7en.web.my5e7en.service;


import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Collection;

public class DefaultService<T, ID extends Serializable> implements My5e7enService<T, ID> {
	private final JpaRepository<T, ID> repository;

	DefaultService(JpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public T getById(ID id) {
		return repository.findOne(id);
	}

	@Override
	public Collection<T> getAll() {
		return repository.findAll();
	}

	JpaRepository<T, ID> getRepository() {
		return repository;
	}


}
