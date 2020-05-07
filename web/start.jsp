<%--
  Created by IntelliJ IDEA.
  User: LAW
  Date: 30.04.2020
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StartPage</title>
</head>
<body>
<h2>Выбор</h2>



<table border="1">
    <caption>Таблица размеров обуви</caption>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>SurName</th>
        <th>Action</th>
    </tr>
    <tr><td>34,5</td><td>3,5</td><td>36</td><td>23</td></tr>
    <tr><td>44</td><td>10,5</td><td>45⅓</td><td>28,5–29</td></tr>
     <tr><td>47</td><td>13</td><td>48⅔</td><td>31</td></tr>
    <tr><td>48</td><td>13,5</td><td>49⅓</td><td>31,5</td></tr>
</table>
<c:forEach var="user" items="${users}">
    <li><c:out value="${user}" /></li>
</c:forEach>








<table>
    <tr>
        <td>
            <form method="post" action="/allUser">
                <input style="width:200px;height:20px" type="submit" value="Страница Просмотр" name="allUser">
            </form>
        </td>
        <td>
            <form method="post" action="/view">
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
