<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.szy.test.model.*"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport"
        content="width=device-width, initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
  <title>System 1</title>
  <meta name="description" content="è¿æ¯ä¸ä¸ªformé¡µé¢">
  <meta name="keywords" content="form">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">ä½ æ­£å¨ä½¿ç¨<strong>è¿æ¶</strong>çæµè§å¨ï¼Amaze UI æä¸æ¯æã è¯· <a href="http://browsehappy.com/" target="_blank">åçº§æµè§å¨</a>
  ä»¥è·å¾æ´å¥½çä½éªï¼</p>
<![endif]-->
<%
Userinfo user =(Userinfo)session.getAttribute("userinfo");
if(user==null){
	user = new Userinfo();
	session.setAttribute("msg","login failed");
	response.sendRedirect("login.jsp");
}
%>
<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
      <strong>学生系统</strong> <small>管理模板</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only"></span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning"></span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span>  <%=user.getName() %> <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="userinfo_logout.action"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">全屏打开</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="admin-index.html"><span class="am-icon-home"></span> 首页</a></li>
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 学生模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            <li><a href="finance_list.action" class="am-cf"><span class="am-icon-check"></span> 财务信息</a></li>
            <li><a href="book_list.action"><span class="am-icon-puzzle-piece"></span> 图书信息</a></li>
            <li><a href="medicine_list.action"><span class="am-icon-th"></span> 医疗信息</a></li>
            <li><a href="message_list.action"><span class="am-icon-calendar"></span> 聊天通信</a><span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></li>
          </ul>
        </li>
        <% if(!user.getStatus().equals("1")){ %>
        <li><a href="userinfo_list2.action"><span class="am-icon-table"></span> 用户管理</a></li>
        <li><a href="student_slist.action"><span class="am-icon-pencil-square-o"></span> 学生管理</a></li>
        <li><a href="classes_list.action"><span class="am-icon-sign-out"></span> 班级管理</a></li>
        <li><a href="major_list.action"><span class="am-icon-sign-out"></span> 专业管理</a></li>
        <li><a href="room_list.action"><span class="am-icon-sign-out"></span> 寝室管理</a></li>
        <% } %>
      </ul>


    </div>
  </div>
  <!-- sidebar end -->
