package com.hhz.hackathon2017.model;

import java.util.Date;

/**
 * Diese Klasse beschreibt das Model zu welchem User hat zu welchem Zeitpunkt Kaffee gekocht
 * @author Lee Edwing Nguepedja Tchwangnwou
 *
 */
public class UserCoffeeLevel {
	
	private User user;
	private Date date;
	
	//getters and setters
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
