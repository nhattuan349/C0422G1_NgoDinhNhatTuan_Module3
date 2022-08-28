<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 04/08/2022
  Time: 9:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Computer</title>
</head>
<body>
<h1> Edit Computer</h1>
<p>
    <c:if test='${message != null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/computer">Tro lai danh sach san pham </a>
</p>
<form method="post">
    <fieldset>
        <legend> Computer information</legend>
        <table>
            <tr>
                <td> Computer Name</td>
                <td><input type="text" name="computerName" id="computerName" value="${computer.computerName}"></td>
            </tr>

            <tr>
                <td> Ram</td>
                <td><input type="text" name="ram" id="ram" value="${computer.ram}"></td>
            </tr>

            <tr>
                <td> Cpu</td>
                <td><input type="text" name="cpu" id="cpu" value="${computer.cpu}"></td>
            </tr>

            <tr>
                <td> Date Produce</td>
                <td><input type="date" name="dateProduce" id="dateProduce" value="${computer.dateProduce}"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Edit Computer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
