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
@Table(schema = "public", name = "table_role")
public class Role {
	@Id
	@Column(name = "id_role")
	private Integer idrole;
	
	@Column(name = "role")
	private String role;

	public Integer getIdrole() {
		return idrole;
	}

	public void setIdrole(Integer idrole) {
		this.idrole = idrole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role(Integer idrole, String role) {
		super();
		this.idrole = idrole;
		this.role = role;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
