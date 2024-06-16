
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Participants</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">


</head>
<body>
<div class="container">
    <jsp:include page="header.html"></jsp:include>

    <h5>Batches</h5> <br>
    <button type="button" class="btn btn-primary align-content-sm-end"
            onclick="window.location='batch-filter?jspPageType=addBatchPage'">Add Batch</button>
    <table  class="table table-striped">
        <thead>
        <tr>
            <th>Batch ID</th>
            <th>Title</th>
            <th>Batch Time</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach var="batch" items="${batches}">
            <tr>
                <td>${batch.getBid()}</td>
                <td>${batch.getTitle()}</td>
                <td type="datetime-local">${batch.getStartTime()}</td>
                <td>
                    <button type="button" class="btn btn-primary"
                            onclick="window.location='batch-filter?bid=${batch.getBid()}&jspPageType=updateBatchPage'">Update</button>
                    <button type="button" class="btn btn-danger"
                            onclick="window.location='batch-controller?bid=${batch.getBid()}&crudOperationType=deleteBatch'">Delete</button>
                    <button type="button" class="btn btn-primary"
                            onclick="window.location='batch-filter?bid=${batch.getBid()}&jspPageType=getParticipantsPerBatchPage'">Show Participants</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
