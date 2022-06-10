package com.example.service;

import java.util.List;

import com.example.enitity.Chara;

public interface CharaService {
	
	public void insert(Chara chara);
	public List<Chara> findAll();	
 	public Chara selectId (String characterId);
 	  public Chara selectName(String characterName);
}
