<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common.jsp"/>
<html>
<head>
    <title>Xác nhận thanh toán - Nét Việt</title>
    <link rel="stylesheet" href="../template/style/user/purchase.css">
    <jsp:include page="public/library.jsp"/>
</head>
<body>
<jsp:include page="public/header.jsp"/>
<section class="container my-4_5" id="user-detail">
    <div class="background-container rounded p-4_5 row">
        <div class="col-6">
            <div>
                <h4 class="main-color mb-4">Thông tin thanh toán</h4>
                <div class="row">
                    <p class="col-6">Họ và tên: <span class="fw-semibold">${userInfo.getFullName()}</span></p>
                    <p class="col-6"></p>
                </div>
                <div class="row">
                    <p class="col-6">Địa chỉ nhận hàng: <span
                            class="fw-semibold">${address}</span></p>
                    <p class="col-4"></p>
                    <p class="col-2 text-end"><a class="text-decoration-none main-color fw-semibold"
                                                 href="/user">THAY ĐỔI</a></p>
                </div>
            </div>
            <hr/>
            <div>
                <h5 class="main-color mb-4">Phương thức thanh toán</h5>
                <div class="row">
                    <div class="my-1">
                        <input class="form-check-input" type="radio" name="paymentMethod" id="flexRadioDefault2" checked
                               value="money">
                        <label class="form-check-label" for="flexRadioDefault2">
                            Thanh toán bằng tiền mặt
                        </label>
                    </div>
                    <div class="my-1">
                        <input class="form-check-input" type="radio" name="paymentMethod" id="flexRadioDefault1"
                               value="bank">
                        <label class="form-check-label" for="flexRadioDefault1">
                            Thanh toán bằng ngân hàng
                        </label>
                    </div>
                </div>
            </div>
            <hr/>
            <div>
                <h5 class="main-color mb-4">Chương trình khuyến mãi</h5>
                <p>Hiện tại không có chương trình khuyến mãi</p>
            </div>

        </div>
        <div class="col-1"></div>
        <div class="col-5">
            <div class="row mb-2 ">
                <p><span class="main-color my-4 h4">Giỏ hàng</span> <span id="remain-item">(2 sản phẩm)</span></p>
            </div>
            <div id="cart-display">
                <c:forEach items="product" var="${listPurchased}">
                    <div class="product-item row my-2">
                        <div class="col-4">
                            <img src="${product.getThumbnail()}" class="card-img-top" alt="...">
                        </div>
                        <div class="col-7">
                            <h5 class="main-color text-truncate"
                                title="${product.category} ${product.title}">
                                    ${product.category} ${product.title}
                            </h5>
                            <p class="mb-1">Số lượng: ${product.amount}</p>
                            <div class="row">
                                <div class="col-6">
                                </div>
                                <div class="col-6">
                                    <h6 class="product-price text-end">${product.getPrice()}</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-1 d-flex align-items-center">
                            <i class="fa-solid fa-trash-can delete-product"></i>
                        </div>
                    </div>
                </c:forEach>
                <%--                <div class="product-item row my-2">--%>
                <%--                    <div class="col-4">--%>
                <%--                        <img src="../template/asset/image/product_image.png" class="card-img-top" alt="...">--%>
                <%--                    </div>--%>
                <%--                    <div class="col-7">--%>
                <%--                        <h5 class="main-color">Tranh thêu tay Đào hạc</h5>--%>
                <%--                        <p class="mb-1">Số lượng: 1</p>--%>
                <%--                        <div class="row">--%>
                <%--                            <div class="col-6">--%>
                <%--                            </div>--%>
                <%--                            <div class="col-6">--%>
                <%--                                <h6 class="product-price text-end">4.850.000 VNĐ</h6>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                    <div class="col-1 d-flex align-items-center">--%>
                <%--                        <i class="fa-solid fa-trash-can delete-product"></i>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
                <%--                <div class="product-item row my-2">--%>
                <%--                    <div class="col-4">--%>
                <%--                        <img src="../template/asset/image/product_image.png" class="card-img-top" alt="...">--%>
                <%--                    </div>--%>
                <%--                    <div class="col-7">--%>
                <%--                        <h5 class="main-color">Tranh thêu tay Sen cá</h5>--%>
                <%--                        <p class="mb-1">Số lượng: 1</p>--%>
                <%--                        <div class="row">--%>
                <%--                            <div class="col-6">--%>
                <%--                            </div>--%>
                <%--                            <div class="col-6">--%>
                <%--                                <h6 class="product-price text-end">3.450.000 VNĐ</h6>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                    <div class="col-1 d-flex align-items-center">--%>
                <%--                        <i class="fa-solid fa-trash-can delete-product"></i>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </div>
            <hr/>
            <div id="count-price">
                <div class="row">
                    <div class="col-6">
                        <span>Thành tiền: </span>
                    </div>
                    <div class="col-6 text-end">
                        <h5 id="product-sum-price" class="fw-semibold ">8.300.000 VNĐ</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <span>Phí vận chuyển: </span>
                    </div>
                    <div class="col-6 text-end">
                        <h5 class="fw-semibold " id="ship-price">130.000 VNĐ</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <span>Giảm giá: </span>
                    </div>
                    <div class="col-6  text-end">
                        <h5 class="fw-semibold">0 VNĐ</h5>
                    </div>
                </div>
                <div class="row my-2">
                    <div class="col-6">
                        <h5>Tổng giá tiền: </h5>
                    </div>
                    <div class="col-6  text-end">
                        <h3 id="total-price" style="color: var(--main-cta-button)">8.430.000 VNĐ</h3>
                    </div>
                </div>
            </div>
            <div class="row px-5">
                <div class="col-6 d-flex align-items-center">
                    <button id="cancel-button" class="rounded sub-cta-button px-3 py-2"
                            style="background-color: var(--light-component-background-color)"
                            onclick="history.back()">
                        Hủy
                    </button>
                </div>
                <div class="col-6 d-flex justify-content-end">
                    <button id="payment-button" class="rounded border-0 main-cta-button p-3 h5">
                        Thanh toán
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>
<%--Tạm bỏ popup này--%>
<%--<div id="popup" class="d-none position-fixed z-2 bg-black bg-opacity-50">--%>
<%--    <div id="popup-content" class="p-4 pt-3 rounded ">--%>
<%--        <div class="row d-flex justify-content-end mb-3">--%>
<%--            <button id="close-popup" type="button" class="btn-close" aria-label="Close"></button>--%>
<%--        </div>--%>
<%--        <h5 class="text-center main-color">Bạn hãy hoàn thành thanh toán bằng ngân hàng trước khi quay lại trang--%>
<%--            nhé!</h5>--%>
<%--        <div class="text-center display-2 mt-4 ">--%>
<%--            <i class="fa-solid fa-stopwatch main-color"></i>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<script src="../template/script/purchase.js"></script>
<jsp:include page="public/footer.jsp"/>
</body>
</html>
