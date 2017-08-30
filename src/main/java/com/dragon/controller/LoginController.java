package com.dragon.controller;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragon.services.LoginServiceDao;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceDao loginService;
	

	@RequestMapping(value = "/login")
	public String ShowLogin() {
		//System.out.println("here1");
		return "login";
	}

	@RequestMapping(value = "/login_welcome")
	public String HandleLogin(ModelMap model, @RequestParam String username,
			@RequestParam String password) {
		
		
		//System.out.println("here in cont");
		Long userid = loginService.checkLogin(username, password);
		if (userid < 0) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}


		//model.put("name", name);
		//User u = loginService.FindByKey(id)
		System.out.println(userid);
		model.put("username", username);
		model.put("userid", userid);
		System.out.println(username);
		return "login_welcome";
	}
}