package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CharaDao;
import com.example.enitity.Chara;
import com.example.service.CharaService;
@Service
public class CharaServiceImpl implements CharaService{
	@Autowired
	private CharaDao charaDao;
	/**
	 * 登録
	 */

	public void insert(Chara chara) {
	    charaDao.insert(chara);
	}
	
	// 全件表示
	@Override
	public List<Chara> findAll(){
		return charaDao.findAll();
	}
	//Id検索
	@Override
	public Chara selectId (String characterId) {
		return charaDao.selectId(characterId);
	}
	//名前検索
	@Override
	  public Chara selectName(String characterName) {
		return charaDao.selectName(characterName);
	}
}
