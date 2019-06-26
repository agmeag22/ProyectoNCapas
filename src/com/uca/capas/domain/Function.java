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
	private Integer idfunction;
	
	
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
	private Ticket_type tickettype;
	
	@Column(name = "start_time")
	private String starttime;
	
	@Column(name = "active_state")
	private Integer activestate;
	
	
	@Column(name = "availability")
	private Integer availability;
	
	@Column(name = "creation_date")
	private String creationdate;
	
	@Column(name = "creation_user")
	private String creationuser;
	
	@Column(name = "mod_date")
	private String moddate;
	
	@Column(name = "mod_user")
	private String moduser;

	public Integer getIdfunction() {
		return idfunction;
	}

	public void setIdfunction(Integer idfunction) {
		this.idfunction = idfunction;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	

	public Ticket_type getTickettype() {
		return tickettype;
	}

	public void setTickettype(Ticket_type tickettype) {
		this.tickettype = tickettype;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public Integer getActivestate() {
		return activestate;
	}

	public void setActivestate(Integer activestate) {
		this.activestate = activestate;
	}

	public Integer getAvailability() {
		return availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}

	public String getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}

	public String getCreationuser() {
		return creationuser;
	}

	public void setCreationuser(String creationuser) {
		this.creationuser = creationuser;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	public String getModuser() {
		return moduser;
	}

	public void setModuser(String moduser) {
		this.moduser = moduser;
	}

	

	public Function(Integer idfunction, Film film, Ticket_type tickettype, String starttime, Integer activestate,
			Integer availability, String creationdate, String creationuser, String moddate, String moduser) {
		super();
		this.idfunction = idfunction;
		this.film = film;
		this.tickettype = tickettype;
		this.starttime = starttime;
		this.activestate = activestate;
		this.availability = availability;
		this.creationdate = creationdate;
		this.creationuser = creationuser;
		this.moddate = moddate;
		this.moduser = moduser;
	}

	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
