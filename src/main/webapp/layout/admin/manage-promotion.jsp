<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý giảm giá</title>
    <%@include file="../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../template/style/admin/general-content-admin.css">
    <link rel="stylesheet" href="../../template/style/admin/display-form-admin.css">

</head>
<body>
<div class="container-fluid">
    <div class="row mt-3 mb-2">
        <div class="col"><h3 class="style-title">Quản lý giảm giá</h3></div>
        <div class="col text-end mt-3 me-4">
            <button class="btn-add" id="addPromotionBtn"><i class="fa-solid fa-plus me-2"></i>Thêm giảm giá</button>
        </div>
    </div>
    <div class="row">
        <table id="myTable" class="display custom-table w-100">
            <thead>
            <tr class="head-table">
                <th>STT</th>
                <th>Tiêu đề giảm giá</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th>Trạng thái</th>
                <th>Tiện ích</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Giảm lễ 30/4</td>
                <td>30/4/2024</td>
                <td>2/5/2024</td>
                <td>Đã kết thúc</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Xóa</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Giảm lễ 30/4</td>
                <td>30/4/2024</td>
                <td>2/5/2024</td>
                <td>Đã kết thúc</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Xóa</button>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>Giảm lễ 30/4</td>
                <td>1/11/2024</td>
                <td>5/11/2024</td>
                <td>Đang áp dụng</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Xóa</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div id="formWrapper" class="hidden mx-auto"></div>

<script src="../../template/script/admin/manage-adminpage.js"></script>
<script src="../../template/script/admin/change-promotion-form.js"></script>
</body>
</html>
