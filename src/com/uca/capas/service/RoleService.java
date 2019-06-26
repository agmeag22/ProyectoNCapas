package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.capas.domain.Role;


public interface RoleService {
	public List<Role> findAll(int page);
	public Role findOne(Integer code);
	public long countAll();
	public void save(Role role);
	public void delete(Role role);

}
