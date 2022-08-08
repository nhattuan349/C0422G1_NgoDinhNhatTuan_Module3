<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/08/2022
  Time: 4:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
</head>
<body>

<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>Trung</td>
        <td>
            <button type="button" class="btn btn-danger"
                    data-bs-toggle="modal" data-bs-target="#exampleModal"
                    onclick=setIdToFormDelete(1)>
                Xóa
            </button>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>Toán</td>
        <td>
            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Xóa
            </button>
        </td>
    </tr>
    </tbody>
</table>

<form action="customer">
    <input type="text" id="tuan" name="idCustomer">
    <input type="text" name="delete" value="delete">
</form>
<!-- Button trigger modal -->
<script>
    function setIdToFormDelete(idStudent) {
        document.getElementById("tuan").value = idStudent;
    }

    function submitFormDelete() {
        console.log("đã submit");
    }

</script>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitFormDelete()">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</html>
