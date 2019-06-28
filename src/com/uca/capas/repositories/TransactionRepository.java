package com.uca.capas.repositories;

import java.util.Date;
import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Account;
import com.uca.capas.domain.Film;
import com.uca.capas.domain.Transaction;
import com.uca.capas.domain.User;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	public Page<Transaction> findAll(Pageable page);
	
	public Page<Transaction> findByAccount(Account account,Pageable page);
	public Page<Transaction> findByTransactiondatehourBetweenAndAccount(Date start,Date end,Account a,Pageable page);
	
}
