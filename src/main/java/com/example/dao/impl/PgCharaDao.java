package com.example.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.CharaDao;
import com.example.enitity.Chara;

@Repository
public class PgCharaDao implements CharaDao{
private static final String FINDALL ="SELECT * FROM users as u JOIN characters as c ON u.user_id=c.user_id where u.user_id=:userId" ;
private static final String SELECT_NAME = "SELECT * FROM characters WHERE character_name like :characterName";
private static final String SELECT_ID = "SELECT * FROM characters WHERE character_id=:characterId";
private static final String INSERT ="INSERT INTO characters(character_id,character_name,sex,old,job,profile,img,user_id) VALUES(:characterId,:characterName,:sex,:old,:job,:profile,:img,:userId)";
private static final String UPDATE ="UPDATE users SET user_id =:userId , password =:password, name =:name,profile =:profile,img =:img WHERE user_id =:userId";
@Autowired
private NamedParameterJdbcTemplate jdbcTemplate;

////ログイン
//@Override
//public User login(String userId,String password) {
//	String sql = SELECT_ID_PASS;
//	MapSqlParameterSource param = new MapSqlParameterSource();
//	param.addValue("userId",userId);
//	param.addValue("password",password);
//	 
//	List<User> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));
//	return resultList.isEmpty() ? null :resultList.get(0);
//}
@Autowired
//セッションを取得
HttpSession session;
//キャラクター登録
@Override
public void insert(Chara chara){
	String sql = INSERT;
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("characterId", chara.getCharacterId());
	param.addValue("characterName", chara.getCharacterName());
	param.addValue("sex", chara.getSex());
	param.addValue("old", chara.getOld());
	param.addValue("job", chara.getJob());
	param.addValue("profile", chara.getProfile());
	param.addValue("img", chara.getImg());
	param.addValue("userId",session.getAttribute("userId"));

	 
    jdbcTemplate.update(sql, param);
	
	
}
//全件表示
public List<Chara> findAll() {
	String sql = FINDALL;
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("userId",session.getAttribute("userId"));
	 return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Chara>(Chara.class));
}

//ID検索
@Override
public Chara selectId (String characterId) {
	String sql = SELECT_ID;
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("characterId",characterId);

	 
	var resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Chara>(Chara.class));
	return resultList.isEmpty() ? null :resultList.get(0);
}

//名前検索
@Override
public Chara selectName(String characterName) {
	String sql = SELECT_NAME;
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("characterName",'%'+characterName+'%');

	
	var resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Chara>(Chara.class));
	
	return resultList.isEmpty() ? null :resultList.get(0);
}

//public void update(User user) {
//	String sql =UPDATE;
//	MapSqlParameterSource param = new MapSqlParameterSource();
//	param.addValue("userId", user.getUserId());
//	param.addValue("password", user.getPassword());
//	param.addValue("name", user.getName());
//	param.addValue("profile", user.getProfile());
//	param.addValue("img", user.getImg());
//	
//	 jdbcTemplate.update(sql, param);
//}
}
