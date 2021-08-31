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
        <ul style="color:#f00;">
            <c:forEach var="error" items="${errors}">
                <li>${error}</li>
            </c:forEach>
        </ul>

      <form method="post" action="save">
        <table style="border: 1px solid #000;padding: 20px">
          <tbody>
              <tr>
                <td>name:</td>
                <td><input type="text" name="name" value="${productFrom.name}"></td>
              </tr>
              <tr>
                <td>description:</td>
                <td><textarea rows="5" cols="20" name="description" style="vertical-align: top">${productFrom.description}</textarea></td>
              </tr>
              <tr>
                <td>price:</td>
                <td><input type="text" name="price" value="${productFrom.price}"></td>
              </tr>
              <tr>
                <td><button type="submit">提交</button></td>
                <td><button type="reset" id="reset">重置</button></td>
              </tr>
          </tbody>
        </table>
      </form>
        <script>
            var reset = document.getElementById("reset");
            reset.onclick = function () {
                document.getElementsByClassName("name");
                document.getElementsByClassName("description");
                document.getElementsByClassName("price");
            }
        </script>
  </body>
</html>