    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@ page import="com.szy.test.model.*"%>
        <%@ taglib uri="/struts-tags" prefix="s"%>
        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>Login Or Register</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  <link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
    input{
    
    }
  </style>
</head>
<body>
<%
Userinfo userinfo =(Userinfo)session.getAttribute("userinfo");
if(userinfo!=null){
	userinfo = new Userinfo();
	session.setAttribute("msg", "您已经登录了");
	response.sendRedirect("index.jsp");
}
%>
<div class="header">
  <div class="am-g">
    <h1>User Login</h1>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-7 am-u-sm-centered" style="border:1px solid lightgray;border-raduis:5px;padding:0 0 0 0;">
		<%
		  String msg = (String)session.getAttribute("msg");
		  if(msg==null){
			  msg="";
		  }else{
		  %>
		<div class="am-alert am-alert-danger" data-am-alert>
		  <p style="text-align:center;"><%=msg %></p>
		</div>
		<% } %>
	 <br>
    <div data-am-widget="tabs"
       class="am-tabs am-tabs-default"
        >
      <ul class="am-tabs-nav am-cf">
          <li class="am-active"><a href="[data-tab-panel-0]">登录</a></li>
          <li class=""><a href="[data-tab-panel-1]">注册</a></li>
      </ul>
      <div class="am-tabs-bd">
           <div data-tab-panel-0 class="am-tab-panel am-active">
		
		    <form method="post" class="am-form" action="userinfo_login.action">
		      <label for="name">用户名:</label>
		      <input type="text" name="userinfo.name" id="name" value="">
		      <br>
		      <label for="password">密码:</label>
		      <input type="password" name="userinfo.password" id="password" value="">
		      <br>
		      <label for="remember-me">
		        <input id="remember-me" type="checkbox">
		        记住密码
		      </label>
		      <br />
		      <div class="am-cf">
		        <input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
		        <input type="submit" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
		      </div>
		    </form>
		          
          </div>
          <div data-tab-panel-1 class="am-tab-panel ">
	
			
			    <form method="post" class="am-form" action="userinfo_add.action">
			      <label for="name">用户名:</label>
			      <input type="text" name="userinfo.name" id="name" value="">
			      <br>
			      <label for="password">密码:</label>
			      <input type="password" name="userinfo.password" id="password" value="">
			      <br>
			      <label for="status">权限:</label>
			      <input type="text" name="userinfo.status" id="status" value="">
			      <br />
			      <div class="am-cf">
			        <input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
			       
			      </div>
			    </form>
          </div>

      </div>
  </div>
  
  
 
    <hr>
    <p>© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
  </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="assets/js/amazeui.min.js"></script>x
</body>
</html>
