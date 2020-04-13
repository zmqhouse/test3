<%--
  Created by IntelliJ IDEA.
  User: 17284
  Date: 2020/3/31
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>地址</th>
        <th>电话号码</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="obj">
        <tr>
            <th>${obj.userId}</th>
            <th>${obj.userName}</th>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
