<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 28/07/2022
  Time: 3:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--thư viện jstl--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang danh sách</h1>
<table border="1">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="status">
    <tr>
        <td>${customer.getName()}</td>
        <td>${customer.getBirthday()}</td>
        <td>${customer.getAddress()}</td>
        <td><img src="${customer.getImg()}" alt=""></td>

    </tr>
    </c:forEach>
</table>
</body>
</html>
