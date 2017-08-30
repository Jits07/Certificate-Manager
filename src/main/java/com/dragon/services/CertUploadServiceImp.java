package com.dragon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.dao.CertUploadDao;
import com.dragon.model.CertUpload;

@Service
public class CertUploadServiceImp implements CertUploadServiceDao{
	
	@Autowired
	private CertUploadDao certuploaddao;

	
	public void setCertuploaddao(CertUploadDao certuploaddao) {
		this.certuploaddao = certuploaddao;
	}
	
	public void upload(CertUpload cert){
        System.out.println("In Service class...Check upload");

		certuploaddao.upload(cert);
	}
	

}
