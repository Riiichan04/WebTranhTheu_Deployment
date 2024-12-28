<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý đơn hàng</title>
    <%@include file="../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../template/style/admin/general-content-admin.css">
    <link rel="stylesheet" href="../../template/style/admin/display-form-admin.css">
    <!-- datatable -->
    <link href="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.css" rel="stylesheet">
    <script src="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="row mt-3 mb-2">
        <div class="col"><h3 class="style-title">Quản lý đơn hàng</h3></div>
        <div class="col text-end mt-3 me-4">
            <button class="btn-add" id="addOrderBtn"><i class="fa-solid fa-plus me-2"></i>Thêm đơn hàng</button>
        </div>
    </div>
    <div class="row">
        <table id="myTable" class="display custom-table w-100">
            <thead>
            <tr class="head-table">
                <th>STT</th>
                <th>Tên khách hàng</th>
                <th>Tên đăng nhập</th>
                <th>Tổng đơn hàng (VNĐ)</th>
                <th>Ngày đặt hàng</th>
                <th>Trạng thái</th>
                <th>Thanh toán</th>
                <th>Tiện ích</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Nguyễn Văn Hòa</td>
                <td>van123</td>
                <td>10.000.000 VNĐ</td>
                <td>12/12/2024</td>
                <td>Đã hoàn thành</td>
                <td>Đã thanh toán</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Xóa</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Trần Thị Hoa</td>
                <td>hoa$$$</td>
                <td>10.000.000 VNĐ</td>
                <td>1/12/2024</td>
                <td>Đã hoàn thành</td>
                <td>Đã thanh toán</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Xóa</button>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>Nguyễn Phương Thảo</td>
                <td>phuong_thao_789</td>
                <td>10.000.000 VNĐ</td>
                <td>12/12/2024</td>
                <td>Đã hoàn thành</td>
                <td>Đã thanh toán</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Xóa</button>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
</div>

<div id="formWrapper" class="">
    <div>
        <form style="z-index: 2">
            Theem kskc
            bsjhh
            <button type="button">jasjk</button>
        </form>
    </div>
</div>

<script>
    $("#formWrapper").click(function () {
        $("#formWrapper").addClass("hidden")
    })
</script>
<script src="../../template/script/admin/manage-adminpage.js"></script>
<%--<script src="../../template/script/admin/change-order-form.js"></script>--%>
</body>
</html>
