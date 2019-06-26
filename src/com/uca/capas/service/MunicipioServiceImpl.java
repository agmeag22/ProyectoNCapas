package com.uca.capas.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Municipio;

import com.uca.capas.repositories.MunicipioRepository;


@Service
public class MunicipioServiceImpl implements MunicipioService {
	
	@Autowired
	MunicipioRepository municipioRepository ;
	
	

	public List<Municipio> findAll() {
		// TODO Auto-generated method stub
		return municipioRepository.findAll();
	}
	

	
}
