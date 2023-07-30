<%@ page import="com.Sheet7.AccountManager" %>
<%@ page import="com.Sheet7.Account" %>
<%@ page import="com.Sheet7.AccountingEntries" %><%--
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
  double oldAmount = Double.parseDouble(request.getParameter("Old Amount"));
  double newAmount = Double.parseDouble(request.getParameter("New Amount"));

  for (Account account : AccountManager.accounts){
    if (account.getName().equals(accountName)){
      AccountingEntries entry = account.searchEntry(oldAmount);
      if (entry != null){

        entry.setAmount(newAmount);
%>
<h2>Entry amount changed from "<%=oldAmount%>" to "<%=entry.getAmount()%>"</h2>
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
<%      }
}
}
%>
</body>
</html>