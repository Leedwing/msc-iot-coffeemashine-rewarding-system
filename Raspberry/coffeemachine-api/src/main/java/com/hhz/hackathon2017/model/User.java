package com.hhz.hackathon2017.model;

/**
 * Diese Klasse beschreibt das Datenmodell eines Users
 * @author Lee Edwing Nguepedja Tchwangnwou
 *
 */
public class User {
	
	private String registrationNo;
	private String firstName;
	private String lastName;
	private int cookingCount;
	
	//getters and setters
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getCookingCount() {
		return cookingCount;
	}
	public void setCookingCount(int cookingCount) {
		this.cookingCount = cookingCount;
	}
	
	
}
