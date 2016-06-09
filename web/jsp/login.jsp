<%--
  Created by IntelliJ IDEA.
  User: raist
  Date: 2016/4/4
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login</title>
  </head>
  <body>
  <h1>login</h1>
  <hr>
  <%--<form action="dologin.jsp" name="loginForm" method="post">--%>
  <form action="${pageContext.request.contextPath}/test/hello/login" name="loginForm" method="post">
    <table>
      <tr>
        <td>USERNAME</td>
        <td>
          <input type="text" name="username" title="username">
        </td>
      </tr>
      <tr>
        <td>PASSWORD</td>
        <td>
          <input type="password" name="password" title="password">
        </td>
      </tr>
      <tr>
        <td colspan="2" align="left">
          <input type="submit" value="submit">
        </td>
      </tr>
    </table>
  </form>
  <%
    //System.out.println("hit login.jsp");
  %>
  </body>
</html>
