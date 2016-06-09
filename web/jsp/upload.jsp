<%--
  Created by IntelliJ IDEA.
  User: raist
  Date: 2016/5/25
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<div align="center">
    <h1>Upload</h1>
    <form method="post" action="${pageContext.request.contextPath}/test/hello/doUpload" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" />
    </form>
</div>
</body>
</html>
