<%--
  Created by IntelliJ IDEA.
  User: gvara
  Date: 12/4/2024
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="text-center my-4">Login</h2>
    <form method="post" action="./LoginServlet">
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="pass">Password</label>
            <input type="password" class="form-control" id="pass" name="pass" required>
        </div>
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-primary">Login</button>
            <button type="reset" class="btn btn-secondary">Clear</button>
        </div>
    </form>
    <p class="text-center mt-3">New User, <a href="Register.html">SignUp</a></p>
    <%
        Object o = request.getAttribute("loginError");
    %>
    <p class="text-center text-warning" style="background-color:yellow;color:red;font-style:italic;">
        <%= (o == null) ? "" : o.toString() %>
    </p>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>