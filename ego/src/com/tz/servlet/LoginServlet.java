package com.tz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanzhou.jdbc.util.MJdbcTemplate;
import com.tanzhou.jdbc.util.MRowMapper;
import com.tz.dao.ProductDao;
import com.tz.dao.UserDao;
import com.tz.entity.Productinfo;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		
		//判断用户名是否存在
		Map<String,Object> map = UserDao.findUser(user);
		if(map != null){
			
			//----------登陆时判断 进入的是前段界面还是后台界面-------------
			//判断是否为管理员  1  2  
//			if(map.get("USERNAME").equals("ADMIN"))
				//跳转到响应的后台界面
				
			//判断密码
			if(map.get("PASSWORD").equals(password)){
				req.getSession().setAttribute("username", user);
				
				//如果登录成功，那么需要绑定首页显示数据
				//List<Map<String,Object>> list = mj.queryForList("select * from productinfo", null);
				List<Productinfo> listPro = ProductDao.getProList();
				//将查询出来的数据绑定到请求
				req.setAttribute("listPro", listPro);
				//通过转发，将数据传递到index页面
				req.getRequestDispatcher("room/index.jsp").forward(req, resp);
//				resp.sendRedirect("room/index.jsp");
			}else{
				out.print("<script type='text/javascript'>alert('密码错误!');location.href='login.jsp'</script>");
			}
		}else{
			out.print("<script type='text/javascript'>alert('用户名不存在!');location.href='login.jsp'</script>");
		}
	}
}
