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
	private Integer id_type;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "ticket_cost")
	private float ticket_cost;

	public Integer getId_type() {
		return id_type;
	}

	public void setId_type(Integer id_type) {
		this.id_type = id_type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getTicket_cost() {
		return ticket_cost;
	}

	public void setTicket_cost(float ticket_cost) {
		this.ticket_cost = ticket_cost;
	}

	public Ticket_type(Integer id_type, String type, float ticket_cost) {
		super();
		this.id_type = id_type;
		this.type = type;
		this.ticket_cost = ticket_cost;
	}

	public Ticket_type() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
