package com.samodeika.entities;

import java.sql.Timestamp;


public class Transaction {
	private int id;
	private Timestamp date;
	private float amount;

	public Transaction() {		
	}
	
	public Transaction(int id, Timestamp date, float amount) {
		this.id = id;
		this.date = date;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", date=" + date + ", amount="
				+ amount + "]";
	}
	
}
