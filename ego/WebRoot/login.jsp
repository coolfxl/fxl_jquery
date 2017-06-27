<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta>
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>login</title>

<link rel="stylesheet" href="css/login1.css" type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	   $("#pt a").click(function(){
	   	var index = $(this).index();
	   	$("#uls li").eq(index).addClass("curr").siblings().removeClass("curr");
	   });
	});
	
	function loginSuggest(obj){
		var user = obj.value;
		//alert(user);
		$.ajax({
			type:"post",
			url:"regiter",
			data:{"user":user},
			success:function(data){
				//alert(data);
				var suggest = document.getElementById("suser");
				if(data>0){
					suggest.innerHTML="用户名已存在";
					suggest.className="suggest_link_error";
				}else{
					suggest.innerHTML="用户名可以使用";
					suggest.className="suggest_link";
				}
				
				
			}
			
		});
	}
	function vertionpwd(obj){
		var pwd = obj.value;
		var reg = /^[a-zA-Z]{1}\w{5,20}$/;
		
		var spwd = document.getElementById("spwd");
		if(reg.test(pwd)){
			spwd.innerHTML="密码格式正确";
			spwd.className="suggest_link";
		}else{
			spwd.innerHTML="密码格式不正确";
			spwd.className="suggest_link_error";
		}
		
		
	}
	
	
</script>
</head>
<body>
	<!-- start top -->
	<div class="top">
		<a href="index.html">
			<img src="images/logo.gif" />
		</a>
	</div>
	<!-- end top -->
	<div class="bg"></div>
	<!-- start box -->
	<div class="box">
		<p class="pt" id="pt">
			<a href="javascript:void(0);">登陆</a>|<a href="javascript:void(0);">注册</a>
		</p>
		<ul id="uls">
			<li class="curr">
				<form action="login" method="post">
					<div class="login">
						<p>
							<input type="text" name = "user"class=" text user" placeholder="请输入用户名……" maxlength = "6"/>
						</p>
						<p>
							<input type="password" name = "password" class=" text pwd" placeholder="请输入密码……" maxlength = "16"/>
						</p>
						<p class="links">
							<a href="javascript:void(0);">忘记登陆密码</a>
							<a href="javascript:void(0);">免费注册</a>
						</p>
						<p>
							<input type="submit" value="登    录 " class="but" />
						</p>
					</div>
				</form>
			</li>
			<li>
				<form action="addUserServlet" method="post">
					<div class="login" >
						<p>
							<input type="text" name = "user"
							class=" text user" placeholder="请输入用户名……" 
							onblur="loginSuggest(this)"
							/>
							<span id="suser"></span>
						</p>
						<p>
							<input type="password" name = "password" class=" text pwd" 
							placeholder="请输入密码……" maxlength = "16"
							onblur="vertionpwd(this)"
							/>
							<span id="spwd"></span>
						</p>
						<p>
							<input type="submit" value="注     册" class="but" />
						</p>
					</div>
				</form>
			</li>
		</ul>
	</div>
	<!-- end box -->
</body>
</html>