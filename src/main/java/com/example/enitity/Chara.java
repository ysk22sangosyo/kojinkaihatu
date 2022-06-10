package com.example.enitity;

public class Chara {
	  private String characterId;
	   private String characterName;
	   private String sex;
	   private String old;
	   private String job;
	   private String profile;
	   private String img;
	   
	   
	   public Chara() {
			
	   }
	   public Chara(String characterId,String characterName,String sex,String old,String job,String profile,String img) {
		   this.characterId = characterId;
		   this.characterName = characterName;
		   this.sex = sex;
		   this.old =old;
		   this.job =job;
		   this.profile = profile;
		   this.img = img;
	   }
	   
	  
	   public Chara(String characterId, String characterName, String sex) {
		   this.characterId = characterId;
		   this.characterName = characterName;
		   this.sex = sex;
		
	}
	public String getCharacterId() {
		   return characterId;
	   }
	   public void setCharacterId(String characterId) {
		   this.characterId = characterId;
	   }
	   public String getCharacterName() {
		   return characterName;
	   }
	   public void setCharacterName(String characterName) {
		   this.characterName= characterName;
	   }
	   public String getSex() {
		   return sex;
	   }
	   public void setSex(String sex) {
		   this.sex = sex;
	   }
	   public String getOld() {
		   return old;
	   }
	   public void setOld(String old) {
		   this.old = old;
	   }
	   public String getJob() {
		   return job;
	   }
	   public void setJob(String job) {
		   this.job = job;
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
