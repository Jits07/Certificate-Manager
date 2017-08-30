package com.dragon.dao;

import java.util.List;

import com.dragon.model.CertUpload;

public interface CertViewDao {
	
	//public void ShowCerts(long id);
	public List<CertUpload> findAllByUserId(long userId);
	

}
