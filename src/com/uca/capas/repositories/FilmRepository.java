package com.uca.capas.repositories;

import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Film;
import com.uca.capas.domain.Function;
import com.uca.capas.domain.User;

public interface FilmRepository extends PagingAndSortingRepository<Film, Integer>{
	
	
	public Page<Film> findAll(Pageable page);
	public List<Film> findAll();
	
	
	
	@Query(nativeQuery=true, value="select DISTINCT fi.id_film, fi.film_name, fi.description, fi.duration, fi.url_poster\r\n" + 
			"	from table_film fi INNER JOIN table_function fu ON fi.id_film=fu.id_film\r\n" + 
			"	WHERE fu.active_state=1")
	public List<Film> findAllbyState() throws DataAccessException ;
}
