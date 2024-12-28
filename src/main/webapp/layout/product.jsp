<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common.jsp"/>
<html>
<head>
<%--    <title>Các chính sách khác - Nét Việt</title>--%>
    <link rel="stylesheet" href="../template/style/user/product.css">
    <jsp:include page="public/library.jsp"/>
</head>
<body>
<jsp:include page="public/header.jsp"/>
<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb" class="container">
    <ol class="breadcrumb pt-2">
        <li class="breadcrumb-item"><a href="/">Trang chủ</a></li>
<%--        <li class="breadcrumb-item" aria-current="page"><a href="/category/tranh-theu-tay">${product.getCategory().getName()}</a></li>--%>
        <li class="breadcrumb-item" aria-current="page"><a href="/category/tranh-theu-tay">Tranh thêu tay</a></li>
<%--        Phần topic xử lý sau        --%>
<%--        <li class="breadcrumb-item" aria-current="page"><a href="/category/tranh-theu-tay/tranh-phong-canh">Tranh thêu Phong cảnh</a></li>--%>
        <li class="breadcrumb-item active" aria-current="page">${product.title}</li>
    </ol>
</nav>

<section class="container my-4_5" id="product-detail">
    <div class="background-container rounded">
        <div class="row">
            <div class="col-3 p-4_5">
                <img id="product-image" src="../template/asset/image/product_image.png" alt="">
                <p class="mt-4 mb-1">Kích thước: </p>
                <div class="w-100">
                    <button class="sub-cta-button py-2 px-2 rounded">
                        40x30cm
                    </button>
                    <button class="sub-cta-button py-2 px-2 rounded">
                        50x40cm
                    </button>
                    <button class="sub-cta-button py-2 px-2 rounded">
                        65x50cm
                    </button>
                </div>
            </div>
            <div class="col ps-4_5 p-4_5 ">
                <div class="row">
                    <h3 class="main-color">${product.title}</h3>
                </div>
                <div class="row mt-2">
                    <div class="col-6">Mã sản phẩm: <span class="fw-semibold">${product.code}</span></div>
                    <div class="col-6">Danh mục: <span class="fw-semibold">Tranh thêu tay</span></div>
                </div>
                <div class="row mt-2">
                    <div class="col-6">Nguyên liệu: <span class="fw-semibold">Vải, Kim, Chỉ</span></div>
                    <div class="col-6">Chủ đề: <span class="fw-semibold">Tranh Phong cảnh</span></div>
                </div>
                <div class="row mt-2">
                    <div class="col-6">Hãng sản xuất: <span class="fw-semibold">Tranh thêu Hà Sơn</span></div>
                    <div class="col-6">Còn lại: <span class="fw-semibold">200</span></div>
                </div>
                <div class="row my-2 mt-3">
                    <div class="col-4">
                        <div class=" d-flex justify-content-around" id="product-info__rating">
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star sample_half" style="color: #4d6a55;"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                            </div>

                        </div>
                        <p class="text-center mt-2">150 đánh giá</p>
                    </div>
                    <div class="col-2"></div>
                    <div class="col-6 row d-flex justify-content-start align-items-center">
                        <div class="col"></div>
                        <div id="product-detail__share-btn" class="col position-relative">
                            <i class="cursor-pointer h4 main-color fa-regular fa-share-from-square"></i>
                            <p class="bg-opacity-75 p-1 d-none notification-message bg-dark rounded">Đã copy link vào
                                clipboard</p>
                        </div>
                        <div id="product-detail__loved-btn" class="col position-relative">
                            <i class="cursor-pointer h4 main-color fa-regular fa-heart"></i>
                            <p class="bg-opacity-75 p-1 d-none notification-message bg-dark rounded"></p>
                        </div>
                        <div class="col"></div>
                    </div>
                </div>
                <div class="row col-4 mt-1">
                </div>
                <div class="row">
                    <div class="col-6 d-flex align-items-center">
                        <div class="col-4">
                            <div>Số lượng:</div>
                        </div>
                        <div class="col-8 row">
                            <div class="row">
                                <div class="col-4 text-center">
                                    <button class="rounded" id="product-detail__remove-amount" disabled>
                                        <i class="fa-solid fa-minus"></i>
                                    </button>
                                </div>
                                <div class="col-4 text-center" id="product-detail__amount">
                                    1
                                </div>
                                <div class="col-4 text-center">
                                    <button class="rounded" id="product-detail__add-amount">
                                        <i class="fa-solid fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 text-center">
                        <h2 style="color: var(--main-cta-button)">1.480.000 VNĐ</h2>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-6">
                        <button id="add-to-cart-btn" class="sub-cta-button  py-2 px-3 rounded">
                            <i class="fa-solid fa-cart-shopping" style="color: var(--sub-cta-button);"></i>
                            Thêm vào giỏ
                        </button>
                    </div>
                    <div class="col-6 d-flex justify-content-center">
                        <button id="purchase-btn" class="main-cta-button h4 py-3 px-4_5 rounded border-0">Mua ngay
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-3 p-4_5 rounded-end border-start border-1" id="product-sub-info">
                <div class="mb-4_5">
                    <div class="row">
                        <p class="fw-semibold">Tùy chọn giao hàng: </p>
                    </div>
                    <div class="row my-2 position-relative">
                        <div class="col-1">
                            <i class="bi bi-geo-alt"></i>
                        </div>
                        <div class="col-6">
                            <span> Chưa chọn</span>
                        </div>
                        <div class="col-5 text-end position-relative ">
                            <a class="text-decoration-none main-color" id="show-popup" href="account-page.html">THAY
                                ĐỔI</a>
                        </div>
                    </div>
                    <div class="row my-2">
                        <div class="col-1">
                            <!--                            <i class="fa-solid fa-truck"></i>-->
                            <i class="bi bi-truck"></i>
                        </div>
                        <div class="col-6">
                            <span>Giao hàng tận nơi</span>
                        </div>
                        <div class="col-5 text-end">
                            <span class="fw-bolder">130.000 VNĐ</span>
                        </div>
                    </div>
                    <div class="row my-2">
                        <div class="col-1">
                            <!--                            <i class="fa-solid fa-money-bill"></i>-->
                            <i class="bi bi-cash"></i>
                        </div>
                        <div class="col">
                            <span>Thanh toán bằng tiền mặt</span>
                            <div class="col">
                                <span>(Có thể thay đổi khi thanh toán)</span>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="mb-4_5">
                    <div class="row">
                        <p class="fw-semibold">Chương trình khuyến mãi: </p>
                    </div>
                    <div class="row">
                        <div class="col-1">
                            <!--                            <i class="fa-solid fa-tag"></i>-->
                            <i class="bi bi-tag"></i>
                        </div>
                        <div class="col">
                            <span>Chưa có chương trình khuyến mãi</span>
                        </div>
                    </div>
                </div>

                <div class="mb-4_5">
                    <div class="row">
                        <p class="fw-semibold">Chính sách: </p>
                    </div>
                    <div class="row">
                        <div class="col-1">
                            <!--                            <i class="bi bi-shield"></i>-->
                            <i class="bi bi-shield-slash"></i>
                        </div>
                        <div class="col">
                            <span>Không áp dụng chính sách bảo hành</span>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

