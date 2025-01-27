<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common.jsp"/>
<html>
<head>
    <title>Đơn hàng</title>
    <%@include file="../public/library.jsp" %>
    <!-- css property -->
    <link rel="stylesheet" href="../../template/style/user/account-page.css">
    <link rel="stylesheet" href="../../template/style/user/style-forms/orders.css">
</head>
<body>
<div id="user-ordered-list" class=" content-details col">
    <div class="h3 p-4">Đơn hàng của tôi</div>
    <hr>
    <div class="container px-3">
        <div class="row order-categories">
            <div class="col order-item p-2 on" data-target="waitlist">Chờ xác nhận</div>
            <div class="col order-item p-2" data-target="pickedlist">Chờ lấy hàng</div>
            <div class="col order-item p-2" data-target="shippinglist">Chờ giao hàng</div>
            <div class="col order-item p-2" data-target="turnedback">Trả hàng</div>
            <div class="col order-item p-2" data-target="shippedlist">Đã giao</div>
            <div class="col order-item p-2" data-target="canceledlist">Đã hủy</div>
        </div>
        <!-- Waitlist Orders-->
        <div id="waitlist" class="order-details">
            <!-- Card-->
            <div class="card container">
                <!--NSX-->
                <div class="row shop-info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-3">Chờ xác nhận</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="cancel-btn">Hủy hàng</button>
                    </div>
                    <div class="col-3">
                        <button type="button" class="contact-btn">Liên hệ</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-3">Chờ xác nhận</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="cancel-btn">Hủy hàng</button>
                    </div>
                    <div class="col-3">
                        <button type="button" class="contact-btn">Liên hệ</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-3">Chờ xác nhận</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="cancel-btn">Hủy hàng</button>
                    </div>
                    <div class="col-3">
                        <button type="button" class="contact-btn">Liên hệ</button>
                    </div>
                </div>
            </div>
        </div>
        <!--Pickup Orders (PAID)-->
        <div id="pickedlist" class="order-details" style="display: none">
            <!-- Card-->
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-3">Chờ lấy hàng</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="cancel-btn">Hủy hàng</button>
                    </div>
                    <div class="col-3">
                        <button type="button" class="contact-btn">Liên hệ</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-3">Chờ lấy hàng</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="cancel-btn">Hủy hàng</button>
                    </div>
                    <div class="col-3">
                        <button type="button" class="contact-btn">Liên hệ</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-3">Chờ lấy hàng</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="cancel-btn">Hủy hàng</button>
                    </div>
                    <div class="col-3">
                        <button type="button" class="contact-btn">Liên hệ</button>
                    </div>
                </div>
            </div>
        </div>
        <!--Shipping Order-->
        <div id="shippinglist" class="order-details" style="display: none">
            <!-- Card-->
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-2">Đang giao</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="received" disabled>Đã nhận hàng</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-2">Đang giao</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="received" disabled>Đã nhận hàng</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-2">Đang giao</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="received" disabled>Đã nhận hàng</button>
                    </div>
                </div>
            </div>
        </div>
        <!--Shipped Orders-->
        <div id="shippedlist" class=" order-details" style="display: none">
            <!-- Card-->
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-4 shipped">Giao hàng thành công</div>
                    <div class="col-2">Đã giao</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="received">Đã nhận hàng</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-4 shipped">Giao hàng thành công</div>
                    <div class="col-2">Đã giao</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="received">Đã nhận hàng</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-4 shipped">Giao hàng thành công</div>
                    <div class="col-2">Đã giao</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="received">Đã nhận hàng</button>
                    </div>
                </div>
            </div>
        </div>
        <!--Turned back Orders-->
        <div id="turnedback" class=" order-details" style="display: none">
            <!-- Card-->
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-4">Yêu cầu hoàn trả/Hủy</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="turnback_details">Chi tiết</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-4">Yêu cầu hoàn trả/Hủy</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="turnback_details">Chi tiết</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-4">Yêu cầu hoàn trả/Hủy</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="turnback_details">Chi tiết</button>
                    </div>
                </div>
            </div>
        </div>
        <!--Canceled Orders-->
        <div id="canceledlist" class="order-details" style="display: none">
            <!-- Card-->
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-2">Đã hủy</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="rebuy_btn">Mua lại</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-2">Đã hủy</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="rebuy_btn">Mua lại</button>
                    </div>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card container">
                <!--NSX-->
                <div class="row shop_info">
                    <div class="col-1"><i class="bi bi-shop-window"></i></div>
                    <div class="col">provider</div>
                    <div class="col-2">Đã hủy</div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <div class="container">
                        <!-- Sản phẩm 1-->
                        <div class="row py-3">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                        <!--Sản phẩm 2-->
                        <div class="row py-3 ">
                            <div class="col-3"><img src="../asset/image/product_image.png"
                                                    class="resized-image">
                            </div>
                            <div class="col container">
                                <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
                                <div class="row">x1</div>
                            </div>
                            <div class="col-3 p-4">15.000.000 đ</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div class="col-3">
                        30.000.000 đ
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="rebuy_btn">Mua lại</button>
                    </div>
                </div>
            </div>
        </div>
        <!--End-->
    </div>
</div>
<script src="template/script/header.js"></script>
<script src="template/script/account.js"></script>
</body>
</html>
