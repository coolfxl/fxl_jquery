<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>Document</title>
<link rel="stylesheet" href="room/css/index.css" type="text/css">
<script type="text/javascript" src="room/js/index.js"></script>
<style type="text/css">
	.atext{
		text-decoration:underline;
	}
</style>
</head>
<body>
	<div class="container">
		<!-- start top -->
		<div class="top">
			<a href="javascript:void(0);"><img class="t_img"src="images/logo.gif" alt="logo"></a>
			<div class="menu">
				<ul>
					<li><a href=""></a>留言</li>
					<li><a href="login.html">登录 | 注册</a></li>
					<li><a href="shopping.html">购物车</a></li>
					<li>当前用户:<a href="" class="atext">${sessionScope.username }</a></li>
				</ul>
				<form action="">
					<div class="search">
						<span><input type="text" name="search"></span>
						<span><a href="javascript:void(0);">Search</a></span>
					</div>
				</form>
			</div>
		</div>
		<!-- end top -->
		<!-- start pic -->
		<div class="pic" id="box">
			<a href="javascript:void(0);" id="prev" class="p-btn">&lt;</a>
			<a href="javascript:void(0);" id="next" class="p-btn">&gt;</a>
			<ul id="list" class="p-list">
				<li  class="curr">
					<a href=""><img src="room/images/dd_scroll_1.jpg"/></a>
				</li>
				<li>
					<a href=""><img src="room/images/dd_scroll_2.jpg"/></a>
				</li>
				<li>
					<a href=""><img src="room/images/dd_scroll_3.jpg"/></a>
				</li>
				<li>
					<a href=""><img src="room/images/dd_scroll_4.jpg"/></a>
				</li>
				<li>
					<a href=""><img src="room/images/dd_scroll_5.jpg"/></a>
				</li>
			</ul>
			<ul id="count" class="p-count">
				<li class="none">1</li>
				<li>2</li>
				<li>3</li>
				<li>4</li>
				<li>5</li>
			</ul>
		</div>
		<!-- end pic -->
		<!-- start main -->
		<div class="main">
			<div class="member">
				<h2>最新公告</h2>
			</div>
			<div class="new">
				<h2>新闻铁事</h2>
				<div class="news_text">
					<dl>
						<dt><a href="javascript:void(0);">关于动物园停车费的收费公告</a></dt>
						<dd>2012-09-05</dd>
						<dt><a href="javascript:void(0);">开学季——动物园里也有开学典礼</a></dt>
						<dd>2012-08-29</dd>
						<dt><a href="javascript:void(0);">喜迎“六•一”，小动物们欢欢喜喜过起了儿童节</a></dt>
						<dd>2012-06-01</dd>
						<dt><a href="javascript:void(0);">迎“五•一”，野生动物园旧貌换新颜</a></dt>
						<dd>2012-05-01</dd>
						<dt><a href="javascript:void(0);">稀有白袋鼠安家野生动物园</a></dt>
						<dd>2012-04-23</dd>
						<dt><a href="javascript:void(0);">我园熊虎散放区被野生动物保护协会命名为“野生动物园优秀展区”</a></dt>
						<dd>2012-04-14</dd>
						<dt><a href="javascript:void(0);">散放区乘车广场的新候车长廊</a></dt>
						<dd>2012-03-20</dd>
						<dt><a href="javascript:void(0);">“Hi，动物朋友！”走进野生动物园，和动物来个亲密接触</a></dt>
						<dd>2012-03-03</dd>
					</dl>
				</div>
			</div>
		</div>
		<!-- end main -->
		<!-- start content -->
		<div class="content">
			<ul>
				<c:forEach items="${requestScope.listPro}" var="pro" >
					<li><a href="room/shopping.jsp?pro=${pro.productid }"><img src="room/images/${pro.pic }"  title="${pro.productname }"></a></a></li>
				</c:forEach>
				
			</ul>
		</div>
		<!-- end content -->
	</div>
	<!-- start bottom -->
	<div class="bottom">
		<div>
			<p>
				<b >首页</b><span>|</span>
				<b>留言板</b>
			</p>
			<p>地址：长沙市岳麓区芯城科技园：010-xxxxxxx 
				Email：www.tanzhouedu.com
			</p>
		</div>
	</div>
	<!-- end bottom -->

</body>
</html>
