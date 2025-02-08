<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common.jsp"/>
<html>
<head>
    <title>${product.category.title} ${product.title} - Nét Việt</title>
    <link rel="stylesheet" href="../template/style/user/product.css">
    <jsp:include page="public/library.jsp"/>
</head>
<body>
<jsp:include page="public/header.jsp"/>
<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb" class="container">
    <ol class="breadcrumb pt-2">
        <li class="breadcrumb-item"><a href="/">Trang chủ</a></li>
        <li class="breadcrumb-item" aria-current="page"><a
                href="/category/${product.category.patternName}">${product.category.title}</a>
        </li>
        <li class="breadcrumb-item active" aria-current="page">${product.title}</li>
    </ol>
</nav>

<section class="container my-4_5" id="product-detail">
    <div class="background-container ">
        <div class="row">
            <div class="col-3 p-4_5">
                <img id="product-image" src="${product.getThumbnail()}" alt="">
                <p class="mt-4 mb-1">Kích thước: </p>
                <div class="w-100">
                    <c:forEach var="price" items="${product.getListPrices()}">
                        <button class="sub-cta-button py-2 px-2 rounded switch-size-btn"
                                data-width=${price.width} data-height=${price.height}>
                                ${price.width}x${price.height}cm
                        </button>
                    </c:forEach>
                </div>
                <div class="mt-4_5" id="current-size-notice"></div>
            </div>
            <div class="col ps-4_5 p-4_5 ">
                <div class="row">
                    <h3 class="main-color">${product.category.title} ${product.title}</h3>
                </div>
                <div class="row mt-2">
                    <div class="col-6">Mã sản phẩm: <span class="fw-semibold">${product.code}</span></div>
                    <div class="col-6">Danh mục:
                        <span class="fw-semibold">${product.category.title}</span>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-6">Nguyên liệu: <span class="fw-semibold">
                        ${product.getStringDisplayMaterials()}
                    </span></div>
                    <div class="col-6">Chủ đề: <span class="fw-semibold">
                        <c:forEach var="topic" items="${product.listTopics}" varStatus="status">
                            ${topic.title}
                            <c:if test="${!status.last}">, </c:if>
                        </c:forEach>
                    </span></div>
                </div>
                <div class="row mt-2">
                    <div class="col-6">Hãng sản xuất: <span class="fw-semibold">Tranh thêu Hà Sơn</span></div>
                    <div class="col-6">Còn lại: <span class="fw-semibold" id="product-detail__available--value"></span>
                    </div>
                </div>
                <div class="row my-2 mt-3">
                    <div class="col-4">
                        <div class=" d-flex justify-content-around" id="product-info__rating">
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: var(--big-text-color)"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: var(--big-text-color)"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: var(--big-text-color)"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: var(--big-text-color)"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: var(--big-text-color)"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: var(--big-text-color)"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star sample_half" style="color: var(--big-text-color)"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: var(--big-text-color)"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: var(--big-text-color)"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: var(--big-text-color)"></i>
                            </div>

                        </div>
                        <p class="text-center mt-2"><span class="current-review">${countReview}</span> đánh giá</p>
                    </div>
                    <div class="col-2"></div>
                    <div class="col-6 row d-flex justify-content-start align-items-center">
                        <div class="col"></div>
                        <div id="product-detail__share-btn" class="col position-relative">
                            <i class="cursor-pointer h4 main-color fa-regular fa-share-from-square"></i>
                            <p class="bg-opacity-75 p-1 d-none notification-message bg-dark rounded">Đã copy link vào
                                clipboard</p>
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
                    <div class="col-6 text-center" style="position: relative">
                        <h2 id="product-details__price" style="color: var(--main-cta-button)"></h2>
                        <p class="d-none" id="product-details__old-price"><s class="text-secondary"></s><span
                                class="ms-2 main-cta-button h6 p-1 rounded" id="discount-value"></span></p>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-6">
                        <button id="add-to-cart-btn" class="sub-cta-button py-2 px-3 rounded" onclick="addToCart()">
                            <i class="fa-solid fa-cart-shopping" style="color: var(--sub-cta-button);"></i>
                            Thêm vào giỏ
                        </button>
                    </div>
                    <div class="col-6 d-flex justify-content-center">
                        <button id="purchase-btn" class="main-cta-button h4 py-3 px-4_5 rounded border-0">Thanh toán
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-3 p-4_5 rounded-end border-start border-3" id="product-sub-info">
                <div class="mb-4_5">
                    <div class="row">
                        <p class="fw-semibold">Tùy chọn giao hàng: </p>
                    </div>
                    <div class="row my-2 position-relative">
                        <div class="col-1">
                            <i class="bi bi-geo-alt"></i>
                        </div>
                        <div class="col-6">
                            <span>${location}</span>
                        </div>
                        <div class="col text-end position-relative ">
                            <a class="text-decoration-none main-color" id="show-popup" href="/user">
                                THAY ĐỔI</a>
                        </div>
                    </div>
                    <div class="row my-2">
                        <div class="col-1">
                            <i class="bi bi-truck"></i>
                        </div>
                        <div class="col pe-0">
                            <span>Giao hàng tận nơi</span>
                            <span class="fw-bolder text-end ps-4_5">130.000 VNĐ</span>
                        </div>
                    </div>
                    <div class="row my-2">
                        <div class="col-1">
                            <i class="bi bi-cash"></i>
                        </div>
                        <div class="col">
                            <span>Thanh toán bằng tiền mặt</span>
                        </div>

                    </div>
                </div>
                <div class="mb-4_5">
                    <div class="row">
                        <p class="fw-semibold">Chương trình khuyến mãi: </p>
                    </div>
                    <div class="row">
                        <div class="col-1">
                            <i class="bi bi-tag"></i>
                        </div>
                        <div class="col ps-3">
                            <span class="p-0">${product.getDiscount().displayDiscountDetail()}</span>
                        </div>
                    </div>
                </div>

                <div class="mb-4_5">
                    <div class="row">
                        <p class="fw-semibold">Chính sách: </p>
                    </div>
                    ${product.getPolicy().getDescription()}
                </div>

            </div>
        </div>
    </div>

