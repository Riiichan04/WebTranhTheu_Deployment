<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="icon" href="../asset/favicon/favicon.ico">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- FontAwesome -->
    <script src="https://kit.fontawesome.com/2643e782c1.js" crossorigin="anonymous"></script>
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- css property -->
    <link rel="stylesheet" href="../style/index.css">
    <link rel="stylesheet" href="../style/admin/general-content-admin.css">
    <link rel="stylesheet" href="../style/admin/dashboard.css">
    <!-- datatable -->
    <link href="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.css" rel="stylesheet">
    <script src="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.js"></script>

</head>
<body>
<div class="container-fluid px-4">
    <div class="row mt-3 mb-2">
        <div class="col p-0"><h3 class="style-title">Dashboard</h3></div>
        <hr>
    </div>
    <div class="row">
        <div class="col">
            <div class="card w-100">
                <div class="card widget-card border-light shadow-sm">
                    <div class="card-body p-4">
                        <div class="row">
                            <div class="col-10">
                                <h5 class="card-title widget-card-title mb-3">Tổng doanh thu</h5>
                                <h4 class="card-subtitle text-body-secondary m-0">7.123.567.000đ</h4>
                            </div>
                            <div class="col-2">
                                <div class="d-flex justify-content-end">
                                    <div class="lh-1 text-white rounded-circle p-3 d-flex align-items-center justify-content-center">
                                        <i class="fa-solid fa-money-bill-trend-up"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card widget-card border-light shadow-sm">
                <div class="card-body p-4">
                    <div class="row">
                        <div class="col-10">
                            <h5 class="card-title widget-card-title mb-3">Tổng số lượng sản phẩm</h5>
                            <h4 class="card-subtitle text-body-secondary m-0">4321</h4>
                        </div>
                        <div class="col-2">
                            <div class="d-flex justify-content-end">
                                <div class="lh-1 text-white rounded-circle p-3 d-flex align-items-center justify-content-center">
                                    <i class="fa-brands fa-product-hunt"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card widget-card border-light shadow-sm">
                <div class="card-body p-4">
                    <div class="row">
                        <div class="col-10">
                            <h5 class="card-title widget-card-title mb-3">Tổng số lượng khuyến mãi</h5>
                            <h4 class="card-subtitle text-body-secondary m-0">1000</h4>
                        </div>
                        <div class="col-2">
                            <div class="d-flex justify-content-end">
                                <div class="lh-1 text-white rounded-circle p-3 d-flex align-items-center justify-content-center">
                                    <i class="fa-solid fa-tag"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col">
            <div class="card widget-card border-light shadow-sm">
                <div class="card-body p-4">
                    <div class="row">
                        <div class="col-10">
                            <h5 class="card-title widget-card-title mb-3">Tổng số lượng chính sách</h5>
                            <h4 class="card-subtitle text-body-secondary m-0">7.123</h4>
                        </div>
                        <div class="col-2">
                            <div class="d-flex justify-content-end">
                                <div class="lh-1 text-white rounded-circle p-3 d-flex align-items-center justify-content-center">
                                    <i class="fa-solid fa-building-shield"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card widget-card border-light shadow-sm">
                <div class="card-body p-4">
                    <div class="row">
                        <div class="col-10">
                            <h5 class="card-title widget-card-title mb-3">Tổng danh mục</h5>
                            <h4 class="card-subtitle text-body-secondary m-0">4321</h4>
                        </div>
                        <div class="col-2">
                            <div class="d-flex justify-content-end">
                                <div class="lh-1 text-white rounded-circle p-3 d-flex align-items-center justify-content-center">
                                    <i class="fa-solid fa-list"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card widget-card border-light shadow-sm">
                <div class="card-body p-4">
                    <div class="row">
                        <div class="col-10">
                            <h5 class="card-title widget-card-title mb-3">Tổng số lượng người dùng</h5>
                            <h4 class="card-subtitle text-body-secondary m-0">12456</h4>
                        </div>
                        <div class="col-2">
                            <div class="d-flex justify-content-end">
                                <div class="lh-1 text-white rounded-circle p-3 d-flex align-items-center justify-content-center">
                                    <i class="fa-solid fa-user"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-7">
            <div class="style-title mt-4">Danh sách các đơn hàng gần đây</div>
            <table id="myTable" class="m-0 p-0 display custom-table w-100">
                <thead>
                <tr class="head-table">
                    <th>STT</th>
                    <th>Tên khách hàng</th>
                    <th>Tên đăng nhập</th>
                    <th>Ngày đặt hàng</th>
                    <th>Tổng giá trị</th>
                    <th>Trạng thái</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>Nguyễn Văn Hòa</td>
                    <td>van123</td>
                    <td>12/12/2024</td>
                    <td>13.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Trần Thị Hoa</td>
                    <td>hoa$$$</td>
                    <td>1/12/2024</td>
                    <td>12.002.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Nguyễn Phương Thảo</td>
                    <td>phuong_thao_789</td>
                    <td>12/12/2024</td>
                    <td>5.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>

                <tr>
                    <td>3</td>
                    <td>Nguyễn Phương Thảo</td>
                    <td>phuong_thao_789</td>
                    <td>12/12/2024</td>
                    <td>5.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Nguyễn Phương Thảo</td>
                    <td>phuong_thao_789</td>
                    <td>12/12/2024</td>
                    <td>5.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Nguyễn Phương Thảo</td>
                    <td>phuong_thao_789</td>
                    <td>12/12/2024</td>
                    <td>5.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Nguyễn Phương Thảo</td>
                    <td>phuong_thao_789</td>
                    <td>12/12/2024</td>
                    <td>5.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Nguyễn Phương Thảo</td>
                    <td>phuong_thao_789</td>
                    <td>12/12/2024</td>
                    <td>5.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Nguyễn Phương Thảo</td>
                    <td>phuong_thao_789</td>
                    <td>12/12/2024</td>
                    <td>5.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Nguyễn Phương Thảo</td>
                    <td>phuong_thao_789</td>
                    <td>12/12/2024</td>
                    <td>5.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Nguyễn Phương Thảo</td>
                    <td>phuong_thao_789</td>
                    <td>12/12/2024</td>
                    <td>5.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Nguyễn Phương Thảo</td>
                    <td>phuong_thao_789</td>
                    <td>12/12/2024</td>
                    <td>5.000.000đ</td>
                    <td>Đã hoàn thành</td>
                </tr>

                </tbody>
            </table>
        </div>
        <div class="col-5">
            <div class="card widget-card border-light shadow-sm" style="margin-top: 70px">
                <div class="card-order-body p-4">
                    <div class="row">
                        <div class="col choose-radio-order" id="choose-order-1">
                            <h5 class="card-title widget-card-title mb-3">Tổng số lượng đơn hàng</h5>
                            <h4 class="card-subtitle text-body-order m-0">12456</h4>
                        </div>
                        <div class="col choose-radio-order" id="choose-order-3">
                            <h5 class="card-title widget-card-title mb-3">Tổng số lượng đơn hàng</h5>
                            <h6 class="card-subtitle text-body-order m-0 mb-1">Đang xử lý: 12</h6>
                            <h6 class="card-subtitle text-body-order m-0 mb-1">Đang giao: 134</h6>
                            <h6 class="card-subtitle text-body-order m-0">Đã hủy: 1234</h6>
                        </div>
                        <div class="col choose-radio-order" id="choose-order-4">
                            <h5 class="card-title widget-card-title mb-3">Tổng số lượng đơn hàng</h5>
                            <h6 class="card-subtitle text-body-order m-0 mb-1">Chưa thanh toán: 12</h6>
                            <h6 class="card-subtitle text-body-order m-0">Đã thanh toán: 12</h6>
                        </div>
                        <div class="col ps-0">
                            <div class="d-block">
                                <div class="radio-buttons">
                                    <input type="radio" id="option1" name="order" value="1" checked>
                                    <label for="option1" class="d-block">Tất cả</label>

                                    <input type="radio" id="option3" name="order" value="3">
                                    <label for="option3" class="d-block">Theo tình trạng đơn hàng</label>

                                    <input type="radio" id="option4" name="order" value="4">
                                    <label for="option4" class="d-block">Theo tình trạng thanh toán</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../script/admin/dashboard.js"></script>
</body>
</html>
