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
    <title>Service Manager Application</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-3 header">
            <span>
                <a class="navbar-brand" href="#">
                    <img src="/images/logo_furama.png" alt="" width="122" height="116">
                </a>
            </span>
        </div>
        <div class="col-5 header text-center fs-1">Service</div>
        <div class="col-4 header position-relative"><span class="position-absolute top-50 start-50 translate-middle">Ngô Đình Nhật Tuấn</span>
        </div>
    </div>

    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light   ">
            <div class="col-4"></div>
            <div class="col-5">
                <div class="container-fluid d-flex justify-content-center ">
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle float-end" href="#"  role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="float-end "><a class="text-decoration-none" href="/furama">Home</a></span>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle float-end" href="#"  role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="float-end"><a class="text-decoration-none" href="/employee">Employee</a></span>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle float-end" href="#"  role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="float-end"><a class="text-decoration-none" href="/customer">Customer</a></span>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle float-end" href="#" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="float-end"><a class="text-decoration-none" href="/service">Service</a></span>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle float-end" href="#" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="float-end"><a class="text-decoration-none" href="/contract">Contract</a></span>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </li>
                        </ul>


                    </div>
                </div>
            </div>
            <div class="col-3">
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>

        </nav>
    </div>
    <div class="row">
    <span>
        <!-- Button to Open the Modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalAdd">
                Add
            </button>
    </span>


        <div class="table-responsive">
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>PhoneNumber</th>
                    <th>Type</th>
                </tr>
                <tr>
                    <td>id</td>
                    <td>Name</td>
                    <td>Address</td>
                    <td>PhoneNumber</td>

                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-success" data-bs-toggle="modal"
                                data-bs-target="#modalView">
                            View
                        </button>
                    </td>

                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-danger" data-bs-toggle="modal"
                                data-bs-target="#modalEdit">
                            Edit
                        </button>
                    </td>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-warning" data-bs-toggle="modal"
                                data-bs-target="#modalDelete">
                            Delete
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>id</td>
                    <td>Name</td>
                    <td>Address</td>
                    <td>PhoneNumber</td>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-success" data-bs-toggle="modal"
                                data-bs-target="#modalView">
                            View
                        </button>
                    </td>

                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-danger" data-bs-toggle="modal"
                                data-bs-target="#modalEdit">
                            Edit
                        </button>
                    </td>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-warning" data-bs-toggle="modal"
                                data-bs-target="#modalDelete">
                            Delete
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>id</td>
                    <td>Name</td>
                    <td>Address</td>
                    <td>PhoneNumber</td>

                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-success" data-bs-toggle="modal"
                                data-bs-target="#modalView">
                            View
                        </button>
                    </td>

                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-danger" data-bs-toggle="modal"
                                data-bs-target="#modalEdit">
                            Edit
                        </button>
                    </td>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-warning" data-bs-toggle="modal"
                                data-bs-target="#modalDelete">
                            Delete
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>id</td>
                    <td>Name</td>
                    <td>Address</td>
                    <td>PhoneNumber</td>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-success" data-bs-toggle="modal"
                                data-bs-target="#modalView">
                            View
                        </button>
                    </td>

                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-danger" data-bs-toggle="modal"
                                data-bs-target="#modalEdit">
                            Edit
                        </button>
                    </td>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-warning" data-bs-toggle="modal"
                                data-bs-target="#modalDelete">
                            Delete
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>id</td>
                    <td>Name</td>
                    <td>Address</td>
                    <td>PhoneNumber</td>

                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-success" data-bs-toggle="modal"
                                data-bs-target="#modalView">
                            View
                        </button>
                    </td>

                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-danger" data-bs-toggle="modal"
                                data-bs-target="#modalEdit">
                            Edit
                        </button>
                    </td>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bg-warning" data-bs-toggle="modal"
                                data-bs-target="#modalDelete">
                            Delete
                        </button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<%--    <h1>Service Manager</h1>--%>
<%--    <h2>--%>
<%--        <a href="furama?action=users">List All Service</a>--%>
<%--    </h2>--%>
<%--    <h2>--%>
<%--        <a href="/furama?action=sort"> Sort By Name</a>--%>
<%--    </h2>--%>
<%--    <h2>--%>
<%--        <a href="/furama?action=create"> Add New Service</a>--%>
<%--    </h2>--%>
<%--    <form action="/furama">--%>
<%--        <input type="text" name="country">--%>
<%--        <input type="submit" name="action" value="findByCountry">--%>
<%--    </form>--%>

<%--    <form action="/furama">--%>
<%--        <input type="text" name="name">--%>
<%--        <input type="submit" name="action" value="findByName">--%>
<%--    </form>--%>

<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption>--%>
<%--            <h2>Danh sách Service</h2>--%>
<%--        </caption>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>NAME</th>--%>
<%--            <th>EMAIL</th>--%>
<%--            <th>COUNTRY</th>--%>
<%--            <th>ACTIONS</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${listService}" var="service">--%>
<%--            <tr>--%>
<%--                <td>${service.id}</td>--%>
<%--                <td>${service.name}</td>--%>
<%--                <td>${service.email}</td>--%>
<%--                <td>${service.country}</td>--%>
<%--                <td>--%>
<%--                    <a href="/furama?action=edit&id=${service.id}"> Edit</a>--%>
<%--                    <a href="/furama?action=delete&id=${service.id}">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>

<div class="modal" id="modalView">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Heading</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                do you want View this list?
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<!-- The modalEdit -->
<div class="modal" id="modalEdit">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Heading</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                do you want Edit this line?
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<!-- The modalDelete -->
<div class="modal" id="modalDelete">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Heading</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                Are you sure delete?
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<!-- The modalAdd -->
<div class="modal" id="modalAdd">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Heading</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                do you want add?
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<script src="/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
