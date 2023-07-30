<%@ page import="java.util.Set" %>
<%@ page import="com.Sheet7.AccountingEntries" %>
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
<h2 align="center">All accounting entries : </h2>
<hr>
<%
  String accountName = (String) request.getSession().getAttribute("Account Name");
%>
<h2>Account : <%=accountName%></h2>
<br>
<%

  for (Account account : AccountManager.accounts){
    if (account.getName().equals(accountName)){

      Set<AccountingEntries> entries = account.getEntries();
      for (AccountingEntries accountingEntries : entries){
%>
<h2>Entry: <%=accountingEntries.getAmount()%>, <%=accountingEntries.getDate()%>, <%=accountingEntries.getOtherAccount()%></h2>
<br>
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
<%     }
    }
  }
%>
</body>
</html>