<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/7/20
  Time: 16:34
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

    <title>登陆</title>


</head>

<body>
登陆页面
<form:form action="/studentSignIn" method="post" modelAttribute="student">
    Id: <form:input path="studentId"/>
        <form:errors path="studentId"/>
        <br>
    Password: <form:password path="studentPassword"/>
                <form:errors path="studentPassword"/>
                <br>
    <form:hidden path="studentName"/>
    <form:hidden path="studentGender"/>
    <input type="submit" value="登陆">
    ${loginStatus}
</form:form>
</body>
</html>