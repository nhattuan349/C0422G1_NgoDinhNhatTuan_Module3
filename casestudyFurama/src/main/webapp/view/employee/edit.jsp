<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: PC--%>
<%--  Date: 05/08/2022--%>
<%--  Time: 9:06 SA--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
    <link rel="stylesheet" href="../../bootstrap520/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap5.min.css">
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
        <div class="col-5 header text-center fs-1">Customer</div>
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
                                <a class="nav-link dropdown-toggle float-end" href="#" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="float-end "><a class="text-decoration-none"
                                                                href="/furama">Home</a></span>
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
                                    <span class="float-end"><a class="text-decoration-none"
                                                               href="/employee">Employee</a></span>
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
                                    <span class="float-end"><a class="text-decoration-none"
                                                               href="/customer">Customer</a></span>
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
                                    <span class="float-end"><a class="text-decoration-none"
                                                               href="/contract">Contract</a></span>
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
        <center>
            <h1>Customer Management</h1>
            <h2>
                <a href="employee?action=employee">List All Customer</a>
            </h2>
        </center>
        <div align="center">
            <form method="post">
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            Edit Employee
                        </h2>
                    </caption>
                    <c:if test="${employee != null}">
                        <input type="hidden" name="ma_nhan_vien" value="<c:out value='${employee.maNhanVien}' />"/>
                    </c:if>
                    <tr>
                        <th>Employee hoTen:</th>
                        <td>
                            <input type="text" name="ho_ten" size="45"
                                   value="<c:out value='${employee.hoTen}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Employee ngaySinh:</th>
                        <td>
                            <input type="text" name="ngay_sinh" size="45"
                                   value="<c:out value='${employee.ngaySinh}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Employee soCMND:</th>
                        <td>
                            <input type="text" name="so_cmnd" size="45"
                                   value="<c:out value='${employee.soCMND}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Employee luong:</th>
                        <td>
                            <input type="text" name="luong" size="45"
                                   value="<c:out value='${employee.luong}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Employee soDienThoai:</th>
                        <td>
                            <input type="text" name="so_dien_thoai" size="45"
                                   value="<c:out value='${employee.soDienThoai}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Employee email:</th>
                        <td>
                            <input type="text" name="email" size="45"
                                   value="<c:out value='${employee.email}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Employee diaChi:</th>
                        <td>
                            <input type="text" name="dia_chi" size="45"
                                   value="<c:out value='${employee.diaChi}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Employee maViTri:</th>
                        <td>
                            <input type="text" name="ma_vi_tri" size="45"
                                   value="<c:out value='${employee.maViTri}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Employee maTrinhDo:</th>
                        <td>
                            <input type="text" name="ma_trinh_do" size="45"
                                   value="<c:out value='${employee.maTrinhDo}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Employee maBoPhan:</th>
                        <td>
                            <input type="text" name="ma_bo_phan" size="45"
                                   value="<c:out value='${employee.maBoPhan}' />"
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
    </div>
</div>

<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../bootstrap520/js/bootstrap.min.js"></script>
</body>
</html>
