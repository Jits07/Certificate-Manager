package com.dragon.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CertUpload {
	
	@Id
	//@GeneratedValue
	private long id;
	@ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;
    private String CertName;
    private byte[] data;
    
    
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getCertName() {
		return CertName;
	}
	public void setCertName(String certName) {
		this.CertName = certName;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
//	@Override
//	public String toString() {
//		return "CertUpload [id=" + id + ", user=" + user + ", CertName=" + CertName + ", data=" + Arrays.toString(data)
//				+ "]";
//	}
//	
	
	
	
    
	

}
