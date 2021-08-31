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
    <title>fileUpload</title>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-fileupload/js/fileinput.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-fileupload/js/locales/zh.js"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/bootstrap-fileupload/css/fileinput.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/bootstrap-fileupload/css/icons.min.css" rel="stylesheet" crossorigin="anonymous">

    <style>
        .modal-content {overflow: auto;max-height:550px;}
    </style>
</head>
<body>
    <%--文件上传 模态窗开始--%>
    <div class="modal fade" id="fileUploadModal" tabindex="-1" role="dialog" aria-labelledby="fileUploadModalLabel">
        <div class="modal-dialog" >
            <div class="modal-content">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">文件上传</h4>
                </div>
                <div class="modal-body">
                    <%--文件上传开始--%>
                    <div class="file-loading">
                        <input id="file-upload" name="file" type="file" multiple>
                    </div>
                    <%--文件上传结束--%>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="button" id="fileUploadSubmit">提交</button>
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
    <%--文件上传 模态窗结束--%>
<%--    <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="confirmSmallModalLabel">--%>
<%--        <div class="modal-dialog modal-sm" role="document">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    操作提示--%>
<%--                </div>--%>
<%--                <div class="modal-body" align="center">--%>
<%--                   <sapn>确定要上传该附件吗?</sapn>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button data-dismiss="modal" class="btn btn-default" type="button" id="close">关闭</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="container">
        <div class="row">
            <input class="btn btn-primary" type="button" value="文件上传" data-toggle="modal" data-target="#fileUploadModal">
        </div>
    </div>
    <script>
        $('#file-upload').fileinput({
            theme: 'fas',
            language: 'zh',
            uploadUrl: 'upload',
            allowedFileExtensions: ['jpg', 'png', 'gif', 'docx', 'doc', 'txt']
        }).on("fileuploaded",function (event, data, previewId, index) {
            console.log(data.response)
            console.log(data.response.data.filePath)
        });

        /*用js控制文件上传模态窗口的开关*/
        $("#fileUploadSubmit").click(function(){
            $("#fileUploadModal").modal('hide');
        });
    </script>
    </body>
</html>
