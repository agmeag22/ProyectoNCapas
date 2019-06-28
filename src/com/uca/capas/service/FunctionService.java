package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.capas.domain.Function;


public interface FunctionService {
	public List<Function> findAll(int page);
	public Function findOne(Integer code);
	public long countAll();
	public void save(Function function);
	public void delete(Function function);
	
	public List<Function> findAllActiveFunctions()throws DataAccessException ;

}
