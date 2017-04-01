package com.example.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="clients")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private boolean tariff;
	@Temporal(TemporalType.TIMESTAMP)
	private Date transaction;
		
	public Client() {}
	
	public Client(String name, String email, boolean tariff, Date transaction) {
		super();
		this.name = name;
		this.email = email;
		this.tariff = tariff;
		this.transaction = transaction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isTariff() {
		return tariff;
	}
	public void setTariff(boolean tariff) {
		this.tariff = tariff;
	}
	public Date getTransaction() {
		return transaction;
	}
	public void setTransaction(Date transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", tariff=" + tariff + ", transaction="
				+ transaction + "]";
	}
}
