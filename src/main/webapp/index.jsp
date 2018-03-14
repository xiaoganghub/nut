<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
var login = <%=session.getAttribute("me") != null%>;
$(function(){
	if(login){
		$("login_status").html("已登陆");
		$("login_form").hide();
	}else{
		$("login_status").html("未登陆");
		$("login_link").hide();
	}
	
	$("#login_form").submit(function(){
		$.ajax({
			url : "/nut/usr/login",
			data : $("#login_form").serialize(),
			success : function(res){
				aler("res="+res);
				if(res == "true"){
					alert("登陆成功");
					$("login_link").show();
					$("login_form").hide();
					$("login_status").html("已登陆");
				}else{
					alert("登陆失败");
					$("login_link").hide();
					$("login_form").show();
				}
				return false;
			},
			fail : function(){
				alert("系统错误");
			}
		});
		return false;
	});
});
</script>
</head>
<body>
<h2 id="login_status"></h2>
<form id = "login_form" action = "#">
用户名：<input name="name"/>
密码：<input name="passwd"/>
<input type="submit" value = "提交"></input>
</form>
</body>
</html>
