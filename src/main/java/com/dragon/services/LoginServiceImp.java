package com.dragon.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dragon.dao.LoginDao;
import com.dragon.model.User;


@Service
public class LoginServiceImp implements LoginServiceDao {

		 @Autowired
		 private LoginDao loginDao;

		   public void setLoginDAO(LoginDao loginDao) {
	              this.loginDao	 = loginDao;
	       }
	      
	       public Long checkLogin(String userName, String userPassword){
	              System.out.println("In Service class...Check Login");
	              return loginDao.checkLogin(userName, userPassword);
	       }
	       public User FindByKey(long id){
	    	   return loginDao.FindByKey(id);
	       }
}
