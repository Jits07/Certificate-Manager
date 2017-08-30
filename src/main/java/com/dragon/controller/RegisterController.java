package com.dragon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragon.dao.RegisterDao;
import com.dragon.model.User;
import com.dragon.services.RegisterServiceDao;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterServiceDao registerservice;
	 
	//User user ;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET )
	public String home(){
		return "home";
	}
	@RequestMapping(value = "/register"  )
	public String Register(){
		return "register";
		
	}
	@RequestMapping(value = "/home", method=RequestMethod.POST)
	public String Registerd(ModelMap model, @ModelAttribute User user){
		
		//user = new User(name, password);
		System.out.println(user);
		registerservice.addUser(user);
		model.put("registerd", "You are Registerd. Please Login");

		return  "home";
	}

}
