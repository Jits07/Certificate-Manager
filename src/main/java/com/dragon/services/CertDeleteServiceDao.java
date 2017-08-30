package com.dragon.services;

import com.dragon.model.CertUpload;

public interface CertDeleteServiceDao {
	public void delete(long certid);
	public CertUpload download(long certid);


}
