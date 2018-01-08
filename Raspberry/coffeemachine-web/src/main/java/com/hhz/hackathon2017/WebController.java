package com.hhz.hackathon2017;
/**
 * Web Controller
 * @author Lee Edwing Nguepedja Tchwangnwou
 */
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hhz.hackathon2017.db.DBCoonnector;

@Controller
public class WebController {
	
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String showStartPage() {
		return "index";
	}
	
	@RequestMapping(value = "/index", method=RequestMethod.POST)
	public String handleRegistering(@RequestParam String id,
			@RequestParam String firstname, @RequestParam String lastname, ModelMap model) throws ClassNotFoundException, SQLException {
//			model.put("id", id);
//			model.put("lastname", lastname);
//			model.put("firstname", firstname);
			model.put("message", "erfolgreich registriert!");
			new DBCoonnector().addUser();
			return "index";
	}
}
