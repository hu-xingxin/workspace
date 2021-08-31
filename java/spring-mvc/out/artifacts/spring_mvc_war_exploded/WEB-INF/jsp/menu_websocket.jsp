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
                <a class="list-group-item active">当前在线人数为:<span id="userNum"></span>人</a>
            </div>
        </div>
    </div>
</div>
<script>
    var ctx = '${pageContext.request.contextPath}';
    var webSocket = null;
    //判断当前浏览器是否支持WebSocket
    if('WebSocket' in window){
        webSocket = new WebSocket('ws://localhost:8084/demo/ws/bitCoinServer');

        //连接成功建立的回调方法
        webSocket.onopen = function () {
            webSocket.send('客户端链接成功');
        }

        //接收到消息的回调方法
        webSocket.onmessage = function (event) {
            $('#userNum').text(event.data);
        }

        //连接发生错误的回调方法
        webSocket.onerror = function () {
            alert("WebSocket连接发生错误")
        }

        //连接关闭的回调方法
        webSocket.onclose = function () {
            alert("WebSocket连接关闭");
        }

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            webSocket.close();
        }
    } else {
        alert('当前浏览器 Not support websocket')
    }
</script>
</body>
</html>
