package com.uca.capas.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Departamento;

import com.uca.capas.repositories.DepartamentoRepository;


@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	DepartamentoRepository departamentoRepository ;
	
	

	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return departamentoRepository.findAll();
	}
	

	
}
