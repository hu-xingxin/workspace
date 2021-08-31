<%--
  Created by IntelliJ IDEA.
  User: huxingxin
  Date: 2021/5/21
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
  <head>
    <title>Error</title>
  </head>
  <body>
    An error has occurred.
    <br>
    Error Message:
    <%
      out.println(exception.toString());
    %>
  </body>
</html>
