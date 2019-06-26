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

import com.uca.capas.domain.Ticket_type;
import com.uca.capas.domain.User;
import com.uca.capas.repositories.Ticket_typeRepository;
import com.uca.capas.repositories.Ticket_typeRepository;;

@Service
public class Ticket_typeServiceImpl implements Ticket_typeService{

	@Autowired
	Ticket_typeRepository ticket_typeRepository ;
	
	

	public List<Ticket_type> findAll(int page) {
		// TODO Auto-generated method stub
		return ticket_typeRepository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "idticket_type"))).getContent();
	}
	
	public Ticket_type findOne(Integer ticket_type) {
		// TODO Auto-generated method stub
		return ticket_typeRepository.findById(ticket_type).get();
	}
		
	public long countAll() {
		// TODO Auto-generated method stub
		return ticket_typeRepository.count();
	}

	
	public void save(Ticket_type ticket_type) {
		ticket_typeRepository.save(ticket_type);
	}


	@Override
	public void delete(Ticket_type ticket_type) {
		ticket_typeRepository.delete(ticket_type);
		
	}
}
