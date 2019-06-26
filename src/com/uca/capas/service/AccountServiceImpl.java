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

import com.uca.capas.domain.Account;
import com.uca.capas.domain.User;
import com.uca.capas.repositories.AccountRepository;
import com.uca.capas.repositories.AccountRepository;;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository ;
	
	

	public List<Account> findAll(int page) {
		// TODO Auto-generated method stub
		return accountRepository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "idaccount"))).getContent();
	}
	
	public Account findOne(Integer account) {
		// TODO Auto-generated method stub
		return accountRepository.findById(account).get();
	}
		
	public long countAll() {
		// TODO Auto-generated method stub
		return accountRepository.count();
	}

	
	public void save(Account account) {
		accountRepository.save(account);
	}


	@Override
	public void delete(Account account) {
		accountRepository.delete(account);
		
	}
	
	public boolean findOneUser(String username, String password) throws DataAccessException {
		boolean result=false;
		if(accountRepository.findOneUserInt(username, password)==1) result=true;
		return result;
	}
	
	
}
