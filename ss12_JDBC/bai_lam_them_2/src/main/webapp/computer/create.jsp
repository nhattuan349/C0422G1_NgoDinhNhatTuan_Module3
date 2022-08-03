<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 03/08/2022
  Time: 4:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Thêm mới máy tính</h1>
<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/class">Tro lai danh sach may tinh</a>
</p>

<form method="post">
<fieldset>
<legend> Computer information</legend>
    <table>
        <tr>
            <td>Computer Name</td>
            <td><input type="text" name="computerName" id="name"></td>
        </tr>

        <tr>
            <td>Ram</td>
            <td><input type="text" name="ram" id="ram"></td>
        </tr>

        <tr>
            <td>Cpu</td>
            <td><input type="text" name="cpu" id="cpu"></td>
        </tr>

        <tr>
            <td>Date produce</td>
            <td><input type="text" name="dateProduce" id="dateProduce"></td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Create Computer"> </td>
        </tr>
    </table>
</fieldset>
</form>
</body>
</html>
