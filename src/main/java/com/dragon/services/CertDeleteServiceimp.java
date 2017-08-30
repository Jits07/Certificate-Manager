package com.dragon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.dao.DeleteCertDao;
import com.dragon.model.CertUpload;

@Service
public class CertDeleteServiceimp implements CertDeleteServiceDao{
	
	@Autowired
	private DeleteCertDao deletecert;



	public void setDeletecert(DeleteCertDao deletecert) {
		this.deletecert = deletecert;
	}
	
	public void delete(long certid){
		deletecert.delete(certid);
	}
	
	public CertUpload download(long certid){
		return deletecert.download(certid);
	}
	
	
	
	

}
