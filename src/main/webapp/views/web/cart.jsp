<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../layout/common.jsp"/>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="../../template/style/user/cart.css">
    <jsp:include page="../../layout/public/library.jsp"/>
</head>
<body>
<jsp:include page="../../layout/public/header.jsp"/>
<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb" class="container">
    <ol class="breadcrumb pt-2">
        <li class="breadcrumb-item"><a href="/">Trang chủ</a></li>
        <li class="breadcrumb-item active" aria-current="page">Giỏ hàng</li>
    </ol>
</nav>
<div class="container">
    <div class="row">
        <div class="col-8 cart">
            <div class="h3 pt-4 text-center">Giỏ hàng</div>
            <div class="row cart-title px-4">
                <div class="col-3 form-check">
                    <input class="form-check-input" type="checkbox" id="checkAll">
                    <label class="form-check-label" for="checkAll">
                        Chọn tất cả
                    </label>
                </div>
                <div class="col-3 text-center">Sản phẩm</div>
                <div class="col-3 text-center">Số lượng</div>
                <div class="col-2">Giá tiền</div>
            </div>
            <hr/>
            <div class="cart-item-list">
                <div class=" row py-3 cart-item">
                    <div class="col-1 text-center">
                        <div class="row pb-4"></div>
                        <div class="row ps-4">
                            <div class="form-check">
                                <input class="product-checkbox form-check-input" type="checkbox">
                            </div>
                        </div>
                    </div>
                    <img class="col-2" src="../asset/image/product_image.png">
                    <div class="col-3 ps-5 pe-0">
                        <div class="row">Tranh thêu thám tử lừng danh Conan</div>
                        <div class="row pb-2"></div>
                        <div class="row">NXB Kim Đồng</div>
                    </div>
                    <div class="col-3 text-center">
                        <div class="row pb-4"></div>
                        <div class="row">
                            <div class="row">
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__remove-amount" disabled>
                                        <i class="fa-solid fa-minus"></i>
                                    </button>
                                </div>
                                <div class="col-4 text-center product-detail__amount">
                                    1
                                </div>
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__add-amount">
                                        <i class="fa-solid fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col p-0">
                        <div class="row pb-4 "></div>
                        <div class="row ps-3 product-detail__price">15000000</div>
                    </div>
                    <div class="col-1 p-0">
                        <div class="row pb-4"></div>
                        <i class="bi bi-trash"></i>
                    </div>
                </div>
                <div class=" row py-3 cart-item">
                    <div class="col-1 text-center">
                        <div class="row pb-4"></div>
                        <div class="row ps-4">
                            <div class="form-check">
                                <input class="product-checkbox form-check-input" type="checkbox">
                            </div>
                        </div>
                    </div>
                    <img class="col-2" src="../asset/image/product_image.png">
                    <div class="col-3 ps-5 pe-0">
                        <div class="row">Tranh thêu thám tử lừng danh Conan</div>
                        <div class="row pb-2"></div>
                        <div class="row">NXB Kim Đồng</div>
                    </div>
                    <div class="col-3 text-center">
                        <div class="row pb-4"></div>
                        <div class="row">
                            <div class="row">
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__remove-amount" disabled>
                                        <i class="fa-solid fa-minus"></i>
                                    </button>
                                </div>
                                <div class="col-4 text-center product-detail__amount">
                                    1
                                </div>
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__add-amount">
                                        <i class="fa-solid fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col p-0">
                        <div class="row pb-4 "></div>
                        <div class="row ps-3 product-detail__price">15000000</div>
                    </div>
                    <div class="col-1 p-0">
                        <div class="row pb-4"></div>
                        <i class="bi bi-trash"></i>
                    </div>
                </div>
                <div class=" row py-3 cart-item">
                    <div class="col-1 text-center">
                        <div class="row pb-4"></div>
                        <div class="row ps-4">
                            <div class="form-check">
                                <input class="product-checkbox form-check-input" type="checkbox">
                            </div>
                        </div>
                    </div>
                    <img class="col-2" src="../asset/image/product_image.png">
                    <div class="col-3 ps-5 pe-0">
                        <div class="row">Tranh thêu thám tử lừng danh Conan</div>
                        <div class="row pb-2"></div>
                        <div class="row">NXB Kim Đồng</div>
                    </div>
                    <div class="col-3 text-center">
                        <div class="row pb-4"></div>
                        <div class="row">
                            <div class="row">
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__remove-amount" disabled>
                                        <i class="fa-solid fa-minus"></i>
                                    </button>
                                </div>
                                <div class="col-4 text-center product-detail__amount">
                                    1
                                </div>
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__add-amount">
                                        <i class="fa-solid fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col p-0">
                        <div class="row pb-4 "></div>
                        <div class="row ps-3 product-detail__price">15000000</div>
                    </div>
                    <div class="col-1 p-0">
                        <div class="row pb-4"></div>
                        <i class="bi bi-trash"></i>
                    </div>
                </div>
                <div class=" row py-3 cart-item">
                    <div class="col-1 text-center">
                        <div class="row pb-4"></div>
                        <div class="row ps-4">
                            <div class="form-check">
                                <input class="product-checkbox form-check-input" type="checkbox">
                            </div>
                        </div>
                    </div>
                    <img class="col-2" src="../asset/image/product_image.png">
                    <div class="col-3 ps-5 pe-0">
                        <div class="row">Tranh thêu thám tử lừng danh Conan</div>
                        <div class="row pb-2"></div>
                        <div class="row">NXB Kim Đồng</div>
                    </div>
                    <div class="col-3 text-center">
                        <div class="row pb-4"></div>
                        <div class="row">
                            <div class="row">
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__remove-amount" disabled>
                                        <i class="fa-solid fa-minus"></i>
                                    </button>
                                </div>
                                <div class="col-4 text-center product-detail__amount">
                                    1
                                </div>
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__add-amount">
                                        <i class="fa-solid fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col p-0">
                        <div class="row pb-4 "></div>
                        <div class="row ps-3 product-detail__price">15000000</div>
                    </div>
                    <div class="col-1 p-0">
                        <div class="row pb-4"></div>
                        <i class="bi bi-trash"></i>
                    </div>
                </div>
                <div class=" row py-3 cart-item">
                    <div class="col-1 text-center">
                        <div class="row pb-4"></div>
                        <div class="row ps-4">
                            <div class="form-check">
                                <input class="product-checkbox form-check-input" type="checkbox">
                            </div>
                        </div>
                    </div>
                    <img class="col-2" src="../asset/image/product_image.png">
                    <div class="col-3 ps-5 pe-0">
                        <div class="row">Tranh thêu thám tử lừng danh Conan</div>
                        <div class="row pb-2"></div>
                        <div class="row">NXB Kim Đồng</div>
                    </div>
                    <div class="col-3 text-center">
                        <div class="row pb-4"></div>
                        <div class="row">
                            <div class="row">
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__remove-amount" disabled>
                                        <i class="fa-solid fa-minus"></i>
                                    </button>
                                </div>
                                <div class="col-4 text-center product-detail__amount">
                                    1
                                </div>
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__add-amount">
                                        <i class="fa-solid fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col p-0">
                        <div class="row pb-4 "></div>
                        <div class="row ps-3 product-detail__price">15000000</div>
                    </div>
                    <div class="col-1 p-0">
                        <div class="row pb-4"></div>
                        <i class="bi bi-trash"></i>
                    </div>
                </div>
                <div class=" row py-3 cart-item">
                    <div class="col-1 text-center">
                        <div class="row pb-4"></div>
                        <div class="row ps-4">
                            <div class="form-check">
                                <input class="product-checkbox form-check-input" type="checkbox">
                            </div>
                        </div>
                    </div>
                    <img class="col-2" src="../asset/image/product_image.png">
                    <div class="col-3 ps-5 pe-0">
                        <div class="row">Tranh thêu thám tử lừng danh Conan</div>
                        <div class="row pb-2"></div>
                        <div class="row">NXB Kim Đồng</div>
                    </div>
                    <div class="col-3 text-center">
                        <div class="row pb-4"></div>
                        <div class="row">
                            <div class="row">
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__remove-amount" disabled>
                                        <i class="fa-solid fa-minus"></i>
                                    </button>
                                </div>
                                <div class="col-4 text-center product-detail__amount">
                                    1
                                </div>
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__add-amount">
                                        <i class="fa-solid fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col p-0">
                        <div class="row pb-4 "></div>
                        <div class="row ps-3 product-detail__price">15000000</div>
                    </div>
                    <div class="col-1 p-0">
                        <div class="row pb-4"></div>
                        <i class="bi bi-trash"></i>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-1"></div>
        <div class="col-3 ms-0 discount_pay">
            <div class="row discount_area p-3 py-4">
                <div class="row">
                    <div class="col-8 h5">
                        <i class="bi bi-ticket-perforated me-1"></i>
                        <span>Khuyến mãi</span>
                    </div>
                    <div class="col"></div>
                    <div class="col-2 row">
                        <i class="bi bi-arrow-right-short discount-more h4 my-0"></i>
                    </div>
                </div>
                <hr>
                <div class="discounts-list">
                    <div class="row ps-3 py-2 discount-item">
                        <div class="row discount-title h6">Mã giảm giá 10K - Áp dụng cho toàn sàn</div>
                        <div class="row p-0">
                            <div class=" col-8 discount-description">Đơn từ 10.000.000.</div>
                            <div class="col-4 discount-detail">Chi tiết</div>
                        </div>
                        <div class="row mt-2">
                            <button class="apply_discount">Áp dụng</button>
                        </div>
                    </div>
                    <div class="row ps-3 py-2 discount-item">
                        <div class="row discount-title h6">Mã giảm giá 10K - Áp dụng cho toàn sàn</div>
                        <div class="row p-0">
                            <div class=" col-8 discount-description">Đơn từ 10.000.000.</div>
                            <div class="col-4 discount-detail">Chi tiết</div>
                        </div>
                        <div class="row mt-2">
                            <button class="apply_discount">Áp dụng</button>
                        </div>
                    </div>
                    <div class="row ps-3 py-2 discount-item">
                        <div class="row discount-title h6">Mã giảm giá 10K - Áp dụng cho toàn sàn</div>
                        <div class="row p-0">
                            <div class=" col-8 discount-description">Đơn từ 10.000.000.</div>
                            <div class="col-4 discount-detail">Chi tiết</div>
                        </div>
                        <div class="row mt-2">
                            <button class="apply_discount">Áp dụng</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row py-2"></div>
            <div class="row pay_area p-3">
                <div class="row pt-2">
                    <!--                    <div class="col-2 ps-4"></div>-->
                    <div class="col-10 h5"><i class="bi bi-cash-stack me-2"></i><span>Thành tiền</span></div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-8 h6">Tổng số tiền (đã tính VAT):</div>
                    <div class="col-4" id="total-price">0</div>
                </div>
                <div class="row ps-5 py-4 ">
                    <button class="payable rounded"><a href="../page/purchase.html" style="text-decoration: none;color: var(--web-background-color)">Thanh toán</a></button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
