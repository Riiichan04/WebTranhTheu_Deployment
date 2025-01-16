<%@include file="/layout/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="px-3 py-2">
        <div class="container">
            <div class="row">
                <div class="col-1 text-white d-flex text-center">
                    <a href="/"><img src="../../template/asset/favicon/web_logo.png" alt="" id="header-logo"></a>
                </div>

                <div class="col-7 text-white d-flex text-center align-items-center" style="position: relative">
                    <span id="input-icon" class="fas ps-2" style="position: absolute; color: #56595C">&#xf002 </span>
                    <input type="search" name="" id="search-product-btn" class="form-control"
                           placeholder="Tìm kiếm sản phẩm">
                </div>
                <ul class="col-4 m-0 d-flex justify-content-end align-items-center">
                    <li class="cursor-pointer mx-2 header-feature text-white d-flex flex-column text-center align-items-center">
                        <div id="header-category">
                            <i class="fa-solid fa-list my-1"></i>
                            <p class="header-feature__label">Danh mục</p>
                        </div>
                        <div id="category-popup"
                             class="rounded header-popup position-absolute background-container p-3 d-none">
                            <div class="d-flex justify-content-end">
                                <button type="button" class="btn-close header-popup__close-btn"
                                        aria-label="Close"></button>
                            </div>
                            <h6 class="header-popup__title main-color text-start pb-2 mb-1">Danh mục</h6>
                            <div class="header-popup__content py-1">
                                <div class="product-item row my-2 cursor-pointer ">
                                    <p class="main-color text-start">Tranh thêu phong cảnh</p>
                                </div>
                                <div class="product-item row my-2 cursor-pointer ">
                                    <p class="main-color text-start">Tranh thêu chân dung</p>
                                </div>
                                <div class="product-item row my-2 cursor-pointer ">
                                    <p class="main-color text-start">Tranh thêu động vật</p>
                                </div>
                                <div class="product-item row my-2 cursor-pointer ">
                                    <p class="main-color text-start">Tranh thêu tứ quý</p>
                                </div>
                                <div class="product-item row my-2 cursor-pointer ">
                                    <p class="main-color text-start">Tranh thêu hoa</p>
                                </div>
                                <div class="product-item row my-2 cursor-pointer ">
                                    <p class="main-color text-start">Tranh thêu VIP</p>
                                </div>
                            </div>
                            <a href="/category" class="">
                                <p style="font-size: 14px" class="cursor-pointer text-button text-end mt-2">
                                    Xem tất cả >
                                </p>
                            </a>
                        </div>
                    </li>
                    <li class="cursor-pointer mx-2 header-feature text-white d-flex flex-column text-center align-items-center position-relative">
                        <div id="header-favorite">
                            <i class="fa-solid fa-heart my-1"></i>
                            <p class="header-feature__label">Yêu thích</p>
                        </div>
                        <div id="favorite-popup"
                             class="rounded header-popup position-absolute background-container p-3 d-none">
                            <div class="d-flex justify-content-end">
                                <button type="button" class="btn-close header-popup__close-btn"
                                        aria-label="Close"></button>
                            </div>
                            <h5 class="header-popup__title main-color text-start pb-2 mb-4">Danh sách yêu thích</h5>
                            <div class="header-popup__content py-1">
                                <div class="product-item row my-2 cursor-pointer">
                                    <div class="col-4">
                                        <img src="../../template/asset/image/product_image.png" class="card-img-top" alt="...">
                                    </div>
                                    <div class="col-8 row">
                                        <h5 class="main-color text-start">Tranh thêu tay Đào hạc</h5>
                                        <p class="product-price text-start">
                                            4.850.000 VNĐ</p>
                                    </div>
                                </div>
                                <div class="product-item row my-2 cursor-pointer">
                                    <div class="col-4">
                                        <img src="../../template/asset/image/product_image.png" class="card-img-top" alt="...">
                                    </div>
                                    <div class="col-8 row">
                                        <h5 class="main-color text-start">Tranh thêu tay Đào hạc</h5>
                                        <p class="product-price text-start">
                                            4.850.000 VNĐ</p>
                                    </div>
                                </div>
                                <div class="product-item row my-2 cursor-pointer">
                                    <div class="col-4">
                                        <img src="../../template/asset/image/product_image.png" class="card-img-top" alt="...">
                                    </div>
                                    <div class="col-8 row">
                                        <h5 class="main-color text-start">Tranh thêu tay Đào hạc</h5>
                                        <p class="product-price text-start">
                                            4.850.000 VNĐ</p>
                                    </div>
                                </div>
                                <div class="product-item row my-2 cursor-pointer">
                                    <div class="col-4">
                                        <img src="../../template/asset/image/product_image.png" class="card-img-top" alt="...">
                                    </div>
                                    <div class="col-8 row">
                                        <h5 class="main-color text-start">Tranh thêu tay Đào hạc</h5>
                                        <p class="product-price text-start">
                                            4.850.000 VNĐ</p>
                                    </div>
                                </div>
                                <div class="product-item row my-2 cursor-pointer">
                                    <div class="col-4">
                                        <img src="../../template/asset/image/product_image.png" class="card-img-top" alt="...">
                                    </div>
                                    <div class="col-8 row">
                                        <h5 class="main-color text-start">Tranh thêu tay Đào hạc</h5>
                                        <p class="product-price text-start">
                                            4.850.000 VNĐ</p>
                                    </div>
                                </div>
                            </div>
                            <a href="/account-page.html" class="">
                                <p style="font-size: 14px" class="cursor-pointer text-button text-end mt-2">
                                    Xem tất cả >
                                </p>
                            </a>
                        </div>
                    </li>
                    <li class="cursor-pointer mx-2 header-feature text-white d-flex flex-column text-center align-items-center position-relative">
                        <div id="header-cart">
                            <i class="fa-solid fa-cart-shopping my-1"></i>
                            <p class="header-feature__label">Giỏ hàng</p>
                        </div>
                        <div id="cart-badge"
                             class="d-none rounded position-absolute align-items-center justify-content-center">0
                        </div>
                        <div id="cart-popup"
                             class="rounded header-popup position-absolute background-container p-3 d-none">
                            <div class="d-flex justify-content-end">
                                <button type="button" class="btn-close header-popup__close-btn"
                                        aria-label="Close"></button>
                            </div>
                            <h5 class="header-popup__title main-color text-start pb-2 mb-4">Giỏ hàng của bạn</h5>
                            <div class="header-popup__content py-1">
                                <div class="product-item row my-2 cursor-pointer">
                                    <div class="col-4">
                                        <img src="../../template/asset/image/product_image.png" class="card-img-top" alt="...">
                                    </div>
                                    <div class="col-8 row">
                                        <h5 class="main-color text-start">Tranh thêu tay Đào hạc</h5>
                                        <p class="product-price text-start">
                                            4.850.000 VNĐ</p>
                                        <p style="font-size: 14px" class="product-price text-end">Số lượng: 1</p>

                                    </div>
                                </div>
                                <div class="product-item row my-2 cursor-pointer">
                                    <div class="col-4">
                                        <img src="../../template/asset/image/product_image.png" class="card-img-top" alt="...">
                                    </div>
                                    <div class="col-8 row">
                                        <h5 class="main-color text-start">Tranh thêu tay Đào hạc</h5>
                                        <p class="product-price text-start">
                                            4.850.000 VNĐ</p>
                                        <p style="font-size: 14px" class="product-price text-end">Số lượng: 1</p>

                                    </div>
                                </div>
                                <div class="product-item row my-2 cursor-pointer">
                                    <div class="col-4">
                                        <img src="../../template/asset/image/product_image.png" class="card-img-top" alt="...">
                                    </div>
                                    <div class="col-8 row">
                                        <h5 class="main-color text-start">Tranh thêu tay Đào hạc</h5>
                                        <p class="product-price text-start">
                                            4.850.000 VNĐ</p>
                                        <p style="font-size: 14px" class="product-price text-end">Số lượng: 1</p>

                                    </div>
                                </div>
                                <div class="product-item row my-2 cursor-pointer">
                                    <div class="col-4">
                                        <img src="../../template/asset/image/product_image.png" class="card-img-top" alt="...">
                                    </div>
                                    <div class="col-8 row">
                                        <h5 class="main-color text-start">Tranh thêu tay Đào hạc</h5>
                                        <p class="product-price text-start">
                                            4.850.000 VNĐ</p>
                                        <p style="font-size: 14px" class="product-price text-end">Số lượng: 1</p>

                                    </div>
                                </div>
                                <div class="product-item row my-2 cursor-pointer">
                                    <div class="col-4">
                                        <img src="../../template/asset/image/product_image.png" class="card-img-top" alt="...">
                                    </div>
                                    <div class="col-8 row">
                                        <h5 class="main-color text-start">Tranh thêu tay Đào hạc</h5>
                                        <p class="product-price text-start">
                                            4.850.000 VNĐ</p>
                                        <p style="font-size: 14px" class="product-price text-end">Số lượng: 1</p>

                                    </div>
                                </div>
                            </div>
                            <a href="/cart-page.html" class="">
                                <p style="font-size: 14px" class="cursor-pointer text-button text-end mt-2">
                                    Xem tất cả >
                                </p>
                            </a>
                        </div>
                    </li>
                    <li class="cursor-pointer mx-2 header-feature text-white d-flex flex-column text-center align-items-center">
                        <a id="header-account" href="/account-page.html">
                            <i class="fa-solid fa-user my-1"></i>
                            <p class="header-feature__label">Tài khoản</p>
                        </a>

                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
