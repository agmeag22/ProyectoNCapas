package com.uca.capas.repositories;

import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Film;
import com.uca.capas.domain.Ticket_type;
import com.uca.capas.domain.User;

public interface Ticket_typeRepository extends JpaRepository<Ticket_type, Integer>{
	
	public List<Ticket_type> findAll();
}
