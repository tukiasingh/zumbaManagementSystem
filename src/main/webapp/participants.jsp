
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

        <h5> Participants</h5> <br>
        <button type="button" class="btn btn-primary align-content-sm-end"
                onclick="window.location='participant-filter?jspPageType=addParticipantPage'">Add Participant</button>
        <table  class="table table-striped">
            <thead>
            <tr>
                <th>Participant ID</th>
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
                        <button type="button" class="btn btn-primary"
                            onclick="window.location='participant-filter?pid=${participant.getPid()}&jspPageType=updateParticipantPage'">Update</button>
                        <button type="button" class="btn btn-danger" name="crudOperationType" value="deleteParticipant"
                                onclick="window.location='participant-controller?pid=${participant.getPid()}&crudOperationType=deleteParticipant'">Delete</button>
                        <button type="button" class="btn btn-primary" name="crudOperationType" value="getBatchesPerParticipantByPid"
                            onclick="window.location='participant-filter?pid=${participant.getPid()}&jspPageType=getBatchesPerParticipantPage'">Show Registered Batches</button>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location='participant-filter?pid=${participant.getPid()}&jspPageType=findABatchForParticipantPage'">Find A Batch</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>