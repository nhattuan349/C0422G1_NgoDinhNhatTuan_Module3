<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/08/2022
  Time: 9:05 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="customer?action=users">List All customer</a>
    </h2>
</center>
<div align="center">
    <form  method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>Customer Mã loại khách :</th>
                <td>
                    <input type="text" name="maLoaiKhach" id="ma_loai_khach" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Họ và Tên:</th>
                <td>
                    <input type="text" name="hoTen" id="ho_ten" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Ngày Sinh:</th>
                <td>
                    <input type="text" name="ngaySinh" id="ngay_sinh" size="15"/>
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
