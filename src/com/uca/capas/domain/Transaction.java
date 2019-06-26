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
@Table(schema = "public", name = "table_transaction")
public class Transaction {
	@Id
	@GeneratedValue(generator="transaction_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "transaction_seq", sequenceName = "public.transaction_seq",allocationSize=1)
	@Column(name = "id_transaction")
	private Integer idtransaction;
	
	
	@OneToOne
	@JoinColumn(name = "id_account", referencedColumnName = "id_account")
	private Account account;
	
	@OneToOne
	@JoinColumn(name = "id_function", referencedColumnName = "id_function")
	private Function function;
	
	@Column(name = "transaction_date_hour")
	private String transactiondatehour;
	
	@Column(name = "ticket_quantity")
	private String ticketquantity;
	
	@Column(name = "total")
	private float total;

	public Integer getIdtransaction() {
		return idtransaction;
	}

	public void setIdtransaction(Integer idtransaction) {
		this.idtransaction = idtransaction;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public String getTransactiondatehour() {
		return transactiondatehour;
	}

	public void setTransactiondatehour(String transactiondatehour) {
		this.transactiondatehour = transactiondatehour;
	}

	public String getTicketquantity() {
		return ticketquantity;
	}

	public void setTicketquantity(String ticketquantity) {
		this.ticketquantity = ticketquantity;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Transaction(Integer idtransaction, Account account, Function function, String transactiondatehour,
			String ticketquantity, float total) {
		super();
		this.idtransaction = idtransaction;
		this.account = account;
		this.function = function;
		this.transactiondatehour = transactiondatehour;
		this.ticketquantity = ticketquantity;
		this.total = total;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
