<%--
  Created by IntelliJ IDEA.
  User: huxingxin
  Date: 2021/10/10
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <form class="form-horizontal" method="post" action="/servlet/addOrder">
                    <h3 align="center">Order Form</h3>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">姓名:</span>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" placeholder="请填写姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">地址:</span>
                        <div class="col-sm-10">
                            <input type="text" name="address" class="form-control" placeholder="请输入地址">
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">城市:</span>
                        <div class="col-sm-10">
                            <select name="cities" class="form-control">
                                <option value="yangZhou">扬州</option>
                                <option value="nanJing">南京</option>
                                <option value="suZhou">苏州</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">快递:</span>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="expresses" value="yunDa">韵达
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="expresses" value="shunFeng">顺丰
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="expresses" value="yunTong">圆通
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">额外服务:</span>
                        <div class="col-sm-10">
                            <label class="checkbox-inline">
                                <input type="checkbox" name="otherService" value="insurance">运费险
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="otherService" value="backOff">七天无理由退货
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="otherService" value="guarantee">半年保修卡
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-2 control-label">备注:</span>
                        <div class="col-sm-10">
                            <textarea name="remark" class="form-control" style="height: 150px"></textarea>
                        </div>
                    </div>
                    <div>
                        <div align="center">
                            <input class="btn btn-success " type="submit">
                            <input class="btn btn-warning" type="reset">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