</section>
<section class="container my-4_5" id="product-description">
    <div class="background-container rounded p-4_5">
        <h4 class="main-color">Mô tả sản phẩm</h4>
        <p class="product-description m-3">
            Bức tranh thêu tay phong cảnh đồng quê thích hợp làm quà tặng mừng tân gia,
            quà tặng đối tác là khách hay bạn bè quốc tế.
            Bức tranh không chỉ giới thiệu được phong cảnh nên thơ của đất nước
            mà còn giới thiệu đến bạn bè quốc tế một nghề truyền thống lâu đời của quê hương.
        </p>
        <p class="product-description m-3">
            Bằng bàn tay khéo léo của các nghệ nhân, những bức tranh thêu phong cảnh được thêu lên thật sinh động, sắc
            nét và tinh tế.
            Tranh thêu phong cảnh luôn mang lại cảm giác nhẹ nhàng, thanh thoát và thư thái tâm hồn cho người ngắm nhìn
            chúng. Mỗi mẫu tranh thêu phong cảnh đều tái hiện được những nét đẹp của phong cảnh đó như sự hung vỹ, huyền
            ảo của rừng núi, sự thơ mộng của con thuyền, mái đò…
        </p>
    </div>
</section>

<section class="container my-4_5" id="product-review">
    <div class="background-container rounded p-4_5">
        <div id="product-review-comment">
            <h4 class="main-color">Đánh giá</h4>
            <div class="row mt-4">
                <div class="col-2 row">
                    <div class="text-center">
                        <span id="current-star-rating" class="h3 main-color">4.0</span><span class="h5">/5.0</span>
                    </div>
                    <div id="product-review__star" class="mt-2 d-flex justify-content-center">
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star sample_half" style="color: #4d6a55;"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                        </div>
                    </div>
                    <div class="text-center">
                        <span>150 đánh giá</span>
                    </div>
                    <div class="text-center">
                        <span style="font-size: 12px">(Click vào số sao để đánh giá)</span>
                    </div>
                </div>
                <div class="col-8">
                    <textarea class="form-control" id="product-review--comment" rows="4"
                              placeholder="Đánh giá của bạn về sản phẩm"></textarea>
                    <p class="text-center mt-1 mb-0" style="font-size: 12px">(Bạn cần mua sản phẩm để có thể bình
                        luận)</p>
                </div>
                <div class="col-1 row d-flex align-items-center">
                    <button id="send-comment" class="btn sub-cta-button-background px-4 py-2">Gửi</button>
                </div>
            </div>
        </div>
        <hr/>
        <div>
            <h4 class="main-color">Bình luận</h4>
            <p class="text-start">(<span id="count-comment">3</span> bình luận)</p>
            <div id="comment-container">
                <div class="row product-review__comment-component mt-4_5">
                    <div class="col-3 text-center">
                        <h5>FanT1_20năm</h5>
                        <p>03/11/2024</p>
                        <div class="row">
                            <div class="col-2"></div>
                            <div class="col d-flex justify-content-center comment-rating">
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star sample_half"
                                       style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask" style="width: 100%"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                            </div>
                            <div class="col-2"></div>
                        </div>
                    </div>
                    <div class="col-8">
                        <p class="" style="white-space: pre-line">
                            - Đánh giá chung: Tranh khá là đẹp
                            - Vị trí treo tranh: Nên treo ở phòng khách hoặc phòng ngủ
                            - Giá cả: Với độ đẹp này thì giá cả vừa phải
                            - Chất liệu: Với mức giá này thì chất liệu tranh rất tốt
                        </p>
                    </div>
                </div>
                <div class="row product-review__comment-component mt-4_5">
                    <div class="col-3 text-center">
                        <h5>TraL04</h5>
                        <p>01/11/2024</p>
                        <div class="row">
                            <div class="col-2"></div>
                            <div class="col d-flex justify-content-center comment-rating">
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star sample_half"
                                       style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask" style="width: 100%"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask" style="width: 100%"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                            </div>
                            <div class="col-2"></div>
                        </div>
                    </div>
                    <div class="col-8">
                        <p class="" style="white-space: pre-line">Nét mềm mại, không chỉ thừa, phù hợp trang trí nhà,
                            rất đáng tiền mua</p>
                    </div>
                </div>
                <div class="row product-review__comment-component mt-4_5">
                    <div class="col-3 text-center">
                        <h5>Anh Nguyễn</h5>
                        <p>23/10/2024</p>
                        <div class="row">
                            <div class="col-2"></div>
                            <div class="col d-flex justify-content-center comment-rating">
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star sample_half"
                                       style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                                <div class="col-2 product-info__star-container   px-0">
                                    <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                    <div class="product-info__star-mask"></div>
                                    <i class="fa-regular fa-star product-info__star-outline"
                                       style="color: #4d6a55;"></i>
                                </div>
                            </div>
                            <div class="col-2"></div>
                        </div>
                    </div>
                    <div class="col-8">
                        <p class="" style="white-space: pre-line">Lorem ipsum dolor sit amet, consectetur adipiscing
                            elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
                            veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
                            pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt
                            mollit anim id est laborum.</p>
                    </div>
                </div>
            </div>
            <div class="d-flex justify-content-center mt-4">
                <button class="sub-cta-button  py-2 px-3 rounded">
                    Xem thêm
                </button>
            </div>
        </div>
    </div>
