package com.hhz.hackathon2017.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.hhz.hackathon2017.model.CoffeeLevel;
import com.hhz.hackathon2017.model.User;

/**
 * in dieser Klasse werden alle Funktionen für die APIs implementiert
 * @author Lee Edwing Nguepedja Tchwangnwou
 *
 */
@Component
public class ApiService {
	
	// dummy
	
	public User getHaveBrewedLast() {
		User user = new User();
		user.setFirstName("Pascal");
		user.setLastName("Smith");
		user.setRegistrationNo("123456");
		user.setCookingCount(10);
		return user;
	}
	
	public User getCoffeeChef() {
		User user = new User();
		user.setFirstName("Lee");
		user.setLastName("Nguepedja");
		user.setRegistrationNo("789012");
		user.setCookingCount(35);
		return user;
	}
	
	public CoffeeLevel getCoffeeLevel() {
		CoffeeLevel coffeeLevel = new CoffeeLevel();
		coffeeLevel.setDate(new Date());
		coffeeLevel.setWeight(3000);
		return coffeeLevel;
	}
}
