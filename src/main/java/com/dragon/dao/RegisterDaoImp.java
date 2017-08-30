package com.dragon.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.model.User;

@Component
public class RegisterDaoImp  implements RegisterDao{
	
	@Autowired
	 protected SessionFactory sessionFactory;

     public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
     }
    
     protected Session getSession(){
            return sessionFactory.openSession();
     }
     
     @Transactional
     public void addUser(User u){
     System.out.println("User Added " + u);
		Session session = sessionFactory.getCurrentSession();
		session.save(u);
     }
}
