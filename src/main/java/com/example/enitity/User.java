package com.example.enitity;

public class User {
   private String userId;
   private String password;
   private String name;
   private String profile;
   private String img;
   
   
   public User() {
		
   }
   public User(String userId,String password,String name,String profile,String img) {
	   this.userId = userId;
	   this.password = password;
	   this.name = name;
	   this.profile = profile;
	   this.img = img;
   }
   
  
   public User(String userId, String name, String password) {
	   this.userId = userId;
	   this.password = password;
	   this.name = name;
	
}
public String getUserId() {
	   return userId;
   }
   public void setUserId(String userId) {
	   this.userId = userId;
   }
   public String getPassword() {
	   return password;
   }
   public void setPassword(String password) {
	   this.password = password;
   }
   public String getName() {
	   return name;
   }
   public void setName(String name) {
	   this.name = name;
   }
   public String getProfile() {
	   return profile;
   }
   public void setProfile(String profile) {
	   this.profile = profile;
   }
   public String getImg() {
	   return img;
   }
   public void setImg(String img) {
	   this.img = img;
   }
}

