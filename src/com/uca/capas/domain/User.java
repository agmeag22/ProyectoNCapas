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
	

	@Column(name = "u_birthdate")
	private String ubirthdate;
	
	@Column(name = "u_country")
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUlastname() {
		return ulastname;
	}

	public void setUlastname(String ulastname) {
		this.ulastname = ulastname;
	}

	public String getUbirthdate() {
		return ubirthdate;
	}

	public void setUbirthdate(String ubirthdate) {
		this.ubirthdate = ubirthdate;
	}

	public String getUcountry() {
		return ucountry;
	}

	public void setUcountry(String ucountry) {
		this.ucountry = ucountry;
	}

	public String getUmunicipality() {
		return umunicipality;
	}

	public void setUmunicipality(String umunicipality) {
		this.umunicipality = umunicipality;
	}

	public String getUadress() {
		return uaddress;
	}

	public void setUadress(String uadress) {
		this.uaddress = uadress;
	}

	public User(Integer iduser, String uname, String ulastname, String ubirthdate, String ucountry,
			String umunicipality, String uadress) {
		super();
		this.iduser = iduser;
		this.uname = uname;
		this.ulastname = ulastname;
		this.ubirthdate = ubirthdate;
		this.ucountry = ucountry;
		this.umunicipality = umunicipality;
		this.uaddress = uadress;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	


	
}
