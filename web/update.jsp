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
    <title>Update</title>
</head>
<body>
<% String nameOld = request.getParameter("nameOld");
    String surnameOld = request.getParameter("surnameOld");
    if (nameOld != null & surnameOld != null) {
        out.println(nameOld + " " + surnameOld + " был");
    }
    String nameNew = request.getParameter("nameNew");
    String surnameNew = request.getParameter("surnameNew");
    if (nameNew != null & surnameNew != null) {
        out.println(nameNew + " " + surnameNew + " стал");
    }

%>


<form method="post" action="/update">
    <h2>Кого меняем</h2><br/>
    <label><input type="text" name="nameOld"></label>Старое Имя<br>

    <label><input type="text" name="surnameOld"></label>Старая Фамилия<br>

    <h2>На кого</h2><br/>
    <label><input type="text" name="nameNew"></label>Новое Имя<br>

    <label><input type="text" name="surnameNew"></label>Новая Фамилия<br>

    <input type="submit" value="Изменить"><br>
</form>


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
