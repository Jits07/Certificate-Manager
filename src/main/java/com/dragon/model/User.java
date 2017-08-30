package com.dragon.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
public class User {
	
	@Id
	private long id;
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<CertUpload> UserCerts = new HashSet<CertUpload>();
	  //private String name;
	
	 public User() {}
	 
	 

	public User(long id, String username, String password, Set<CertUpload> userCerts) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		UserCerts = userCerts;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<CertUpload> getUserCerts() {
		return UserCerts;
	}

	public void setUserCerts(Set<CertUpload> userCerts) {
		UserCerts = userCerts;
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", password=" + password + ", UserCerts=" + UserCerts
//				+ "]";
//	}
	 
	 
	  
	

}
