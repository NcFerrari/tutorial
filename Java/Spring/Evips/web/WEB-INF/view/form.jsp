<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <style>
        input[type=submit] {
            border: solid 1px #328cca;
            height: 40px;
            font-size: 20px;
            /*border-radius*/
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            color: #fff;
            background-image: -moz-linear-gradient(top, #3798db, #2c7cd2);
            background-image: -o-linear-gradient(top, #3798db, #2c7cd2);
            background-image: -ms-linear-gradient(top, #3798db, #2c7cd2);
            background-image: -webkit-linear-gradient(top, #3798db, #2c7cd2);
            background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #3798db), color-stop(1, #2c7cd2));
            filter:"progid:DXImageTransform.Microsoft.gradient(startColorStr=#3798db, EndColorStr=#2c7cd2)";
            background-image: linear-gradient(top, #3798db, #2c7cd2);
            width: 215px;
            background-color: #2b96f1;
            /*box-shadow*/
            -moz-box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
            -webkit-box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
            cursor: pointer
        }
    </style>
</head>
<body>

    <form action="processForm" method="GET">
        <input type="text" name="userName" placeholder="Zadejte přihlašovací jméno"/>
        <input type="submit"/>
    </form>

</body>
</html>
