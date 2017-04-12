package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable {
  
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "client_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int clientId;
	
	private String name;
	private String email;
	private float money;
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "tariff")
	private Tariff tariff;
	
	private String action;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="client-id")
	List<Transaction> transactions = new ArrayList<>();
	
	
	public Client() {}
	
	public Client(String name, String email, float money, Tariff tariff, String action) {
		super();
		this.name = name;
		this.email = email;
		this.money = money;
		this.tariff = tariff;
		this.action = action;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	@Enumerated(EnumType.ORDINAL)
	public Tariff getTariff() {
		return tariff;
	}

	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", email=" + email + ", money=" + money + ", tariff="
				+ tariff + ", action=" + action + ", transactions=" + transactions + "]";
	}
	
}
