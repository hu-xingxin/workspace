<%--
  Created by IntelliJ IDEA.
  User: huxingxin
  Date: 2021/8/11
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
<%--  <p style="font-size:30px;color: #2aabd2">welcome to springMvc <span onclick="toLogin()" style="font-weight: bold">8081</span></p>--%>
  <script>
   function toLogin() {
     window.location="${pageContext.request.contextPath}/menu";
   }

   window.location="${pageContext.request.contextPath}/menu";
  </script>
  </body>
</html>
