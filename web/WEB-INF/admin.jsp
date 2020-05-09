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
    <caption>Table users</caption>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Password</th>
        <th>Role</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="list" items="${lists}">
        <tr>
            <td align="center" width="20"><c:out value="${list.id}"/></td>
            <form method="post" action="/admin/updateUser">
                <td align="center"><label><input align="center" type="text" name="name"
                                                 value="<c:out value="${list.name}"/>"></label></td>
                <td align="center"><label><input align="center" type="text" name="password"
                                                 value="<c:out value="${list.password}"/>"></label>
                </td>
                <td align="center"><label><input align="center" type="text" name="role"
                                                 value="<c:out value="${list.role}"/>"></label></td>

                <td align="center">
                    <input type="hidden" name="id" value="<c:out value="${list.id}"/>">
                    <input class="cellbut" type="submit" value="Update" name="update"><br>
            </form>
            </td>

            <form method="post" action="/admin/delUser">
                <td align="center">
                    <input type="hidden" name="id" value="<c:out value="${list.id}"/>">
                    <input class="cellbut" type="submit" value="Delete" name="delete"><br>
            </form>
            </td>
        </tr>
    </c:forEach>


    <tr>
        <td></td>
        <form method="post" action="/admin/addUser">
            <td><label><input type="text" name="name"></label><br></td>
            <td><label><input type="text" name="password"></label><br></td>
            <td><label><input type="text" name="role"></label><br></td>

            <td></td>
            <td align="center" ; width="20">
                <input class="cellbut" type="submit" value="Add" name="addUser">
            </td>
        </form>
    </tr>
</table>
<p><a href="/">Login page</a></p>
<p><a href="/user">User page</a></p>

</body>
</html>
