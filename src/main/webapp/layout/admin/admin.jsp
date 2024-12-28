<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang admin - Nét Việt</title>
    <%@include file="../public/library.jsp"%>
    <!-- Bootstrap JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <!-- css property -->
    <link rel="stylesheet" href="../../template/style/admin/nav-admin.css">
    <link rel="stylesheet" href="../../template/style/admin/popup-logout.css">

</head>
<body>
<div class="container-fluid">
    <div class="row vh-100">
        <div class="col-2 nav-style pt-4 px-0">
            <div class="info-admin">
                <div class="avt-admin mx-auto"><img src="../../template/asset/image/avt-admin.png" class="img text-center"></div>
                <div class="mt-3 px-4 text-center">Chào mừng admin <span class="fw-bold">"Tên admin"</span>!
                </div>
                <div class="hr-under-info my-3"></div>
            </div>
            <nav>
                <ul class="list-manage ps-0">
                    <li><a href="dashboard.jsp" class="select-nav px-4 ajax-link active" id="dashboard">
                        <i class="fa-solid fa-house me-2"></i>
                        Dashboard
                    </a></li>
                    <li><a href="manage-product.jsp" class="select-nav px-4 ajax-link" id="product">
                        <i class="fa-brands fa-product-hunt me-2"></i>
                        Quản lý sản phẩm
                    </a></li>
                    <li><a href="manage-user.jsp" class="select-nav px-4 ajax-link" id="user">
                        <i class="fa-solid fa-people-roof me-2"></i>
                        Quản lý người dùng
                    </a></li>
                    <li><a href="manage-promotion.jsp" class="select-nav px-4 ajax-link" id="promotion">
                        <i class="fa-solid fa-tags me-2"></i>
                        Quản lý giảm giá
                    </a></li>
                    <li><a href="manage-category.jsp" class="select-nav px-4 ajax-link" id="category">
                        <i class="fa-solid fa-list me-2"></i>
                        Quản lý danh mục
                    </a></li>
                    <li><a href="manage-topic.jsp" class="select-nav px-4 ajax-link" id="topic">
                        <i class="fa-solid fa-lightbulb me-2"></i>
                        Quản lý chủ đề
                    </a></li>
                    <li><a href="manage-order.jsp" class="select-nav px-4 ajax-link" id="order">
                        <i class="fa-solid fa-money-bill-trend-up me-2"></i>
                        Quản lý đơn hàng
                    </a></li>
                    <li><a href="manage-policy.jsp" class="select-nav px-4 ajax-link" id="policy">
                        <i class="fa-solid fa-building-shield me-2"></i>
                        Quản lý chính sách
                    </a></li>
                </ul>
                <div class="hr-under-info my-3"></div>
                <div><a href="setting-user.jsp" class="select-nav px-4 ajax-link" id="setting">
                    <i class="fa-solid fa-gear me-2"></i>
                    Cài đặt tài khoản
                </a></div>
                <div>
                    <button type="button" class="px-4 w-100 text-start" id="log-out" data-bs-toggle="modal"
                            data-bs-target="#logOutModal">
                        <i class="fa-solid fa-right-from-bracket me-2"></i>
                        Đăng xuất
                    </button>
                </div>
            </nav>
        </div>
        <div class="col-10 p-0" id="content">
            <%@include file="dashboard.jsp"%>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="logOutModal" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"><i
                        class="fa-solid fa-circle-question pe-2"
                        style="color: var(--sub-cta-button)"></i>Đăng xuất</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn chắc chắn muốn đăng xuất ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"
                        id="choose-close">Hủy
                </button>
                <button type="button" class="btn btn-primary" id="choose-log-out"
                        onclick="window.location.replace('sign-in.html');">Đăng xuất
                </button>
            </div>
        </div>
    </div>
</div>

<script src="../../template/script/admin/admin.js"></script>
</body>
</html>
