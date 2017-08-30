package com.dragon.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.model.CertUpload;

@Component
public class CertUploadImp implements CertUploadDao{
	
	@Autowired
	 protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
    
    @Override
    @Transactional
    public void upload(CertUpload cert){
    	System.out.println("saving to db");
    	Session session = sessionFactory.getCurrentSession();
		session.save(cert);
    	System.out.println("Saved");
    	
    }

}
