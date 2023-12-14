package com.ca.IntegratedCA.model;
/* INTEGRATED CA - DATA STORAGE SOLUTIONS / COMMERCIAL SOLUTIONS DESIGN
 * Xiaohui Weng - 2020387  
 * Leisly Pino 2020303 
 * Yuri Ribeiro 2020347
 * */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Map the mongoDB collection "user"
@Document(collection ="user")
public class User {
	
	@Id
	private String _id;
	private String username;
	private int password;
	
	public String get_id() {
		return _id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
   public User() {
	   
   }
}
