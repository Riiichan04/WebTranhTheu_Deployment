<%@include file="/layout/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="py-2">
        <div class="container">
            <div class="row">
                <div class="col-1 text-white d-flex text-center">
                    <a href="/"><img src="../../template/asset/favicon/web_logo.png" alt="" id="header-logo"></a>
                </div>
                <div class="col-7 text-white d-flex text-center align-items-center" style="position: relative">
                    <div class="input-group">
                        <input type="search" name="" id="search-product-btn" class="rounded-start form-control"
                               placeholder="Tìm kiếm sản phẩm">
                        <button class="border-0 px-4 rounded-end main-cta-button" type="button" id="search-btn">
                            <span id="input-icon" class="fas" style="color: var(--label-color)">&#xf002 </span>
                        </button>
                    </div>
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
                            <%--                            Xử lý sau --%>
                            <a href="/category/tranh-theu-tay" class="">
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
                            </div>
                            <a href="/user" class="">
                                <p style="font-size: 14px" class="cursor-pointer text-button text-end mt-2">
                                    Xem tất cả >
                                </p>
                            </a>
                        </div>
                    </li>
                    <c:choose>
                        <c:when test="${sessionScope.accountId == null}">
                            <li class="cursor-pointer mx-2 header-feature text-white d-flex flex-column text-center align-items-center">
                                <a id="header-login" href="/login">
                                    <i class="fa-solid fa-right-to-bracket my-1"></i>
                                    <p class="header-feature__label">Đăng nhập</p>
                                </a>
                            </li>
                        </c:when>

                        <c:otherwise>
                            <li class="cursor-pointer mx-2 header-feature text-white d-flex flex-column text-center align-items-center position-relative">
                                <div id="header-cart" onclick="window.location = '/cart'">
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
                                </div>
                            </li>

                            <li class="cursor-pointer mx-2 header-feature text-white d-flex flex-column text-center align-items-center">
                                <a id="header-account" href="/user">
                                    <i class="fa-solid fa-user my-1"></i>
                                    <p class="header-feature__label">Tài khoản</p>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                    <li class="cursor-pointer mx-2 header-feature text-white d-flex flex-column text-center align-items-center">
                        <c:if test="${sessionScope.role == 1}">
                            <a id="header-admin" href="/admin">
                                <i class="fa-solid fa-screwdriver-wrench my-1"></i>
                                <p class="header-feature__label">Admin</p>
                            </a>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
<nav style="background-color: var(--dark-component-background-color-hover)" class="py-2 mb-2">
    <div class="container">
        <div class="row">
            <c:forEach var="category" items="${sessionScope.listCategory}">
                <div onclick="window.location = '/category/${category.getPatternName()}'"
                     class="text-center cursor-pointer" style="width: 15%">
                    <p style="color: var(--label-color)" class="my-1 header-category-element">${category.getTitle()}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</nav>
