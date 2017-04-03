package com.example.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int clientId;
	private String clientName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_transaction;
	
	public Transaction() {}

	public Transaction(int clientId, String clientName, Date date_transaction) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.date_transaction = date_transaction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getDate_transaction() {
		return date_transaction;
	}

	public void setDate_transaction(Date date_transaction) {
		this.date_transaction = date_transaction;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", clientId=" + clientId + ", clientName=" + clientName + ", date_transaction="
				+ date_transaction + "]";
	}
	

}
