<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.szy.test.model.*"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>operation</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
	<% Userinfo userinfo =(Userinfo)session.getAttribute("userinfo"); %>
	<h1><font class="red">Hello     <%=userinfo.getName() %></font> </h1>
	<s:a href="userinfo_addUI.action">User add</s:a> <br>
	
	<s:a href="userinfo_list.action">User list</s:a> <br>
	
  </body>
</html>
