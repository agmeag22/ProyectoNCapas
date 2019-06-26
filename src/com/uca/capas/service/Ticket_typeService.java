package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.capas.domain.Ticket_type;


public interface Ticket_typeService {
	public List<Ticket_type> findAll(int page);
	public List<Ticket_type> findAll();
	public Ticket_type findOne(Integer code);
	public long countAll();
	public void save(Ticket_type ticket_type);
	public void delete(Ticket_type ticket_type);

}
