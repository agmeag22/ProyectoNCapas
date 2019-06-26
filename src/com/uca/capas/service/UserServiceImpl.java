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

import com.uca.capas.domain.User;
import com.uca.capas.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository ;
	
	

	public List<User> findAll(int page) {
		// TODO Auto-generated method stub
		return userRepository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "iduser"))).getContent();
	}
	
	public User findOne(Integer user) {
		// TODO Auto-generated method stub
		return userRepository.findById(user).get();
	}
	
	public boolean findOneUser(String username, String password) throws DataAccessException {
		boolean result=false;
		if(userRepository.findOneUser(username, password)==1) result=true;
		return result;
	}
		
	public long countAll() {
		// TODO Auto-generated method stub
		return userRepository.count();
	}

	
	public void save(User user) {
		userRepository.save(user);
	}


	@Override
	public void delete(User user) {
		userRepository.delete(user);
		
	}

	
	
	
}
