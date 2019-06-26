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
@Table(schema = "public", name = "table_account")
public class Account {
	@Id
	@GeneratedValue(generator="account_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "account_seq", sequenceName = "public.account_seq",allocationSize=1)
	@Column(name = "id_account")
	private Integer idaccount;
	
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "active_state")
	private int activestate;
	
	@Column(name = "online_status")
	private int onlinestatus;

	@Column(name = "comment")
	private String comment;

	@Column(name = "credit")
	private float credit;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role", referencedColumnName = "id_role")
	private Role role;
	
	@OneToOne
	@JoinColumn(name = "id_user", referencedColumnName = "id_user")
	private User user;

	public Integer getIdaccount() {
		return idaccount;
	}

	public void setIdaccount(Integer idaccount) {
		this.idaccount = idaccount;
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

	public int getActivestate() {
		return activestate;
	}

	public void setActivestate(int activestate) {
		this.activestate = activestate;
	}

	public int getOnlinestatus() {
		return onlinestatus;
	}

	public void setOnlinestatus(int onlinestatus) {
		this.onlinestatus = onlinestatus;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Account(Integer idaccount, String username, String password, int activestate, int onlinestatus,
			String comment, float credit, Role role, User user) {
		super();
		this.idaccount = idaccount;
		this.username = username;
		this.password = password;
		this.activestate = activestate;
		this.onlinestatus = onlinestatus;
		this.comment = comment;
		this.credit = credit;
		this.role = role;
		this.user = user;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	
	
}
