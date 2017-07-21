<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/7/21
  Time: 21:40
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

    <title>教师登陆</title>


</head>

<body>
登陆页面
<form:form action="/teacherSignIn" method="post" modelAttribute="teacher">
    Id <form:input path="teacherId"/>
        <form:errors path="teacherId"/>
    <br>
    密码 <form:password path="teacherPassword"/>
        <form:errors path="teacherPassword"/>
    <br>
    <input type="submit" value="登陆">
    ${loginStatus}
</form:form>
</body>
</html>