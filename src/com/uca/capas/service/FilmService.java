package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Film;

public interface FilmService {
	public List<Film> findAll(int page);
	public List<Film> findAll();
	public Film findOne(Integer code);
	public long countAll();
	public void save(Film film);
	public void delete(Film film);
	public List<Film> findAllActive()throws DataAccessException ;
}
