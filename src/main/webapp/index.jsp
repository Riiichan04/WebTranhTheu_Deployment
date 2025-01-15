<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="layout/common.jsp"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ - Nét Việt</title>
    <jsp:include page="layout/public/library.jsp"/>
    <link rel="stylesheet" href="template/style/user/home.css">
</head>
<body>
<jsp:include page="layout/public/header.jsp"/>
<section id="landing-section" class="container mt-5">
    <div class="row p-4">
        <div class="col-6 d-flex justify-content-center flex-column">
            <div class="text-center my-3">
                <img src="template/asset/favicon/web_logo_revert_color.png" width="175px" height="175px">
            </div>
            <h2 class="text-center main-color">Thanh tao, Mộc mạc, Uyển chuyển</h2>
            <p class="text-center mt-2 mx-5">
                Nét Việt tự hào mang đến một trang web chứa đựng các tác phẩm qua nét thêu của nghệ nhân Việt,
                mang đến cho người sở hữu một cảm giác đầy tính nghệ thuật và tao nhã. Tập hợp các bộ sưu tập với nhiều
                chủ đề khác nhau,
                phù hợp để trang trí không gian sống. Tranh thêu của Nét Việt chính là quà tặng ý nghĩa cho bạn bè và
                người thân
            </p>
        </div>
        <div class="col-6 p-0 position-relative">
            <img class="w-100" src="template/asset/image/landing-image.jpeg" alt="" srcset="">
        </div>
    </div>
</section>
<section class="container background-container p-4_5 rounded my-4_5" id="hot-product-section">
    <div class="row">
        <h5 class="main-color mb-3"> Sản phẩm HOT</h5>
        <hr/>
        <c:forEach var="product" items="${hotProduct}">
            <div class="col">
                <div onclick="window.location = '/product?id=${product.id}'" class="card p-2" style="cursor: pointer">
                    <img src="${product.getThumbnail()}" class="card-img" alt="...">
                    <div class="card-body px-1">
                            <%-- Tạm --%>
                        <h6 class="card-title text-center pb-2">${product.category} ${product.title}</h6>
                        <p class="card-text text-center fw-semibold h5 mt-2"
                           style="color: var(--sub-cta-button)">${product.getMinPrice().getDisplayPriceToString()}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<section class="container background-container p-4_5 rounded my-4_5" id="most-rated-product-section">
    <div class="row">
        <h5 class="main-color mb-3"> Sản phẩm được đánh giá cao nhất</h5>
        <hr/>
        <c:forEach var="product" items="${mostRatedProduct}">
            <div class="col">
                <div onclick="window.location = '/product?id=${product.id}'" class="card p-2" style="cursor: pointer">
                    <img src="${product.getThumbnail()}" class="card-img" alt="...">
                    <div class="card-body px-1">
                            <%-- Tạm --%>
                        <h6 class="card-title text-center pb-2">${product.category} ${product.title}</h6>
                        <p class="card-text text-center fw-semibold h5 mt-2"
                           style="color: var(--sub-cta-button)">${product.getMinPrice().getDisplayPriceToString()}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<section class="container background-container p-4_5 rounded my-4_5" id="category-section">
    <div class="row">
        <h5 class="main-color mb-3">Tranh thêu theo chủ đề</h5>
        <hr/>
        <div class="row">
            <div class="col text-center open-category-button" style="cursor: pointer">Tranh thêu phong cảnh</div>
            <div class="col text-center open-category-button" style="cursor: pointer">Tranh thêu động vật</div>
            <div class="col text-center open-category-button" style="cursor: pointer">Tranh thêu hoa</div>
            <div class="col text-center open-category-button" style="cursor: pointer">Tranh thêu tứ quý</div>
            <div class="col text-center open-category-button" style="cursor: pointer">Tranh thêu chân dung</div>
            <div class="col text-center open-category-button" style="cursor: pointer">Tranh thêu phong thủy</div>
            <div class="col text-center open-category-button" style="cursor: pointer">Tranh thêu VIP</div>
        </div>
    </div>
</section>
<section class="container background-container p-4_5 rounded my-4_5" id="full-product-section">
    <div class="row">
        <h5 class="main-color mb-3">Tất cả sản phẩm </h5>
        <hr/>
        <div id="full-product__product-list">
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col-4  d-flex justify-content-center" id="more-product-btn">
                <button id="full-product-button" class="rounded sub-cta-button-background px-3 py-2 border-0">Xem thêm
                </button>
            </div>
            <div class="col"></div>
        </div>
    </div>
</section>
<jsp:include page="layout/public/footer.jsp"/>
<script src="template/script/home.js"></script>
<script src="template/script/header.js"></script>
</body>
</html>