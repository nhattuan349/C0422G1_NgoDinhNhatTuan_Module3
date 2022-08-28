<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 03/08/2022
  Time: 2:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Class</title>
</head>
<body>
<h1>Edit Class</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Tro lai class </a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Class Name: </td>
                <td><input type="text" name="className" id="className" value="${requestScope["classs"].getClassName()}"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Edit Class"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>