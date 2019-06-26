package com.uca.capas.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Film;
import com.uca.capas.domain.User;
import com.uca.capas.repositories.AccountRepository;
import com.uca.capas.repositories.FilmRepository;;

@Service
public class FilmServiceImpl implements FilmService{

	@Autowired
	FilmRepository filmRepository ;
	
	

	public List<Film> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return filmRepository.findAll(page).getContent();
	}
	
		
	public long countAll() {
		// TODO Auto-generated method stub
		return filmRepository.count();
	}

	
	public void save(Film film) {
		filmRepository.save(film);
	}

	
}
