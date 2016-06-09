<%--
  Created by IntelliJ IDEA.
  User: raist
  Date: 2016/5/26
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
    <h1>Logout</h1>
    <hr />
    <p><%=session.getAttribute("loginUser")%> currently logged in.</p>
    <a href="${pageContext.request.contextPath}/test/hello/logout">Logout</a>
</body>
</html>
