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
    String accountName = (String) request.getSession().getAttribute("Account Name");
%>
<h2 align="center">Account : <%=accountName%></h2>
<br>
<%
    double amount = Double.parseDouble(request.getParameter("Amount"));
    String date = request.getParameter("Date");
    String otherAccount = request.getParameter("Other's Account");

    for (Account account : AccountManager.accounts){
        if (account.getName().equals(accountName)){
            account.addEntry(amount,date,otherAccount);
        }
    }
%>
<h2 align="center"> <%=amount%> successfully sent to <%=otherAccount%> on <%=otherAccount%>.</h2>
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