package com.dragon.services;

import com.dragon.model.User;

public interface LoginServiceDao{    
	       public Long checkLogin(String userName, String userPassword);
	       public User FindByKey(long id);
	}


