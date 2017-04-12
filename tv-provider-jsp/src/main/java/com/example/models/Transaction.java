package com.example.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transactions")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="client")
	private Client client;
	
	private String action;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date date;
    	
	public Transaction() {}

	public Transaction(Client client, String action, Date date) {
		this.client = client;
		this.action = action;
		this.date = date;
		System.out.println("FROM CTOR TRANSACTION");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", client=" + client + ", action=" + action + ", date=" + date + "]";
	}

	
}
