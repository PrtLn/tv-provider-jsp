package com.example.models;

public enum Tariff {
	
	STANDART("Standart"),
	VIP("Vip");
	
	private String plan;
	
	Tariff(String cPlan) {
		this.plan = cPlan;
	}
	
	public String plan() {
		return plan;
	}
	
}