<%--
  Created by IntelliJ IDEA.
  User: huxingxin
  Date: 2021/5/21
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="m" %>
<%@ taglib uri="/WEB-INF/function.tld" prefix="fun" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/errorPage.jsp" %>
<html>
  <head>
    <title>product input</title>
  </head>
  <body>
      name:${product.name}
      <br>
      description:${product.description}
      <br>
      price:${product.price}
  </body>
</html>