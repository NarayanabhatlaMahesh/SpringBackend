package com.example.demo.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserAuthentication {

	@Id
	String username;
	String password;
	String location;
	Long phonenumber;
	public UserAuthentication(String username, String password, String location, Long phonenumber) {
		super();
		this.username = username;
		this.password = password;
		this.location = location;
		this.phonenumber = phonenumber;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
