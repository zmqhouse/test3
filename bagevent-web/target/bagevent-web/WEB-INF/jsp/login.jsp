<%--
  Created by IntelliJ IDEA.
  User: 17284
  Date: 2020/3/31
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<script src="/js/b.js" crossorigin></script>
<script src="/js/a.js" crossorigin></script>

<body>
<h2>登录</h2>


<form action="${pageContext.request.contextPath}/user/login" method="post">
    手机号:<input type="text" name="cellphone"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录"><a href="${pageContext.request.contextPath}/user/register">没有账号去注册</a>

</form>
<div id="like_button_container"></div>


</body>
<!-- 加载我们的 React 组件。-->
<script src="/js/like_button.js"></script>

</html>
