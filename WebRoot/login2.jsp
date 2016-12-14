<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
	<h1><font color="red">User Login</font> </h1>
	
	<s:form action="userinfo_login.action">
		<s:textfield name="userinfo.name" label="%{getText('name')}"></s:textfield>
		<s:textfield name="userinfo.password" label="%{getText('password')}"></s:textfield>
		<s:submit></s:submit>
	</s:form>
	
  </body>
</html>
