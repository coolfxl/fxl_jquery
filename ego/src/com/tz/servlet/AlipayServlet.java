package com.tz.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.util.AlipaySubmit;
import com.tz.util.PayParameter;

public class AlipayServlet extends HttpServlet{
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
		req.setCharacterEncoding("UTF-8");
		//支付类型
		String payment_type = "1";
		//页面跳转同步通知  success.jsp
		String return_url="http://localhost/ego/room/success.jsp";
		//订单号
		String out_trade_no = "12321231321";
		//名称
		String subject = req.getParameter("subject");
		//金额
//		String total_fee =req.getParameter("total_fee");
		String total_fee ="0.01";
		//商品买家地址
		String body = subject;
		String show_url = "http://localhost/ego/room/success.jsp";
		
		
		
		//将请求打包
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("service","create_direct_pay_by_user");
		temp.put("partner", PayParameter.partner);
		temp.put("seller_email", PayParameter.seller_email);
		temp.put("_input_charset", PayParameter.input_charset);
		temp.put("payment_type", payment_type);
		temp.put("return_url", return_url);
		temp.put("out_trade_no", out_trade_no);
		temp.put("subject", subject);
		temp.put("total_fee", total_fee);
		temp.put("body", body);
		temp.put("show_url", show_url);
		
		//发送请求
		String alihtml = AlipaySubmit.buildRequest(temp, "post", "确认");
		
		resp.getWriter().print(alihtml);
		//seller_id
		
	}
}












