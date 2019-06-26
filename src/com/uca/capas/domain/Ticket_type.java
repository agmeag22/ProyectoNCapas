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
@Table(schema = "public", name = "table_ticket_type")
public class Ticket_type {
	@Id
	@Column(name = "id_type")
	private Integer idtype;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "ticket_cost")
	private float ticketcost;

	public Integer getIdtype() {
		return idtype;
	}

	public void setIdtype(Integer idtype) {
		this.idtype = idtype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getTicketcost() {
		return ticketcost;
	}

	public void setTicketcost(float ticketcost) {
		this.ticketcost = ticketcost;
	}

	public Ticket_type(Integer idtype, String type, float ticketcost) {
		super();
		this.idtype = idtype;
		this.type = type;
		this.ticketcost = ticketcost;
	}

	public Ticket_type() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
