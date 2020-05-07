<%--
  Created by IntelliJ IDEA.
  User: LAW
  Date: 01.05.2020
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddUser</title>
</head>
<body>
<h2>Создание нового пользователя</h2><br>


<% String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    if (name != null & surname != null) {
        out.print(name + " " + surname + " добавлен");
    }

%>


<form method="post" action="/addUser">

    <label><input type="text" name="name"></label>Имя<br>

    <label><input type="text" name="surname"></label>Фамилия<br>

    <input type="submit" value="Добавить" name="add"><br>
</form>


<table>
    <tr>
        <td>
            <form method="post" action="/allUser">
                <input style="width:200px;height:20px" type="submit" value="Страница Просмотр" name="allUser">
            </form>
        </td>
        <td>
            <form method="post" action="/add.jsp">
                <input style="width:200px;height:20px" type="submit" value="Страница Добавить" name="addUser">
            </form>
        </td>

        <td>
            <form method="post" action="/update.jsp">
                <input style="width:200px;height:20px" type="submit" value="Страница Изменить" name="updateUser"><br>
            </form>
        </td>
        <td>
            <form method="post" action="/delete.jsp">
                <input style="width:200px;height:20px" type="submit" value="Страница Удалить" name="delUser"><br>
            </form>
        </td>
    </tr>
</table>


</body>
</html>
