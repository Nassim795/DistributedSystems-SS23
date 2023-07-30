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
<h1 align="center">Add a new accounting entry</h1>
<hr>
<form action="addEntry.jsp" method="post">
    <div align="center">
        <p>
            <label>Amount : </label>
            <input name="Amount"/>
            <label>Date : </label>
            <input name="Date" type="date"/>
            <br>
            <label>To : </label>
            <input name="Other's Account"/>
            <br>
            <input type="submit" value="Send">
        </p>
    </div>
</form>
</body>
</html>