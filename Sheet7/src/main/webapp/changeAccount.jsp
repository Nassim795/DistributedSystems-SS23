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
    <title>Bank Account Manager</title>
</head>
<body>
<%
    String accountName = request.getParameter("Account Name");
    for (Account account: AccountManager.accounts){
        if (account.getName().equals(accountName)){
            request.getSession().setAttribute("Account Name", accountName);%>
            <h2>Account changed. Your current Account is: <%=accountName%></h2>
<div align="center">
    <a href="createAccountForm.jsp">Create new Account</a>
    <br>
    <a href="changeAccountForm.jsp">Change current Account</a>
    <br>
    <a href="addEntryForm.jsp">Add a new accounting entry</a>
    <br>
    <a href="searchEntryForm.jsp">Search for an accounting entry</a>
    <br>
    <a href="showEntries.jsp">Show all accounting entries</a>
    <br>
    <a href="changeAmountForm.jsp">Change an entry amount</a>
</div>

<%
            return;
        }
    }
%>

<h2>Account does not exist</h2>
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
    <a href="showEntries.jsp">Show all accounting entries</a>
    <br>
    <a href="changeAmountForm.jsp">Change an entry amount</a>
</div>
</body>
</html>