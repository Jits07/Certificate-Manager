package com.dragon.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dragon.model.CertUpload;
import com.dragon.model.User;

@Component
public class CertViewImp implements CertViewDao{
	
	
	@Autowired
    protected SessionFactory sessionFactory;
	
	

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
    
    
    public List<CertUpload> findAllByUserId(long userid){
    	
    	System.out.println("In findallby");
		Session session = sessionFactory.openSession();
		//boolean userFound = false;
		//Query using Hibernate Query Language
		User u = (User) getSession().get(User.class, userid);
		System.out.println(u);
		//System.out.println(u);
		if(userid == 1){
		String SQL_QUERY ="from CertUpload";
		Query query = session.createQuery(SQL_QUERY);
		List list = query.list();
		return list;
		}
		else{	
		String SQL_QUERY ="from CertUpload as o where o.user=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, u);
		List list = query.list();
		System.out.println(list);
		return list;
		}
		
		
    	
    }

   

}
