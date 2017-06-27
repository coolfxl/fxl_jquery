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
		//��ȡ�����е�ֵ
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		
		//�������
//		String pwd = SHA1_Test.getSHA1(password);
		
		//�õ���Ӱ�������
		int num = UserDao.userName(name);
		if(num>0){
			out.print("<script type='text/javascript'>alert('�û����Ѵ���!');location.href='login.jsp'</script>");
		}else{
			int sum = UserDao.addUser(name, password);
			//�����ӳɹ�
			if(sum > 0){
				request.getSession().setAttribute("username", name);
				//��ת
				response.sendRedirect("room/success.jsp");
			}else{
				out.print("<script type='text/javascript'>alert('����û�ʧ��!');location.href='login.jsp'</script>");
			}
		}
	}

}
