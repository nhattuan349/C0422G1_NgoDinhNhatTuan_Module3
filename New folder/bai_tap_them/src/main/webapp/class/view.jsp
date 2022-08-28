<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 03/08/2022
  Time: 3:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xem chi tiet class</title>
</head>
<body>
<h1>Chi tiet san pham</h1>
<p>
    <a href="/clas">Tro lai danh sach class</a>
</p>
<table>
    <tr>
        <td>Class Name:</td>
        <td>${requestScope["classs"].getClassName()}</td>
    </tr>
</table>
</body>
</html>