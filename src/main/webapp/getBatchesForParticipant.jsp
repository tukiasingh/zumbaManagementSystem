
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

    <h4> Showing Batches for participant ${participantName}</h4> <br>
        <table  class="table table-striped">
            <thead>
            <tr>
                <td>Batch ID</td>
                <td>Class</td>
                <td>Time</td>
                <td>Action</td>
            </tr>
            </thead>
            <c:forEach var="batch" items="${batches}">
                <tr>
                    <td>${batch.getBid()}</td>
                    <td>${batch.getTitle()}</td>
                    <td type="datetime-local">${batch.getStartTime()}</td>
                    <td>
                        <button type="button" class="btn btn-warning"
                                onclick="window.location='batch-assignment?pid=${pid}&bid=${batch.getBid()}&crudOperationType=unregisterToBatch'">Unregister</button>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
