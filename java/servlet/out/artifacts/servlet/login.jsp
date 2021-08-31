<%--
  Created by IntelliJ IDEA.
  User: huxingxin
  Date: 2021/5/30
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>login</title>
</head>
<body>
<form action="j_security_check" method="post">
  loginName:<input type="text" name="j_username">
  passWord:<input type="text" name="j_password">
  <input type="submit">
</form>
</body>
</html>
