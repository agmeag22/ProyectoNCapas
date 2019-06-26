package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.capas.domain.Transaction;
import com.uca.capas.domain.User;

public interface TransactionService {
	public List<Transaction> findAll(int page);
	public Transaction findOne(Integer code);
	public long countAll();
	public void save(Transaction transaction);
	public void delete(Transaction transaction);
}
