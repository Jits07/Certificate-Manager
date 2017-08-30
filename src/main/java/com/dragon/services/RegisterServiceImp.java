package com.dragon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.dao.LoginDao;
import com.dragon.dao.RegisterDao;
import com.dragon.model.User;

@Service
public class RegisterServiceImp  implements RegisterServiceDao{
	
	@Autowired
	 private RegisterDao registerDao;

	  
     



	public void setRegisterDao(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}



	public void addUser(User u){
             System.out.println("In RegisterService class...Adding User");
             registerDao.addUser(u);
      }

}
