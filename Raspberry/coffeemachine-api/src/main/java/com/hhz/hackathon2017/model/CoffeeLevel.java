package com.hhz.hackathon2017.model;

import java.util.Date;

/**
 * Diese Klasse beschreibt das Datenmodell des Kaffeefüllstand
 * @author Lee Edwing Nguepedja Tchwangnwou
 *
 */
public class CoffeeLevel {
	
	private Date date;
	private int weight;
	
	//getters and setters
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}