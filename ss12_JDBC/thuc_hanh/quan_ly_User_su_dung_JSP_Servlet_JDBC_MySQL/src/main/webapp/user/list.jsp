<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 01/08/2022
  Time: 4:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">

</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=users">List All Users</a>
    </h2>
    <h2>
        <a href="/users?action=sort"> Sort By Name</a>
    </h2>
    <h2>
        <a href="/users?action=create"> Add New User</a>
    </h2>
    <form action="/users">
        <input type="text" name="country">
        <input type="submit" name="action" value="findByCountry">
    </form>

    <form action="/users">
        <input type="text" name="name">
        <input type="hidden" name ="action" value="findByName">
        <button>tim kiem</button>
    </form>
<%--    <form action="/users?action=findByName" >--%>
<%--        <input type="text" name="name">--%>
<%--        <input type="submit" value="Tim kiem">--%>
<%--    </form>--%>
</center>
<div align="center">
    <table border="1" cellpadding="5">
<%--        <caption><h2>List of Users</h2></caption>--%>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                <%--<a href="/users?action=delete&id=${user.id}">Delete</a>--%>
                    <button onclick="infoDelete('${user.id}', '${user.name}')" type="button"
                            class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


<!-- Modal Delete-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/users" >
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input  name="action" value="delete">
                    <input id="idDelete" name="idDelete">
                    <span> Bạn có muốn xóa username </span><span id="nameDelete"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
<script>
    function infoDelete(id, name){
        document.getElementById("nameDelete").innerText=name;
        document.getElementById("idDelete").value=id;
    }
</script>
</body>
</html>
