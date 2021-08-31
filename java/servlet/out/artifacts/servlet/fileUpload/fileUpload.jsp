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
     <form action="/uploadFile" method="post" enctype="multipart/form-data">
         Author：<input type="text" name="author"><br/>
         Fist file to upload <input type="file" name="file"> <br/>
         Second file to upload <input type="file" name="file"> <br/>
         <input type="submit" value="upload">
     </form>
  </body>
</html>