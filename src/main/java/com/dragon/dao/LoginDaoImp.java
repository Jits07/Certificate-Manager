package com.dragon.dao;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dragon.dao.LoginDao;
import com.dragon.model.User;


//@Repository("loginDao")
@Component

public class LoginDaoImp implements LoginDao {

	
	
	     
		 
	      //@Resource(name="sessionFactory")
		   @Autowired
	       protected SessionFactory sessionFactory;

	       public void setSessionFactory(SessionFactory sessionFactory) {
	              this.sessionFactory = sessionFactory;
	       }
	      
	       protected Session getSession(){
	              return sessionFactory.openSession();
	       }

	       public Long checkLogin(String username, String password){
				System.out.println("In Check login");
				Session session = sessionFactory.openSession();
				boolean userFound = false;
				//Query using Hibernate Query Language
				String SQL_QUERY ="select id from User as o where o.username=? and o.password=?";
				Query query = session.createQuery(SQL_QUERY);
				query.setParameter(0,username);
				query.setParameter(1,password);
				List list = query.list();
				
				System.out.println(Arrays.toString(list.toArray()));

				
				
				return (Long) (list.toArray()[0]);              
	       }
	       public User FindByKey(long id){
	    	   return (User) getSession().get(User.class, id);
	    	   
	       }
	}
