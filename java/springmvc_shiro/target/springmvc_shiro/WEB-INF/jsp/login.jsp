<%--
  Created by IntelliJ IDEA.
  User: huxingxin
  Date: 2021/8/8
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap/3.3.6/bootstrap.css" rel="stylesheet">
    <style>
        body{
            background-image: url(${pageContext.request.contextPath}/static/img/login-background.png);
            background-repeat: no-repeat;
            background-size: cover;
        }
        .loginWrapper{
            height: 200px;
            background-color: rgba(0,0,0,0.2);
            padding: 30px;
            margin-left: 65%;
            margin-top: 200px;
            border: 1px solid #2aabd2;
            border-radius: 15px;
            padding-top: 50px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-xs-3 loginWrapper">
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/login">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="userName" class="form-control" placeholder="请输入用户名">
                            <div class="input-group-addon"><label class="glyphicon glyphicon-user"></label></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="password" class="form-control" placeholder="请输入密码">
                            <div class="input-group-addon"><label class="glyphicon glyphicon-lock"></label></div>
                        </div>
                    </div>
                    <div>
                        <div>
                            <button class="btn btn-info col-lg-12" style="border-radius: 20px">登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
