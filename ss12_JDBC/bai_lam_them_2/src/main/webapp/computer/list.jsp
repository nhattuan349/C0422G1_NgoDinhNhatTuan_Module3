<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 03/08/2022
  Time: 9:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Computer List</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <%--    <script src="bootstrap-5.0.2-dist\js\bootstrap.min.js"></script>--%>
    <%--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>--%>
</head>
<body>

<h1> Trang List computer </h1>
<ul>
    <li><a href="/computer?action=create" >Thêm mới</a></li>
</ul>
<table border="1" cellpadding="5">
    <tr>
        <th>computerName</th>
        <th>ram</th>
        <th>cpu</th>
        <th>dateProduce</th>


    </tr>
    <c:forEach items="${computers}" var="computer">
        <tr>
            <td><a href="/computer?action=view&id=${computer.id()}">${computer.getComputerName()}</a></td>
            <td>${computer.ram()}</td>
            <td>${computer.cpu()}</td>
            <td>${computer.dateProduce()}</td>
        </tr>
    </c:forEach>

</table>
<script src="/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>--%>

</body>

</html>
