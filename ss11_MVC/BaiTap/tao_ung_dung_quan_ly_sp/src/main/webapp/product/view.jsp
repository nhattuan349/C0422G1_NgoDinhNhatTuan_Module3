<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 30/07/2022
  Time: 9:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 28/06/2022
  Time: 8:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xem chi tiet san pham </title>
</head>
<body>
<h1>Chi tiet san pham</h1>
<p>
    <a href="/product">Tro lai danh sach san pham</a>
</p>
<table>
    <tr>
        <td>Name:</td>
<%--        <td>${requestScope["product"].getName()}</td>--%>
        <td>${requestScope["product"].name()}</td>
    </tr>
    <tr>
        <td>Price:</td>
<%--        <td>${requestScope["product"].getPrice()}</td>--%>
        <td>${requestScope["product"].price()}</td>
    </tr>
    <tr>
        <td>Amount:</td>
<%--        <td>${requestScope["product"].getAmount()}</td>--%>
        <td>${requestScope["product"].amount()}</td>
    </tr>
    <tr>
        <td>Production:</td>
<%--        <td>${requestScope["product"].getProduction()}</td>--%>
        <td>${requestScope["product"].production()}</td>
    </tr>
</table>
</body>
</html>