package com.codejava.domain;

import java.util.Date;

public class ProviderInfo {

	private String username;
    private String password;
    private String email;
    private Date dateofbirth;
    private String profession;
 
    public ProviderInfo() {
    }
 
    public ProviderInfo(String username, String password, String email, Date dateofbirth, String profession) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateofbirth = dateofbirth;
        this.profession=profession;
    }
    
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
	
	public Date getDoB(){
		return this.dateofbirth;
	}
	public void setDoB(Date dateofbirth){
		this.dateofbirth=dateofbirth;
	}
	
	public String getProfession(){
		return this.profession;
	}
	public void setProfession(String profession){
		this.profession=profession;
	}
}
