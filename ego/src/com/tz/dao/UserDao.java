package com.tz.dao;

import java.sql.Connection;
import java.util.Map;

import com.tanzhou.jdbc.util.MJdbcTemplate;

public class UserDao {
	static MJdbcTemplate mjdbc = new MJdbcTemplate();
	/**
	 * �û�����֤
	 * @return 
	 */
	public static int userName(String name){
		String sql = "select * from userinfo where username=?";
		int num = mjdbc.queryForList(sql, name).size();
		return num;
	}
	
	public static int addUser(String name ,String password){
		String sql = "insert into userinfo values(seqUser.Nextval,?,?,null)";
		//����
		Object[] obj =  new Object[]{name,password};
		//����Ƕ������new Object[]{name,password}
		int num = mjdbc.executeUpdate(sql,obj);
		
		return num;
	}
	
	public static Map<String, Object> findUser(String name){
		 Map<String,Object> map =mjdbc.queryForObject("select * from userinfo where username=?", name);
		 return map;
	}
	
	
}
