package com.dragon.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.model.User;

public interface RegisterDao {
	
	
	public void addUser(User u);
	
}
