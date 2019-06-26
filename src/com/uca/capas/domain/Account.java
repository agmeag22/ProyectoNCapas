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
@Table(schema = "public", name = "table_account")
public class Account {
	@Id
	@GeneratedValue(generator="account_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "account_seq", sequenceName = "public.account_seq",allocationSize=1)
	@Column(name = "id_account")
	private Integer id_account;
	
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "active_state")
	private int active_state;
	
	@Column(name = "online_status")
	private int online_status;

	@Column(name = "comment")
	private String comment;

	@Column(name = "credit")
	private float credit;
	
	@Column(name = "id_role")
	private int id_role;
	
	@Column(name = "id_user")
	private int id_user;

	public Integer getId_account() {
		return id_account;
	}

	public void setId_account(Integer id_account) {
		this.id_account = id_account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive_state() {
		return active_state;
	}

	public void setActive_state(int active_state) {
		this.active_state = active_state;
	}

	public int getOnline_status() {
		return online_status;
	}

	public void setOnline_status(int online_status) {
		this.online_status = online_status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public Account(Integer id_account, String username, String password, int active_state, int online_status,
			String comment, float credit, int id_role, int id_user) {
		super();
		this.id_account = id_account;
		this.username = username;
		this.password = password;
		this.active_state = active_state;
		this.online_status = online_status;
		this.comment = comment;
		this.credit = credit;
		this.id_role = id_role;
		this.id_user = id_user;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
