package com.codejava.domain;


import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class User {
	    private String username;
	    private String password;
	    private String email;
	    private String profession;
	    private Date birthDate;
	    
	    
	    public String getUsername(){
	    	return this.username;
	    }
	    public void setUsername(String username){
	    	this.username=username;
	    }
	    
	    public String getPassword(){
	    	return this.password;
	    }
	    public void setPassword(String password){
	    	this.password=password;
	    }
	    
	    public String getEmail(){
	    	return this.email;
	    }
	    public void setEmail(String email){
	    	this.email=email;
	    }
	    
	    public String getProfession(){
	    	return this.profession;
	    }
	    public void setProfession(String profession){
	    	this.profession=profession;
	    }
	    
	    public Date getBirthDate(){
	    	return this.birthDate;
	    }
	    public void setBirthDate(Date birthDate){
	    	this.birthDate=birthDate;
	    }
	    
	    
}
