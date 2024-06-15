
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <jsp:include page="header.html"></jsp:include>

        <form action="participant-controller" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="textName" value="${participant.getName()}">
            </div>
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control" id="email" name="textEmail"  aria-describedby="emailHelp" value="${participant.getEmail()}">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="text" class="form-control" id="phone" name="textPhone"  value="${participant.getPhoneNumber()}">
            </div>
                <input type="hidden" name="crudOperationType" value="updateParticipant"><br>
                <input type="hidden" name="pid" value="${participant.getPid()}"><br>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>


</body>
</html>
