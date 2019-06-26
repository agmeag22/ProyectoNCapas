package com.uca.capas.domain;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "t_departamentos")
public class Departamento {
	@Id
	@Column(name = "id")
	private Integer idpais;
	
	@Column(name = "departamento")
	private String departamento;

	public Integer getIdpais() {
		return idpais;
	}

	public void setIdpais(Integer idpais) {
		this.idpais = idpais;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Departamento(Integer idpais, String departamento) {
		super();
		this.idpais = idpais;
		this.departamento = departamento;
	}

	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
}
