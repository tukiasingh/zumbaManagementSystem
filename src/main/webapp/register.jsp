<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="org.example.model.User" %>
<%@ page import="org.example.db.DB" %>
<%@ page import="org.example.db.DB" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: vijay
  Date: 5/12/24
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Admin</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<form class="form-control"  action="register-admin" method="post">
    <div class="form-group">
        <label for="email">Email Address</label>
        <input type="email" class="form-control" id="email" name="textEmail"  aria-describedby="emailHelp">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>

    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="textPassword">
    </div>
<%--    <input type="hidden" name="crudOperationType" value="addParticipant"><br>--%>
    <%--        <input type="hidden" name="pid" value="${participant.getPid()}"><br>--%>
    <button type="submit" class="btn btn-primary">Register Admin</button>
</form>

</body>
</html>
