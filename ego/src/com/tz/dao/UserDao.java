package com.tz.dao;

import java.sql.Connection;
import java.util.Map;

import com.tanzhou.jdbc.util.MJdbcTemplate;

public class UserDao {
	static MJdbcTemplate mjdbc = new MJdbcTemplate();
	/**
	 * 用户名验证
	 * @return 
	 */
	public static int userName(String name){
		String sql = "select * from userinfo where username=?";
		int num = mjdbc.queryForList(sql, name).size();
		return num;
	}
	
	public static int addUser(String name ,String password){
		String sql = "insert into userinfo values(seqUser.Nextval,?,?,null)";
		//参数
		Object[] obj =  new Object[]{name,password};
		//如果是多个参数new Object[]{name,password}
		int num = mjdbc.executeUpdate(sql,obj);
		
		return num;
	}
	
	public static Map<String, Object> findUser(String name){
		 Map<String,Object> map =mjdbc.queryForObject("select * from userinfo where username=?", name);
		 return map;
	}
	
	
}
