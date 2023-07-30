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
<h1 align="center">Create New Account</h1>
<hr>
<form action="createAccount.jsp" method="post">
    <div align="center">
        <p>
            <label>Account Name : </label>
            <input name="Account Name"/>
            <input type="submit" value="create">
        </p>
    </div>
</form>
</body>
</html>