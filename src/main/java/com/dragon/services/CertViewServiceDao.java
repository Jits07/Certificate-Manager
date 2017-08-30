package com.dragon.services;

import java.util.List;

import com.dragon.model.CertUpload;

public interface CertViewServiceDao {
	public List<CertUpload> findAllByUserId(long id);
}
