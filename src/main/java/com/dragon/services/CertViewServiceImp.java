package com.dragon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.dao.CertViewDao;
import com.dragon.dao.LoginDao;
import com.dragon.model.CertUpload;
@Service
public class CertViewServiceImp implements CertViewServiceDao{
	
	@Autowired
	 private CertViewDao certviewdao;

	  
     
     



	public void setCertviewdao(CertViewDao certviewdao) {
		this.certviewdao = certviewdao;
	}



	public List<CertUpload> findAllByUserId(long id){
             System.out.println("In Service class...view");
             return certviewdao.findAllByUserId(id);
      }

}
