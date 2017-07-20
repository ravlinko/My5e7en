package com.my5e7en.web.my5e7en.service;

import java.io.Serializable;
import java.util.Collection;

public interface My5e7enService<T, ID extends Serializable> {
	T getById(ID id);

	Collection<T> getAll();
}
