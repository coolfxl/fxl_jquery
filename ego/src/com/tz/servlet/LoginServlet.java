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
		
		//�ж��û����Ƿ����
		Map<String,Object> map = UserDao.findUser(user);
		if(map != null){
			
			//----------��½ʱ�ж� �������ǰ�ν��滹�Ǻ�̨����-------------
			//�ж��Ƿ�Ϊ����Ա  1  2  
//			if(map.get("USERNAME").equals("ADMIN"))
				//��ת����Ӧ�ĺ�̨����
				
			//�ж�����
			if(map.get("PASSWORD").equals(password)){
				req.getSession().setAttribute("username", user);
				
				//�����¼�ɹ�����ô��Ҫ����ҳ��ʾ����
				//List<Map<String,Object>> list = mj.queryForList("select * from productinfo", null);
				List<Productinfo> listPro = ProductDao.getProList();
				//����ѯ���������ݰ󶨵�����
				req.setAttribute("listPro", listPro);
				//ͨ��ת���������ݴ��ݵ�indexҳ��
				req.getRequestDispatcher("room/index.jsp").forward(req, resp);
//				resp.sendRedirect("room/index.jsp");
			}else{
				out.print("<script type='text/javascript'>alert('�������!');location.href='login.jsp'</script>");
			}
		}else{
			out.print("<script type='text/javascript'>alert('�û���������!');location.href='login.jsp'</script>");
		}
	}
}
