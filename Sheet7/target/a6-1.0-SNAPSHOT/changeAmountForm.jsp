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
<h1 align="center">Change the amount of an accounting entry</h1>
<hr>
<form action="changeAmount.jsp" method="put">
  <div align="center">
    <p>
      <label>Old Amount : </label>
      <input name="Old Amount"/>
      <br>
      <label>New Amount : </label>
      <input name="New Amount"/>
      <br>
      <input type="submit" value="Change amount">
    </p>
  </div>
</form>
</body>
</html>