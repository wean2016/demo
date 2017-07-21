<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/7/21
  Time: 16:40
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

    <title>个人信息</title>


</head>

<body>
<img src="${student.studentAvatar}" alt="头像">
<form action="/student/updateAvatar" method="post" enctype="multipart/form-data">
    <input type="file" name="avatar">
    <input type="submit" value="修改">
</form>
<hr>
<form:form action="/student/information" method="post" modelAttribute="student">
    Password: <form:password path="studentPassword"/>
    <form:errors path="studentPassword"/>
    <br>
    <form:input path="studentName"/>
    <form:errors path="studentName"/>
    <br>
    <form:input path="studentGender"/>
    <form:errors path="studentGender"/>
    <br>
    <input type="submit" value="登陆">
</form:form>
</body>
</html>