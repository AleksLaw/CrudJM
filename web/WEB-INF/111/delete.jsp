<%--
  Created by IntelliJ IDEA.
  User: LAW
  Date: 01.05.2020
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h2>Удаление пользователя</h2><br/>
<% String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    if (name != null & surname != null) {
        out.print(name + " " + surname + " удален");
    }

%>
<form method="post" action="/delUser">

    <label><input type="text" name="name"></label>Имя<br>

    <label><input type="text" name="surname"></label>Фамилия<br>

    <input type="submit" value="Удалить" name="del"><br>
</form>


<table>
    <tr>
        <td>
            <form method="get" action="/allUser">
                <input style="width:200px;height:20px" type="submit" value="Страница Просмотр" name="allUser">
            </form>
        </td>
        <td>
            <form method="get" action="/WEB-INF/111/add.jsp/111/add.jsp">
                <input style="width:200px;height:20px" type="submit" value="Страница Добавить" name="addUser">
            </form>
        </td>

        <td>
            <form method="get" action="/WEB-INF/111/update.jsp1/update.jsp">
                <input style="width:200px;height:20px" type="submit" value="Страница Изменить" name="updateUser"><br>
            </form>
        </td>
        <td>
            <form method="get" action="/WEB-INF/111/delete.jsp">
                <input style="width:200px;height:20px" type="submit" value="Страница Удалить" name="delUser"><br>
            </form>
        </td>
    </tr>
</table>


</body>
</html>
