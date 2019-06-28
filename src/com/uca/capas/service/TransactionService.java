package com.uca.capas.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.capas.domain.Account;
import com.uca.capas.domain.Transaction;
import com.uca.capas.domain.User;

public interface TransactionService {
	public List<Transaction> findAll(int page);
	public Transaction findOne(Integer code);
	public long countAll();
	public void save(Transaction transaction);
	public void delete(Transaction transaction);
	public List<Transaction> findAll(int page,Account id);
	public List<Transaction> findAll(Date start,Date end,int page,Account id);
	public long countAll(Date start,Date end,int page,Account id);
}
