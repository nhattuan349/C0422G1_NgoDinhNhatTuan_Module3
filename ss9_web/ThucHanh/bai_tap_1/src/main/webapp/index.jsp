<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 27/07/2022
  Time: 10:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/discountServlet" method="post">
    <input name="productDescription">
    <input name="listPrice">
    <input name="discountPercentlistPrice">
    <button type="submit">Xuất hóa đơn</button>
  </form>
  </body>
</html>
