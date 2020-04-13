<%--
  Created by IntelliJ IDEA.
  User: 17284
  Date: 2020/3/31
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h2>注册</h2>

<form action="${pageContext.request.contextPath}/user/saveRegister" method="post">
    手机号:<input type="text" name="cellphone"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="注册"><a href="/">去登录</a>
</form>

</body>
</html>
