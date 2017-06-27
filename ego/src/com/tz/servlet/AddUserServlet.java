package com.tz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.SHA1.SHA1_Test;
import com.tz.dao.UserDao;

public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//获取请求中的值
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		
		//密码加密
//		String pwd = SHA1_Test.getSHA1(password);
		
		//得到受影响的行数
		int num = UserDao.userName(name);
		if(num>0){
			out.print("<script type='text/javascript'>alert('用户名已存在!');location.href='login.jsp'</script>");
		}else{
			int sum = UserDao.addUser(name, password);
			//如果添加成功
			if(sum > 0){
				request.getSession().setAttribute("username", name);
				//跳转
				response.sendRedirect("room/success.jsp");
			}else{
				out.print("<script type='text/javascript'>alert('添加用户失败!');location.href='login.jsp'</script>");
			}
		}
	}

}
