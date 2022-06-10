package com.example.dao;

import java.util.List;

import com.example.enitity.Chara;

//userテーブル用DAO
public interface CharaDao {

 
	
	public void insert(Chara chara);
	public List<Chara> findAll();
    public Chara selectId (String characterId);
    public Chara selectName(String characterName);
}
