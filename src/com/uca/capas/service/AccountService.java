package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Account;


public interface AccountService {
	public List<Account> findAll(int page);
	public Account findOne(Integer code);
	public long countAll();
	public void save(Account account);
	public void delete(Account account);
	public boolean findOneUser(@Param("username")String username,@Param("password") String password) throws DataAccessException ;

}
