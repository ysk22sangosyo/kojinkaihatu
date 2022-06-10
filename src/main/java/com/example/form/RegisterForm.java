package com.example.form;

import javax.validation.constraints.NotBlank;

public class RegisterForm {
	   @NotBlank(message="IDは必須です。  ")
	   private String userId;
	   @NotBlank(message="パスワードは必須です。  ")
	   private String password;
	   @NotBlank(message="名前は必須です。  ")
	   private String name;
	   private String profile;
	   private String img;
	   
	   
	  
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

