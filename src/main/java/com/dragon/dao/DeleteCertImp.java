package com.dragon.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.model.CertUpload;

@Component
public class DeleteCertImp implements DeleteCertDao {
	
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
   public void delete(long certid){
	   
  

	   
   	System.out.println("saving to db");
   	Session session = sessionFactory.getCurrentSession();
   //	Transaction transaction = session.beginTransaction();
   //	try{
   		System.out.println("deleting");
   		String SQL_QUERY ="delete from CertUpload where id=?";
   		Query query = session.createQuery(SQL_QUERY);
   		query.setParameter(0,certid);
   		System.out.println(query.executeUpdate());
   		
   		//session.beginTransaction().commit();
   		
  // 	}
   
   	
	
   	
   }
   
   @Transactional
   public  CertUpload download(long certid){
	   Session session = sessionFactory.getCurrentSession();
	   return (CertUpload)session.get(CertUpload.class, certid);
	   
	   
	   
   }

}