</section>
<section class="container my-4_5" id="other-product">
    <div class="background-container rounded p-4_5">
        <h4 class="main-color">Sản phẩm khác</h4>
        <div class="row mt-2">
            <div class="col other-product__card">
                <div class="card p-2" style="cursor: pointer">
                    <img src="../template/asset/image/product_image.png" class="card-img-top" alt="...">
                    <div class="card-body px-1 row">
                        <h6 class="card-title text-start pb-2">Tranh Phong cảnh Hồ gươm 15</h6>
                        <p class="card-text text-center fw-semibold h5 mt-2"
                           style="color: var(--sub-cta-button)">
                            1.850.000 VNĐ</p>
                        <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
                    </div>
                </div>
            </div>
            <div class="col other-product__card">
                <div class="card p-2" style="cursor: pointer">
                    <img src="../template/asset/image/product_image.png" class="card-img-top" alt="...">
                    <div class="card-body px-1">
                        <h6 class="card-title text-start pb-2">Tranh Phong cảnh Hồ gươm 14</h6>
                        <p class="card-text text-center fw-semibold h5 mt-2"
                           style="color: var(--sub-cta-button)">
                            1.850.000 VNĐ</p>
                        <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
                    </div>
                </div>
            </div>
            <div class="col other-product__card">
                <div class="card p-2" style="cursor: pointer">
                    <img src="../template/asset/image/product_image.png" class="card-img-top" alt="...">
                    <div class="card-body px-1">
                        <h6 class="card-title text-start pb-2">Tranh Phong cảnh Gánh lúa 1</h6>
                        <p class="card-text text-center fw-semibold h5 mt-2"
                           style="color: var(--sub-cta-button)">
                            1.250.000 VNĐ</p>
                        <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
                    </div>
                </div>
            </div>
            <div class="col other-product__card">
                <div class="card p-2" style="cursor: pointer">
                    <img src="../template/asset/image/product_image.png" class="card-img-top" alt="...">
                    <div class="card-body px-1">
                        <h6 class="card-title text-start pb-2">Tranh Phong cảnh Gánh lúa 2</h6>
                        <p class="card-text text-center fw-semibold h5 mt-2"
                           style="color: var(--sub-cta-button)">
                            1.250.000 VNĐ</p>
                        <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
                    </div>
                </div>
            </div>
            <div class="col other-product__card">
                <div class="card p-2" style="cursor: pointer">
                    <img src="../template/asset/image/product_image.png" class="card-img-top" alt="...">
                    <div class="card-body px-1">
                        <h6 class="card-title text-start pb-2">Tranh Phong cảnh Chùa một cột 3</h6>
                        <p class="card-text text-center fw-semibold h5 mt-2"
                           style="color: var(--sub-cta-button)">
                            1.850.000 VNĐ</p>
                        <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="public/footer.jsp"/>
</body>
</html>
