
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="header.html"></jsp:include>

    <h4> Showing Participants for Batch ${batchTitle}</h4> <br>

    <table  class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach var="participant" items="${participants}">
            <tr>
                <td>${participant.getPid()}</td>
                <td>${participant.getName()}</td>
                <td>${participant.getPhoneNumber()}</td>
                <td>${participant.getEmail()}</td>
                <td>
                    <button type="button" class="btn btn-warning"
                            onclick="window.location='batch-assignment?pid=${participant.getPid()}&bid=${bid}&crudOperationType=unregisterToBatch'">Unregister</button>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
