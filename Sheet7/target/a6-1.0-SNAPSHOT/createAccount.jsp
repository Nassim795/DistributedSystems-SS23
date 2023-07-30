<%@ page import="com.Sheet7.Account" %>
<%@ page import="com.Sheet7.AccountManager" %><%--
  Created by IntelliJ IDEA.
  User: NassimLA
  Date: 04.07.23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Account</title>
</head>
<body>
<%
    String name = request.getParameter("Account Name");
    Account account = new Account(name);
    AccountManager.accounts.add(account);
    request.getSession().setAttribute("Account Name", name);
%>
<h2 align="center">A new Account with the name <%= name %> was created</h2>
<div align="center">
    <br>
    <a href="index.jsp">Go back to main page</a>
    <br>
    <a href="createAccountForm.jsp">Create a new Account</a>
    <br>
    <a href="changeAccountForm.jsp">Change current Account</a>
    <br>
    <a href="addEntryForm.jsp">Add a new accounting entry</a>
    <br>
    <a href="searchEntryForm.jsp">Search for an accounting entry</a>
    <br>
    <a href="changeAmountForm.jsp">Change an entry amount</a>
</div>
</body>
</html>