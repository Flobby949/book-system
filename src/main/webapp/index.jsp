<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="register" method="post">
    <p>
        username: <input type="text" name="username">
    </p>
    <p>
        password: <input type="password" name="password">
    </p>
    <p>
        男: <input type="radio" name="gender" value="0">
         女: <input type="radio" name="gender" value="1">
    </p>
    <input type="submit" value="submit">
</form>
</body>
</html>