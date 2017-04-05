package com.example.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
  
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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePayment;
	@Temporal(TemporalType.TIME)
	private Date dateExpiry;
		
	public Client() {}

	public Client(int clientId, String name, String email, float money, Tariff tariff, Date datePayment,
			Date dateExpiry) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.email = email;
		this.money = money;
		this.tariff = tariff;
		this.datePayment = datePayment;
		this.dateExpiry = dateExpiry;
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

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}
	
	public Date getDateExpiry() {
		return dateExpiry;
	}

	public void setDateExpiry(Date dateExpiry) {
		this.dateExpiry = dateExpiry;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", email=" + email + ", money=" + money + ", tariff="
				+ tariff + ", datePayment=" + datePayment + ", dateExpiry=" + dateExpiry + "]";
	}
	
}
