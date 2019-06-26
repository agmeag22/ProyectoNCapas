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

import com.uca.capas.domain.Paises;
import com.uca.capas.domain.User;
import com.uca.capas.repositories.PaisRepository;
import com.uca.capas.repositories.UserRepository;

@Service
public class PaisServiceImpl implements PaisService {
	
	@Autowired
	PaisRepository paisRepository ;
	
	

	public List<Paises> findAll() {
		// TODO Auto-generated method stub
		return paisRepository.findAll();
	}
	

	
}
