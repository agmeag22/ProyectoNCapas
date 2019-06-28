package com.uca.capas.service;

import java.util.Date;
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
import com.uca.capas.domain.Transaction;
import com.uca.capas.domain.User;
import com.uca.capas.repositories.AccountRepository;
import com.uca.capas.repositories.TransactionRepository;
import com.uca.capas.repositories.TransactionRepository;;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository ;
	
	

	public List<Transaction> findAll(int page) {
		// TODO Auto-generated method stub
		return transactionRepository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "idtransaction"))).getContent();
	}
	
	public List<Transaction> findAll(int page,Account id) {
		// TODO Auto-generated method stub
		return transactionRepository.findByAccount(id,PageRequest.of(page, 10, new Sort(Direction.ASC, "idtransaction"))).getContent();
	}
	
	
	public List<Transaction> findAll(Date start,Date end,int page,Account id) {
		// TODO Auto-generated method stub
		return transactionRepository.findByTransactiondatehourBetweenAndAccount(start,end,id,PageRequest.of(page, 10, new Sort(Direction.ASC, "idtransaction"))).getContent();
	}
	
	
	public Transaction findOne(Integer transaction) {
		// TODO Auto-generated method stub
		return transactionRepository.findById(transaction).get();
	}
		
	public long countAll() {
		// TODO Auto-generated method stub
		return transactionRepository.count();
	}

	
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}


	@Override
	public void delete(Transaction transaction) {
		transactionRepository.delete(transaction);
		
	}

	
}
