<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/08/2022
  Time: 9:06 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contract Management Application</title>
</head>
<body>
<center>
    <h1>Contract Management</h1>
    <h2>
        <a href="furama?action=users">List All Contract</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Contract
                </h2>
            </caption>
            <c:if test="${contract != null}">
                <input type="hidden" name="id" value="<c:out value='${contract.id}' />"/>
            </c:if>
            <tr>
                <th>Contract Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${contract.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Contract Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${contract.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${contract.country}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
