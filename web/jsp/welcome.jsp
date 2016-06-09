<%--
  Created by IntelliJ IDEA.
  User: raist
  Date: 2016/5/22
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Hello, this is Spring MVC Demo.</h1>
    <hr />
    <p><%=session.getAttribute("loginUser")%> currently logged in. <span><a href="${pageContext.request.contextPath}/jsp/logout.jsp">logout</a></span></p>
    <p>${test_msg}</p>
</body>
</html>
