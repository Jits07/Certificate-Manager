package com.dragon.dao;

import com.dragon.model.CertUpload;

public interface DeleteCertDao {
	
	public void delete(long certid);
	public CertUpload download(long certid);

}
