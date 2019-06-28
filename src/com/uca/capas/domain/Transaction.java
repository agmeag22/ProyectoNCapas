package com.uca.capas.domain;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_account", referencedColumnName = "id_account")
	private Account account;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_function", referencedColumnName = "id_function")
	private Function function;
	
	@Column(name = "transaction_date_hour")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactiondatehour;
	
	@Column(name = "ticket_quantity")
	private int ticketquantity;
	
	@Column(name = "total")
	private float total;

	@Column(name = "usedcredit")
	private float usedcredit;

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

	

	public Date getTransactiondatehour() {
		return transactiondatehour;
	}

	public void setTransactiondatehour(Date transactiondatehour) {
		this.transactiondatehour = transactiondatehour;
	}

	public int getTicketquantity() {
		return ticketquantity;
	}

	public void setTicketquantity(int ticketquantity) {
		this.ticketquantity = ticketquantity;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getUsedcredit() {
		return usedcredit;
	}

	public void setUsedcredit(float usedcredit) {
		this.usedcredit = usedcredit;
	}

	public Transaction(Integer idtransaction, Account account, Function function, Date transactiondatehour,
			int ticketquantity, float total, float usedcredit) {
		super();
		this.idtransaction = idtransaction;
		this.account = account;
		this.function = function;
		this.transactiondatehour = transactiondatehour;
		this.ticketquantity = ticketquantity;
		this.total = total;
		this.usedcredit = usedcredit;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	
	
	
}