</section>
<section class="container my-4_5" id="product-description">
    <div class="background-container  p-4_5">
        <h4 class="main-color">Mô tả sản phẩm</h4>
        <p class="product-description m-3">
            ${product.description}
        </p>
    </div>
</section>

<section class="container my-4_5" id="product-review">
    <div class="background-container  p-4_5">
        <div id="product-review-comment">
            <h4 class="main-color">Đánh giá</h4>
            <div class="row mt-4">
                <div class="col-2 row">
                    <div class="text-center">
                        <span id="current-star-rating" class="h3 main-color">${avgRating}</span><span
                            class="h5">/5.0</span>
                    </div>
                    <div id="product-review__star" class="mt-2 d-flex justify-content-center">
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: var(--big-text-color)"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: var(--big-text-color)"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: var(--big-text-color)"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: var(--big-text-color)"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: var(--big-text-color)"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: var(--big-text-color)"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star sample_half" style="color: var(--big-text-color)"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: var(--big-text-color)"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: var(--big-text-color)"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: var(--big-text-color)"></i>
                        </div>
                    </div>
                    <div class="text-center">
                        <span class="current-review">${countReview} đánh giá</span>
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
                    <p class="d-none d-flex justify-content-center" id="post-review-result"></p>
                </div>
                <div class="col-1 row d-flex align-items-center">
                    <button id="send-comment" class="btn sub-cta-button-background px-4 py-2">Gửi</button>
                </div>
            </div>
        </div>
        <hr/>
        <div>
            <h4 class="main-color">Bình luận</h4>
            <p class="text-start">(<span id="count-comment">${countReview}</span> bình luận)</p>
            <div id="comment-container">
            </div>
            <div class="d-flex justify-content-center mt-4">
                <button class="sub-cta-button  py-2 px-3 rounded" id="load-more-review">
                    Xem thêm
                </button>
            </div>
        </div>
    </div>
