
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <jsp:include page="header.html"></jsp:include>

        <br><br><br>
        <form class="form-control" action="participant-filter" method="post">

            <label  for="participantName">Participant</label>
            <select class="form-control" id="participantName" name="participantName">
                <option selected>Choose a Participant...</option>
                <c:forEach var="participant" items="${participants}">
                    <option value="${participant.getName()}">${participant.getName()}</option>
                </c:forEach>
            </select>
                <input type="hidden" name="jspPageType" value="getBatchesPerParticipantByName">
            <br><button type="submit" class="btn btn-primary">Show Registered Batches</button>
            <button type="button" class="btn btn-primary align-content-sm-end"
                    onclick="window.location='participant-filter?jspPageType=addParticipantPage'">Add Participant</button>



        </form>
        <br> <br><br> <br>

        <form class="form-control" action="batch-filter" method="post">
            <label for="batchTitle">Batch</label>
            <select class="form-control" id="batchTitle" name="batchTitle">
                <option selected>Choose a Batch...</option>
                <c:forEach var="batch" items="${batches}">
                    <option value="${batch.getTitle()}">${batch.getTitle()}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="jspPageType" value="getParticipantsPerBatchByName">
            <br><button type="submit" class="btn btn-primary">Show Participants</button>
            <button type="button" class="btn btn-primary align-content-sm-end"
                    onclick="window.location='batch-filter?jspPageType=addBatchPage'">Add Batch</button>

        </form>
        <br> <br>




    </div>

</body>
</html>
