<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 30/07/2022
  Time: 9:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete product</title>
</head>
<body>
<h1> Xoa san pham</h1>
<p>
    <a href="/product"> Tro ve danh sach san pham</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getName()}</td>
<%--                <td>${product.name}</td>--%>
            </tr>
            <tr>
                <td>Amount: </td>
                <td>${requestScope["product"].getAmount()}</td>
<%--                <td>${product.amount}</td>--%>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["product"].getPrice()}</td>
<%--                <td>${product.price}</td>--%>
            </tr>
            <tr>
                <td>Production: </td>
                <td>${requestScope["product"].getProduction()}</td>
<%--                <td>${product.production}</td>--%>
            </tr>

            <tr>
                <td><input type="submit" value="Delete Product"></td>
                <td><a href="/product">Back to Product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>

</body>
</html>
