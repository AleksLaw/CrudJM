<%--
  Created by IntelliJ IDEA.
  User: LAW
  Date: 07.05.2020
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style type="text/css">
        table {
            border: 1px solid black;
            width: auto;
        }

        tr {
            height: 15px;
        }

        th {
            border: 1px solid black
        }

        td {
            align-content: center;
            border: 1px solid black
        }
        .cellbut {
            width: 100%;
            height: min-content;
        }
    </style>
</head>

<body>

<table>
    <caption>Input Login and Password</caption>

    <form method="post" action="/loginUser">
        <tr>
            <td align="center">Login</td>
            <td align="center"><label><input align="center" type="text" name="login" value=""></label></td>
        </tr>

        <tr>
            <td align="center">Password</td>
            <td align="center"><label><input align="center" type="text" name="password" value=""></label></td>

        </tr>
        <tr>
            <td align="center">
                <input type="hidden" name="id" value="">
                <input class="cellbut" type="submit" value="Login" name="submit"><br>
        </tr>
    </form>

</table>

</body>
</html>
