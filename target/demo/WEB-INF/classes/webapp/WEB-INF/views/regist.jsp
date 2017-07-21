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
<form:form action="/regist" method="post" enctype="multipart/form-data" modelAttribute="student">
    学号：<form:input path="studentId" />
        <form:errors path="studentId"/>
        <br>
    姓名：<form:input path="studentName"/>
        <form:errors path="studentName"/>
        <br>
    性别：<form:radiobutton path="studentGender" value="0" />男 &nbsp;
        <form:radiobutton path="studentGender" value="1"/>女
        <form:errors path="studentGender"/>
        <br>
    密码：<form:password path="studentPassword"/>
        <form:errors path="studentPassword"/>
        <br>
    头像：<input type="file" name="avatar"> <br>
    <input type="submit" value="注册">
</form:form>
</body>
</html>