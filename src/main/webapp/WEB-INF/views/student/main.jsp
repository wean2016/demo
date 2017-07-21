<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/7/20
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>主页</title>


</head>

<body>
<h1>学生主页</h1>
<hr>
<a href="/student/information">查看/修改个人信息</a>
</body>
</html>