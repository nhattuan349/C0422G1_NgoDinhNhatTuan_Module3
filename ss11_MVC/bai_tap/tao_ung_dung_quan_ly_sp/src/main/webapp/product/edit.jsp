<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 30/07/2022
  Time: 9:08 CH
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>

<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
<%--                <td><input type="text" name="name" id="name" value="${product.name}"></td>--%>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
<%--                <td><input type="text" name="price" id="price" value="${product.price}"></td>--%>
            </tr>
            <tr>
                <td>Amount: </td>
                <td><input type="text" name="amount" id="amount" value="${requestScope["product"].getAmount()}"></td>
<%--                <td><input type="text" name="amount" id="amount" value="${product.amount}"></td>--%>
            </tr>

            <tr>
                <td>Production: </td>
                <td><input type="text" name="production" id="production" value="${requestScope["product"].getProduction()}"></td>
<%--                <td><input type="text" name="production" id="production" value="${product.production}"></td>--%>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Edit Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>