<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/7/20
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>学生注册</title>


</head>

<body>
<form action="/regist" method="post" enctype="multipart/form-data">
    学号：<input type="text" name="studentId"> <br>
    姓名：<input type="text" name="studentName"> <br>
    性别：<input type="radio" name="studentGender" value="0">男 &nbsp;
         <input type="radio" name="studentGender" value="1">女 <br>
    密码：<input type="password" name="studentPassword"> <br>
    头像：<input type="file" name="avatar"> <br>
    <input type="submit" value="注册">
</form>
</body>
</html>