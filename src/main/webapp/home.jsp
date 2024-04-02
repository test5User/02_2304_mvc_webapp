<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%
    String header = "Hello from jsp!!!";
%>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <%-- Comment --%>
    <h1><%= header %></h1>
    <p>Today <%= new Date() %></p>
</body>
</html>
