package com.hhz.hackathon2017.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhz.hackathon2017.model.CoffeeLevel;
import com.hhz.hackathon2017.model.User;
import com.hhz.hackathon2017.service.ApiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * in dieser Klasse werden alle APIs implementiert 
 * @author Lee Edwing Nguepedja Tchwangnwou
 *
 */
@RestController
@RequestMapping("/coffeemachine")
@Api(value = "Coffee Machine REST API", description = "exposes resources to the coffee level in the machine, if the coffee is warm, etc.")
public class CoffeeMachineResource {

	@Autowired
	ApiService apiService;

	@ApiOperation(value = "Returns the coffee level")
	@GetMapping("/coffeelevel")
	public CoffeeLevel getCoffeeLevel() {
		return apiService.getCoffeeLevel();
	}

	@ApiOperation(value = "Returns infos about if the coffee is warm again or not")
	@GetMapping("/warmcoffee")
	public boolean getWarmcoffee() {
		return true;
	}

	@ApiOperation(value = "Returns the last time the coffee was cooked")
	@GetMapping("/lasttimebrewed")
	public Date getLasttimeCooked() {
		Date date = new Date();
		return date;
	}

	@ApiOperation(value = "Returns infos of the last user who has cooked the coffee")
	@GetMapping("/havebrewedlast")
	public User getHaveBrewedLast() {
		return apiService.getHaveBrewedLast();
	}

	@ApiOperation(value = "Returns the user who has cooked the most")
	@GetMapping("/coffeechef")
	public User getCoffeeChef() {
		return apiService.getCoffeeChef();
	}

	// optional
//	@ApiOperation(value = "adds a user")
//	@PostMapping("/adduser")
//	public User addUser() {
//		return null;
//	}
//
//	@ApiOperation(value = "edit a user")
//	@PutMapping("/edituser")
//	public User editUser() {
//		return null;
//	}
//
//	@ApiOperation(value = "remove a user")
//	@DeleteMapping("/removeuser")
//	public User removeUser() {
//		return null;
//	}
}
