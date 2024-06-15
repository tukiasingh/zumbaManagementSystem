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

    <form action="batch-controller" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="title" value="${batch.getTitle()}">
        </div>
        <div class="form-group">
            <label for="time">Batch Time</label>
            <input type="datetime-local" class="form-control" id="time" name="startTime" value="${batch.getStartTime()}">

        </div>

        <input type="hidden" name="crudOperationType" value="addBatch"><br>
        <button type="submit" class="btn btn-primary">Add Batch</button>
    </form>
</div>


</body>
</html>
