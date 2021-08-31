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
    <div id="progressBar" style="height: 20px;border: 1px solid #2083e7;margin: 10px">
        <div id="bar" style="height: 100%;width: 0%;background-color: #4596ec">

        </div>
    </div>

     <form action="/uploadFile" method="post" enctype="multipart/form-data">
         <input type="file" id="file"  multiple style="display:block;margin: 10px">
         <output id="selectedFiles" style="display:block;color:#3c8ff3;margin: 10px"></output>
         <input type="button" id="uploadButton" value="upload" style="display:block;margin: 10px">
     </form>

    <div id="debug" style="height: 100px;border: 2px solid #3c8ff3;overflow: auto;margin: 10px">

    </div>

    <script type="text/javascript">

        var totalFileLength;//上传文件的总长度
        var totalUploaded;//已经上传的字节数
        var fileCount;//要上传的文件数
        var filesUploaded;//已经上传的文件数

        function debug(s) {
            var debug = document.getElementById('debug');
            if(debug){
                debug.innerHTML = debug.innerHTML + '<br/>' + s;
            }
        }

        function onUploadComplete(e) {
            totalUploaded += document.getElementById('file').files[filesUploaded].size;
            filesUploaded++;
            debug('totalUploaded: ' + totalUploaded);
            if(filesUploaded < fileCount){
                uploadNext();
            }else {
                // alert('Finished uploading file(s)')
            }
        }

        //在输出元素中 打印所选文件的名称和大小
        function onFileSelect(e) {
            var files = e.target.files;
            var outPut = [];
            fileCount = files.length;
            totalFileLength = 0;
            for (var i = 0; i < fileCount; i++) {
                var file = files[i];
                outPut.push(file.name,'(',file.size,'bytes,',file.lastModifiedDate.toLocaleString(),')');
                outPut.push('<br/>');
                debug('add' + file.size);
                totalFileLength += file.size;
            }

            document.getElementById('selectedFiles').innerHTML = outPut.join('');
            debug('totalFileLength: ' + totalFileLength);
        }

        function onUploadProgress(e) {
            if(e.lengthComputable){
                var percentComplete = parseInt((e.loaded + totalUploaded) * 100 / totalFileLength);
                var bar = document.getElementById('bar');
                bar.style.width = percentComplete + '%';
                bar.innerHTML = percentComplete + ' % complete';
            }else {
                debug('unable to compute');
            }
        }

        function onUploadFailed(e) {
            alert('Error uploading file');
        }

        function uploadNext() {
            var xhr = new XMLHttpRequest();
            var fd = new FormData();
            var file = document.getElementById('file').files[filesUploaded];
                fd.append('fileToUpload', file);
                xhr.upload.addEventListener('progress', onUploadProgress, false);
                xhr.addEventListener('load' ,onUploadComplete, false);
                xhr.open('POST','/uploadFile');
                debug('uploading', file.name);
                xhr.send(fd);
        }
        
        function startUpload() {
            totalUploaded = filesUploaded = 0;
            uploadNext();
        }

        window.onload = function(){
            document.getElementById('file').addEventListener('change', onFileSelect, false);
            document.getElementById('uploadButton').addEventListener('click', startUpload, false);
        }
    </script>
  </body>
</html>