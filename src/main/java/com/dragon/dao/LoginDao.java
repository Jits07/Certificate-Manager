package com.dragon.dao;

import com.dragon.model.User;

public interface LoginDao{    
	       public Long checkLogin(String userName, String userPassword);
	       public User FindByKey(long id);
	}


