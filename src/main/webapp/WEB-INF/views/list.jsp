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

    <title>查看学生列表</title>


</head>
<table>
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>性别</th>
        <th>修改</th>
        <th>删除</th>
    </tr>


    <c:if test="${!empty requestScope.list}">
        <c:forEach items="${requestScope.list}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.studentName}</td>
                <td>${student.studentGender}</td>
                <td><a href=""></a></td>
                <td><a href=""></a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<body>

</body>
</html>
