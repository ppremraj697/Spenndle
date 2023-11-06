package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String date;

	private String description;

	private String amount;

	@ManyToOne
	private UserInput user;

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expense(String title, String date, String description, String amount, UserInput user) {
		super();
		this.title = title;
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAmount() {
		return amount;
	}

	public void setPrice(String amount) {
		this.amount = amount;
	}

	public UserInput getUser() {
		return user;
	}

	public void setUser(UserInput user) {
		this.user = user;
	}
}
