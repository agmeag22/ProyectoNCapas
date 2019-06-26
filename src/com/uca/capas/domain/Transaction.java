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
@Table(schema = "public", name = "table_transaction")
public class Transaction {
	@Id
	@GeneratedValue(generator="transaction_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "transaction_seq", sequenceName = "public.transaction_seq",allocationSize=1)
	@Column(name = "id_transaction")
	private Integer id_transaction;
	
	
	@Column(name = "id_account")
	private String id_account;
	
	@Column(name = "id_function")
	private String id_function;
	
	@Column(name = "transaction_date_hour")
	private String transaction_date_hour;
	
	@Column(name = "ticket_quantity")
	private String ticket_quantity;
	
	@Column(name = "total")
	private float total;

	public Integer getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(Integer id_transaction) {
		this.id_transaction = id_transaction;
	}

	public String getId_account() {
		return id_account;
	}

	public void setId_account(String id_account) {
		this.id_account = id_account;
	}

	public String getId_function() {
		return id_function;
	}

	public void setId_function(String id_function) {
		this.id_function = id_function;
	}

	public String getTransaction_date_hour() {
		return transaction_date_hour;
	}

	public void setTransaction_date_hour(String transaction_date_hour) {
		this.transaction_date_hour = transaction_date_hour;
	}

	public String getTicket_quantity() {
		return ticket_quantity;
	}

	public void setTicket_quantity(String ticket_quantity) {
		this.ticket_quantity = ticket_quantity;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Transaction(Integer id_transaction, String id_account, String id_function, String transaction_date_hour,
			String ticket_quantity, float total) {
		super();
		this.id_transaction = id_transaction;
		this.id_account = id_account;
		this.id_function = id_function;
		this.transaction_date_hour = transaction_date_hour;
		this.ticket_quantity = ticket_quantity;
		this.total = total;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
