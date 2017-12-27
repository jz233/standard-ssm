<%--
  Created by IntelliJ IDEA.
  User: DouJ
  Date: 12/21/2017
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h1>User Signin</h1>
    <form action="login_check" method="POST" id="user_login_form" class="form-horizontal">
        <div class="form-group">
            <label for="input_username" class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" placeholder="Username" id="input_username" name="username">
            </div>
        </div>
        <div class="form-group">
            <label for="input_password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input class="form-control" type="password" placeholder="Password" id="input_password" name="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