</section>
<section class="container my-4_5" id="other-product">
    <div class="background-container  p-4_5">
        <h4 class="main-color">Sản phẩm khác</h4>
        <div class="row mt-2">
            <c:forEach var="product" items="${similarProduct}">
                <div class="card-element mb-3" style="width: 20%">
                    <div onclick="window.location = '/product?id=${product.id}'" class="card p-2" style="cursor: pointer">
                        <img src="${product.getThumbnail()}" class="card-img" alt="...">
                        <div class="card-body px-1">
                            <h5 class="card-title text-center pb-2 fw-semibold text-truncate"
                                title="${product.category} ${product.title}">
                                    ${product.category} ${product.title}
                            </h5>
                            <p class="card-text my-1 text-center text-truncate"
                               title="Nhà cung cấp: ${product.getProvider().getProviderName()}">
                                Nhà cung cấp: <span class="fw-semibold">${product.getProvider().getProviderName()}</span>
                            </p>
                            <p class="card-text text-center text-truncate my-1"
                               title="Nguyên liệu: ${product.getStringDisplayMaterials()}">
                                Nguyên liệu: <span class="fw-semibold">${product.getStringDisplayMaterials()}</span>
                            </p>
                            <p class="card-text text-center mt-1">
                                Kích thước: từ <span class="fw-semibold">${product.getMinPrice().getWidth()}x${product.getMinPrice().getHeight()} cm</span>
                            </p>
                            <p class="card-text text-center fw-semibold h4 mt-2"
                               style="color: var(--main-cta-button)">${product.getMinPrice().getDisplayPriceToString()}
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<div id="popup-overlay"></div>
<div id="popup" class="p-3">
    <div class="row text-center fw-bold h5 border-bottom">
        <div class="col-11 h4 text-center">Lỗi</div>
        <i class="col-1 p-2 text-center bi bi-x-lg" onclick="closeError()"></i>
    </div>
    <c:choose>
        <c:when test="${sessionScope.accountId == null}">
            <div class="row mt-2 ms-2 text-center">Bạn cần đăng nhập để thêm sản phẩm vào giỏ.</div>
        </c:when>
        <c:otherwise>
            <div class="row mt-2 ms-2 text-center">Số lượng sản phẩm vượt mức quy định.</div>
        </c:otherwise>
    </c:choose>
</div>
<jsp:include page="public/footer.jsp"/>
<script src="template/script/header.js"></script>
<script src="template/script/product.js"></script>
<script>
    let flag = false

    displayRating(${avgRating}, $(".product-info__star-container").width())

    $("#purchase-btn").click(function () {
        flag = true
        addToCart()
    })

    function addToCart() {
        let id = '${product.id}'
        const urlParams = new URLSearchParams(window.location.search);
        let width = urlParams.get("width")
        let height = urlParams.get("height")
        let quantity = parseInt($("#product-detail__amount").prop("innerText"))
        let accountId = '${sessionScope.accountId}'
        if (accountId !== '' || accountId !== null) {
            const totalQuantity= parseInt($("#cart-badge").text())
            if(totalQuantity + quantity <=10) {
                $.ajax({
                    url: '/add-product?id=' + id + '&width=' + width + '&height=' + height + '&quantity=' + quantity,
                    type: 'POST',
                    success: function (data) {
                        console.log(data)
                        data = $.parseJSON(data)
                        if (data.result) {
                            const badge = $("#cart-badge")
                            const currentCartLength = data.currentCartLength
                            badge.removeClass("d-none")
                            badge.text(currentCartLength)
                            if (flag) {
                                window.location = '/purchase'
                            }
                        } else alert("Có lỗi khi thêm sản phẩm vào giỏ hàng")
                    },
                    error: function () {

                    }
                })
            }
            else {
                $("#popup").css("display", "block")
                $("#popup-overlay").css("display", "block")
            }
        }
        else alert("Bạn cần đăng nhập")
    }
</script>
</body>
</html>
