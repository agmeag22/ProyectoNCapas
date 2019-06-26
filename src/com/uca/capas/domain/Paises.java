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
@Table(schema = "public", name = "paises")
public class Paises {
	@Id
	@Column(name = "id")
	private Integer idpais;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "iso3166a1")
	private String iso1;

	@Column(name = "iso3166a2")
	private String iso2;
	
	@Column(name = "nombre")
	private String name;

	public Integer getIdpais() {
		return idpais;
	}

	public void setIdpais(Integer idpais) {
		this.idpais = idpais;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIso1() {
		return iso1;
	}

	public void setIso1(String iso1) {
		this.iso1 = iso1;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Paises(Integer idpais, String code, String iso1, String iso2, String name) {
		super();
		this.idpais = idpais;
		this.code = code;
		this.iso1 = iso1;
		this.iso2 = iso2;
		this.name = name;
	}

	public Paises() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
