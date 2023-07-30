<%--
  Created by IntelliJ IDEA.
  User: NassimLA
  Date: 04.07.23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Bank Account Manager</title>
</head>

<body>
<h1 align="center">Search for an accounting entry</h1>
<hr>
<form action="searchEntry.jsp" method="get">
  <div align="center">
    <p>
      <label>Amount : </label>
      <input name="Amount"/>
      <br>
      <input type="submit" value="Search Entry">
    </p>
  </div>
</form>
</body>
</html>