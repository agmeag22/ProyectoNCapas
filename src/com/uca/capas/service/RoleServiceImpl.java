package com.uca.capas.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Role;
import com.uca.capas.domain.User;
import com.uca.capas.repositories.RoleRepository;
import com.uca.capas.repositories.RoleRepository;;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository ;
	
	

	public List<Role> findAll(int page) {
		// TODO Auto-generated method stub
		return roleRepository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "idrole"))).getContent();
	}
	
	public Role findOne(Integer role) {
		// TODO Auto-generated method stub
		return roleRepository.findById(role).get();
	}
		
	public long countAll() {
		// TODO Auto-generated method stub
		return roleRepository.count();
	}

	
	public void save(Role role) {
		roleRepository.save(role);
	}


	@Override
	public void delete(Role role) {
		roleRepository.delete(role);
		
	}
}
