package com.tz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.dao.UserDao;

/**
 * 检验用户名是否能注册的serlvet
 * @author Administrator
 *
 */
public class RegiterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		//获取请求中的值
		String name = req.getParameter("user");
		int num = UserDao.userName(name);
		out.println(num);
	}
}
