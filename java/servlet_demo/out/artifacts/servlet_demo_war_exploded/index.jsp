<%--
  Created by IntelliJ IDEA.
  User: huxingxin
  Date: 2021/8/8
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%--取得ServletContext中的值--%>
<%--    ${applicationScope['value-listener']}--%>

<%--      <jsp:include page="/login" />--%>
<%--      <jsp:forward page="/login" />--%>
  <script>
    window.location="${pageContext.request.contextPath}/login";
  </script>
  </body>
</html>
