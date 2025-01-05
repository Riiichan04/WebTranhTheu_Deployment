<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý người dùng</title>
    <%@include file="../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../template/style/admin/general-content-admin.css">
    <link rel="stylesheet" href="../../template/style/admin/display-form-admin.css">

</head>
<body>
<div class="container-fluid">
    <div class="row mt-3 mb-2">
        <div class="col"><h3 class="style-title">Quản lý người dùng</h3></div>
        <div class="col text-end mt-3 me-4">
            <button class="btn-add" id="addUserBtn"><i class="fa-solid fa-plus me-2"></i>Thêm người dùng</button>
        </div>
    </div>
    <div class="row">
        <table id="myTable" class="display custom-table w-100">
            <thead>
            <tr class="head-table">
                <th>STT</th>
                <th>Tên người dùng</th>
                <th>Tên đăng nhập</th>
                <th>Số điện thoại</th>
                <th>Giới tính</th>
                <th>Ngày đăng ký</th>
                <th>Trạng thái</th>
                <th>Tiện ích</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Nguyễn văn Hùng</td>
                <td>nguyen123</td>
                <td>0123456789</td>
                <td>Nam</td>
                <td>1/5/2024</td>
                <td>
                    <button class="btn-read-edit" id="user-1">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Tắt</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Trần Thị Hoa Hồng</td>
                <td>hoa_hong608</td>
                <td>0123456789</td>
                <td>Nữ</td>
                <td>2/7/2024</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Tắt</button>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>Nguyễn Phương Hòa</td>
                <td>phuong0909</td>
                <td>0123456789</td>
                <td>Nữ</td>
                <td>3/7/2024</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Tắt</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div id="formWrapper" class="hidden mx-auto"></div>

<script src="../../template/script/admin/change-user-form.js"></script>
</body>
</html>
