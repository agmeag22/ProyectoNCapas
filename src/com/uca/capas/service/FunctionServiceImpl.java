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

import com.uca.capas.domain.Function;
import com.uca.capas.domain.User;
import com.uca.capas.repositories.FunctionRepository;
import com.uca.capas.repositories.FunctionRepository;;

@Service
public class FunctionServiceImpl implements FunctionService{

	@Autowired
	FunctionRepository functionRepository ;
	
	

	public List<Function> findAll(int page) {
		// TODO Auto-generated method stub
		return functionRepository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "idfunction"))).getContent();
	}
	
	public Function findOne(Integer function) {
		// TODO Auto-generated method stub
		return functionRepository.findById(function).get();
	}
		
	public long countAll() {
		// TODO Auto-generated method stub
		return functionRepository.count();
	}

	
	public void save(Function function) {
		functionRepository.save(function);
	}


	@Override
	public void delete(Function function) {
		functionRepository.delete(function);
		
	}

	@Override
	public List<Function> findAllActiveFunctions() throws DataAccessException {
		return functionRepository.findAllbyState();
	}
}
