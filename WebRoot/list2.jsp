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
    <table border="1" cellspacing="0" align="center" width="80%" >
    
		<h1><font color="red">User List</font> </h1>
		
		<s:a href="index.jsp">主     页</s:a> &nbsp; &nbsp; &nbsp;
		<s:a href="add.jsp">增加用户</s:a> &nbsp; &nbsp; &nbsp;
		<s:a href="userinfo_download.action">生成Excel</s:a>
		
		<tr>
			<td>序号
			</td>
			
			<td>昵称
			</td>
			
			<td>权限
			</td>
			
			
			<td>删除
			</td>
			
			<td>更新
			</td>
		</tr>
		
	<s:iterator value="#request.list2" id="us">
		<tr>
			<td><s:property value="#us.id"/>
			</td>
			
			<td><s:property value="#us.name"/>
			</td>
			
			<td><s:property value="#us.status"/>
			</td>
			
			
			<td><s:a href="userinfo_delete.action?userinfo.id=%{#us.id}">delete</s:a>
			</td>
			
			<td><s:a href="userinfo_updateP.action?userinfo.id=%{#us.id}">update</s:a>
			</td>
		</tr>
		
	</s:iterator>		
		
	</table>
  </body>
</html>

