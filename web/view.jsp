<%--
  Created by IntelliJ IDEA.
  User: LAW
  Date: 01.05.2020
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<h2>Все пользователи</h2><br/>

<%@ page import="model.User" %>
<%@ page import="service.UserService" %>


<ul>
    <%
        for (User user : UserService.getInstance().allUser()) {
            out.print("<p>" + user + "</p>");
            out.println("--------------------");
        }
    %>
</ul>


<table>
    <tr>
        <td>
            <form method="get" action="/allUser">
                <input style="width:200px;height:20px" type="submit" value="Страница Просмотр" name="allUser">
            </form>
        </td>
        <td>
            <form method="get" action="/add.jsp">
                <input style="width:200px;height:20px" type="submit" value="Страница Добавить" name="addUser">
            </form>
        </td>

        <td>
            <form method="get" action="/update.jsp">
                <input style="width:200px;height:20px" type="submit" value="Страница Изменить" name="updateUser"><br>
            </form>
        </td>
        <td>
            <form method="get" action="/delete.jsp">
                <input style="width:200px;height:20px" type="submit" value="Страница Удалить" name="delUser"><br>
            </form>
        </td>
    </tr>
</table>

</body>
</html>
