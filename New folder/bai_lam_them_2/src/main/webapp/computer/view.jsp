<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 03/08/2022
  Time: 9:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xem chi tiet máy tính </title>
</head>
<body>
<h1>Chi tiet may tinh</h1>
<p>
    <a href="/computer">Tro lai danh sach may tinh</a>
</p>
<table>
    <tr>
        <td>Computer Name:</td>
        <td>${requestScope["computer"].getComputerName()}</td>
    </tr>
    <tr>
        <td>Ram:</td>
        <td>${requestScope["computer"].getRam()}</td>
    </tr>
    <tr>
        <td>Cpu:</td>
        <td>${requestScope["computer"].getCpu()}</td>
    </tr>
    <tr>
        <td>Date Produce:</td>
        <td>${requestScope["computer"].getDateProduce()}</td>
    </tr>
</table>
</body>
</html>

</body>
</html>
