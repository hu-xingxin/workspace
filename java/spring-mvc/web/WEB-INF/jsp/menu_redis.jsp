<%--
  Created by IntelliJ IDEA.
  User: huxingxin
  Date: 2021/8/8
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>menu</title>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap/3.3.6/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row" style="text-align: center">
        <div class="col-xs-4" style="margin-left: 30%;margin-top: 10%">
            <div class="list-group">
                <p style="font-size:25px;color: #2aabd2">welcome to <span>SpringMVC</span></p>
                <a id="redisAdd" class="list-group-item active">redisAdd 添加redis数据</a>
                <a id="redisGet" class="list-group-item list-group-item-success">redisGet 获取redis数据</a>
                <a id="login" class="list-group-item list-group-item-info">login 登录</a>
            </div>
        </div>
    </div>
</div>
<script>
    var ctx = '${pageContext.request.contextPath}';

    $('#redisAdd').click(function () {
        $.ajax({
            url: ctx+'/redis/add',
            type:'post',
            dataType:'json',
            success: function (data) {
                console.log(data);
            }
        })
    });

    $('#redisGet').click(function () {
        $.ajax({
            url: ctx+'/redis/get',
            type:'post',
            dataType:'json',
            success: function (data) {
                console.log(data);
            }
        })
    });

    $('#login').click(function () {
        window.location = ctx + "/login"
    });

</script>
</body>
</html>
