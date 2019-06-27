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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "table_user")
public class User {
	@Id
	@GeneratedValue(generator="user_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_seq", sequenceName = "public.user_seq",allocationSize=1)
	@Column(name = "id_user")
	private Integer iduser;
	
	@Column(name = "u_name")
	private String uname;
		
	@Column(name = "u_lastname")
	private String ulastname;
	
	@Column(name = "ubirthdate")
	private String ubirthdate;
	
	@Column(name = "ucountry")
	private String ucountry;
	
	@Column(name = "u_municipality")
	private String umunicipality;
	
	@Column(name = "u_address")
	private String uaddress;

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_lastname() {
		return u_lastname;
	}

	public void setU_lastname(String u_lastname) {
		this.u_lastname = u_lastname;
	}

	public String getU_birthdate() {
		return u_birthdate;
	}

	public void setU_birthdate(String u_birthdate) {
		this.u_birthdate = u_birthdate;
	}

	public String getU_country() {
		return u_country;
	}

	public void setU_country(String u_country) {
		this.u_country = u_country;
	}

	public String getU_municipality() {
		return u_municipality;
	}

	public void setU_municipality(String u_municipality) {
		this.u_municipality = u_municipality;
	}

	public String getU_adress() {
		return u_adress;
	}

	public void setU_adress(String u_adress) {
		this.u_adress = u_adress;
	}

	public User(Integer iduser, String u_name, String u_lastname, String u_birthdate, String u_country,
			String u_municipality, String u_adress) {
		super();
		this.iduser = iduser;
		this.u_name = u_name;
		this.u_lastname = u_lastname;
		this.u_birthdate = u_birthdate;
		this.u_country = u_country;
		this.u_municipality = u_municipality;
		this.u_adress = u_adress;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	
}
