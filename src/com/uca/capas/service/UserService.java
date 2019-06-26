package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.capas.domain.User;
import com.uca.capas.domain.User;

public interface UserService {

	
	public List<User> findAll(int page);
	public User findOne(Integer code);
	public boolean findOneUser(String username, String password) throws DataAccessException;
	public long countAll();
	public void save(User user);
	public void delete(User user);
	
}
