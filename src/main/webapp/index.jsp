<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Zumba Management System</title>
</head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<body>



    <div id="header" class="page-header text-center text-info" >
      <h1> Zumba Management System</h1>
    </div>


        <div class="container text-center" >
            <br><br><br><br>
            <div id="login" class="align-content-center">
              <h3><%= "Welcome back!" %></h3>
              <h5>Log in to continue...</h5>
              <form action="home" method="post">
                <label for="email" > Enter Email</label> <br>
                <input id="email" type="text" name="textEmail" placeholder="eg. john@example.com"><br><br>
                <label for="password"> Enter Password</label><br>
                <input id="password" type="password" name="textPassword" placeholder="min. 6 characters password"><br><br>
                <button class="btn-primary" type="submit" >Login</button>

              </form> <br>
              <p>Don't have an account? <a href="register.jsp"> Sign Up</a> </p>
            </div>

            <div id="footer" class="modal-footer">
                <p>&copy; Copyright 2024 Zumba Management System</p>
            </div>
        </div>


















</body>
</html>