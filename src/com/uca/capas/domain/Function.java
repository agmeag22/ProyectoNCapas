package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "function")
public class Function {
	@Id
	@GeneratedValue(generator="function_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "function_seq", sequenceName = "public.function_seq",allocationSize=1)
	@Column(name = "id_function")
	private Integer id_function;
	
	
//	@Column(name = "id_film")
//	private Integer id_film;
//	
	@OneToOne
	@JoinColumn(name = "id_film", referencedColumnName = "id_film")
	//@Column(name = "id_film")
	private Film film;
	
//	@Column(name = "id_type")
//	private Integer id_type;
//	
//	ticket_type
	@OneToOne
	@JoinColumn(name = "id_type", referencedColumnName = "id_type")
//	@Column(name = "id_type")
	private Ticket_type ticketTipe;
	
	@Column(name = "start_time")
	private String start_time;
	
	@Column(name = "active_state")
	private Integer active_state;
	
	
	@Column(name = "availability")
	private Integer availability;
	
	@Column(name = "creation_date")
	private String creation_date;
	
	@Column(name = "creation_user")
	private String creation_user;
	
	@Column(name = "mod_date")
	private String mod_date;
	
	@Column(name = "mod_user")
	private String mod_user;
	

}
