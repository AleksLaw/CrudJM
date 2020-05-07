<%--
  Created by IntelliJ IDEA.
  User: LAW
  Date: 06.05.2020
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Test</title>
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
    <caption>Таблица пользователей</caption>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>SurName</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="list" items="${lists}">
    <form method="post" action="/delUser">
        <form method="post" action="/updateUser">
        <tr>
            <td align="center" ; width="20"><c:out value="${list.id}"/></td>
            <td align="center" ; width="20"><c:out value="${list.name}"/></td>
            <td align="center" ; width="20"><c:out value="${list.surname}"/></td>
            <td align="center" ; width="20">
<%--                    <input class="cellbut" type="submit" value="Update" name=<c:out value="${list.id}" /> >--%>
    <input type="hidden" name="mame" value="<c:out value="${list.id}"/>">
                    <input class="cellbut" type="submit" value="Update" name="name">
            </td>
            <td align="center" ; width="20">
                <input type="hidden" name="name" value="<c:out value="${list.id}"/>">
                    <input class="cellbut" type="submit" value="Delete" name="name"><br>
<%--                    <input class="cellbut" type="submit" value="Delete" name="${list.id} "><br>--%>
            </td>
        </tr>
        </form>
        </form>


    </c:forEach>
    <tr>
        <td></td>
        <form method="post" action="/addUser">
            <td><label><input type="text" name="name"></label><br></td>
            <td><label><input type="text" name="surname"></label><br></td>
            <td></td>
            <td align="center" ; width="20">
                <input class="cellbut" type="submit" value="Add" name="addUser">
            </td>
        </form>
    </tr>
</table>


<table>
    <tr>
        <td>
            <form method="get" action="/allUser">
                <input style="width:200px;height:20px" type="submit" value="Страница Просмотр" name="allUser">
            </form>
        </td>
    </tr>
</table>


</body>
</html>
