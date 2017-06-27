package com.tz.jdbc.test;

import com.tanzhou.jdbc.util.DBUtil;
import com.tz.dao.UserDao;

public class Test {
	public static void main(String[] args) {
		DBUtil db = new DBUtil();
		
		System.out.println(UserDao.userName("ОтµА"));
	}
}
