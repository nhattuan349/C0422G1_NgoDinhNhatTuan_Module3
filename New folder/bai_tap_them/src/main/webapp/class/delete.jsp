<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 03/08/2022
  Time: 3:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete class</title>
</head>
<body>
<h1> Xoa class</h1>
<p>
    <a href="/class"> Tro ve danh sach class</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Class information</legend>
        <table>
            <tr>
                <td>Class Name: </td>
                <td>${requestScope["classs"].getClassName()}</td>
            </tr>

            <tr>
                <td><input type="submit" value="Delete Class"></td>
                <td><a href="/class">Back to Class list</a></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>

</body>
</html>
