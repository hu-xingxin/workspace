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
<%@ page errorPage="errorPage.jsp" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<html>
  <head>
    <title>welcome jsp</title>
  </head>
  <body>
<%--        <c:set var="name" value="${header}" scope="page"/>--%>
<%--        <c:out value="${name}"/>--%>


<%--        <c:forEach var="headerInfo" items="${header}" varStatus="status">--%>
<%--          ${status.last} 、${headerInfo.key} : ${headerInfo.value}--%>
<%--          <br>--%>
<%--        </c:forEach>--%>

<%--        <c:forEach var="value" items="1,2,3,4,5,6" varStatus="status">--%>
<%--            ${value}<br>--%>
<%--        </c:forEach>--%>

<%--        <fmt:formatNumber value="12" type="currency" currencyCode="USD" />--%>

<%--    <c:set var="now" value="2021-5-25" />--%>

<%--    <fmt:parseDate var="myDate" pattern="yyyy-MM-dd"  value="${now}" />--%>
<%--    <fmt:formatDate value="${myDate}" type="both" pattern="yyyy-MM-dd" />--%>

<%--    <br>--%>
<%--    ${fn:containsIgnoreCase("Hello Word", "hello")}--%>

<%--      <m:dataFormatter items="商品1,商品1,商品1" header="标题"></m:dataFormatter>--%>

<%--      <m:select>--%>
<%--        <option value="${select}">${text}</option>--%>
<%--      </m:select>--%>

<%--      ${fun:reverseString("1231")};--%>·

<%--        <c:forEach var="country" items="${countries}" varStatus="status">--%>
<%--          ${status.count} 、${country.key} : ${country.value}--%>
<%--          <br>--%>
<%--        </c:forEach>--%>


<%--  ${requestTime}--%>

<%--  <div style="width:1300px;margin: 0 auto">--%>
<%--    <img src="1.jpg" height="700px" width="1300px">--%>
<%--  </div>--%>

  ${pageContext.servletContext.getInitParameter("previewUrl")}
  <br/>
  ${pageContext.servletContext.getInitParameter("TOCC")}

  </body>
</html>