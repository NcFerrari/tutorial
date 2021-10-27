<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>WEB</title>
    <style>
        h1{
            text-align: center;
            color: red;
        }
    </style>
</head>

<body>
    <h1>Spring MVC Demo - Home Page</h1>
    <a href="/form">formulář</a>
    <br><br>
    User name: <b>${param.userName}</b>
</body>

</html>