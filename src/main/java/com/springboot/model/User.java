package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="wallet")
	private double wallet;
	
	public User() {
		
	}
	
	public User(int id, String name, double wallet) {
		this.id = id;
		this.name = name;
		this.wallet = wallet;
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


	public double getWallet() {
		return wallet;
	}


	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
	
}
