<%--
  Created by IntelliJ IDEA.
  User: huxingxin
  Date: 2021/10/10
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>order</title>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap/3.3.6/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-6">
                <form class="form-horizontal">
                    <h3 align="center">Order Form</h3>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">姓名:</span>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" value="${order.name}" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">地址:</span>
                        <div class="col-sm-10">
                            <input type="text" name="address" class="form-control" value="${order.address}" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">城市:</span>
                        <div class="col-sm-10">
                            <select name="cities" class="form-control" disabled="disabled">
                                <c:if test="${order.cities == 'yangZhou'}">
                                    <option value="yangZhou">扬州</option>
                                </c:if>
                                <c:if test="${order.cities == 'nanJing'}">
                                    <option value="">南京</option>
                                </c:if>
                                <c:if test="${order.cities =='suZhou'}">
                                    <option value="">苏州</option>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">快递:</span>
                        <div class="col-sm-10">

                            <label class="radio-inline">
                                <c:if test="${order.expresses == 'yunDa'}">
                                    <input type="radio" name="expresses" value="yunDa" disabled="disabled" checked>韵达
                                </c:if>
                                <c:if test="${order.expresses != 'yunDa'}">
                                    <input type="radio" name="expresses" value="yunDa" disabled="disabled">韵达
                                </c:if>
                            </label>
                            <label class="radio-inline">
                                <c:if test="${order.expresses == 'shunFeng'}">
                                    <input type="radio" name="expresses" value="shunFeng" disabled="disabled" checked>顺丰
                                </c:if>
                                <c:if test="${order.expresses != 'shunFeng'}">
                                    <input type="radio" name="expresses" value="shunFeng" disabled="disabled">顺丰
                                </c:if>
                            </label>
                            <label class="radio-inline">
                                <c:if test="${order.expresses == 'yunTong'}">
                                    <input type="radio" name="expresses" value="yunTong" disabled="disabled" checked>圆通
                                </c:if>
                                <c:if test="${order.expresses != 'yunTong'}">
                                    <input type="radio" name="expresses" value="yunTong" disabled="disabled">圆通
                                </c:if>
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">额外服务:</span>
                        <div class="col-sm-10" id="otherService">
                            <label class="checkbox-inline">
                                <input type="checkbox" name="otherService" value="insurance" disabled="disabled" id="insurance">运费险
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="otherService" value="backOff" disabled="disabled" id="backOff">七天无理由退货
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="otherService" value="guarantee" disabled="disabled" id="guarantee">半年保修卡
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">备注:</span>
                        <div class="col-sm-10">
                            <textarea name="remark" class="form-control" style="height: 150px" disabled="disabled">${order.remark}</textarea>
                        </div>
                    </div>
                    <div>
                        <div align="center">
                            <a class="btn btn-success " type="button" href="${pageContext.request.contextPath}/toOrder">返回</a>
                            <button class="btn btn-success " type="button" id="reload">刷新</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        $('#reload').click(function () {
           window.location.reload();
        })

        <c:forEach items="${order.otherService}" var="item">
            <c:if test="${item == 'insurance'}">
                $('#insurance').attr('checked','true');
            </c:if>
            <c:if test="${item == 'backOff'}">
                 $('#backOff').attr('checked','true');
            </c:if>
            <c:if test="${item == 'guarantee'}">
                $('#guarantee').attr('checked','true');
            </c:if>
        </c:forEach>

    </script>
</body>
</html>
