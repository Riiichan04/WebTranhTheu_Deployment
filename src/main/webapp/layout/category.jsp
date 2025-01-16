<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common.jsp"/>
<html>
<head>
  <link rel="stylesheet" href="../template/style/user/category.css">
  <jsp:include page="public/library.jsp"/>
</head>
<body>
<jsp:include page="public/header.jsp"/>

<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb" class="container">
  <ol class="breadcrumb pt-2">
    <li class="breadcrumb-item"><a href="index.html">Trang chủ</a></li>
<%--    <li class="breadcrumb-item active" aria-current="page"></li>--%>
  </ol>
</nav>

<section class="container mt-2 mb-5">
  <div class="row">
    <div class="col-2 pe-3 ps-0">
      <div class="rounded py-4_5 background-container">
        <div class="category-list">
          <h5 class="ms-2 mb-2 main-color p-1 ps-2">Danh mục </h5>
          <hr/>
          <p class="category-active p-2 category-element">Tranh thêu tay</p>
          <p class=" p-2 category-element">Tranh thêu chữ thập</p>
          <p class=" p-2 category-element">Tranh thêu máy tính</p>
        </div>
        <div class="category-filter mt-4_5">
          <h5 class="ms-2 mb-2 main-color p-1 ps-2">Bộ lọc </h5>
          <hr/>
          <div class="mt-3 ps-2">
            <p class="mb-2 fw-semibold">Theo chủ đề tranh:</p>
            <div class="mb-4">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="sceneryTopic">
                <label class="form-check-label" for="sceneryTopic">
                  Tranh thêu Phong cảnh
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="portraitTopic">
                <label class="form-check-label" for="portraitTopic">
                  Tranh thêu Chân dung
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="animalTopic">
                <label class="form-check-label" for="animalTopic">
                  Tranh thêu Động vật
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="fourSeasonTopic">
                <label class="form-check-label" for="fourSeasonTopic">
                  Tranh thêu Tứ quý
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flowerTopic">
                <label class="form-check-label" for="flowerTopic">
                  Tranh thêu Hoa
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="vipTopic">
                <label class="form-check-label" for="vipTopic">
                  Tranh thêu VIP
                </label>
              </div>
            </div>
            <p class="fw-semibold">Theo nhà cung cấp:</p>
            <div class="mt-1 mb-4">
              <input type="text" class="rounded border-0 col" placeholder="Nhập tên nhà cung cấp">
            </div>
            <p class="mt-3 fw-semibold">Theo giá tiền (VNĐ):</p>
            <div class="d-flex mt-1 mb-4">
              <input type="text" class="rounded border-0 col-5" placeholder="Từ">
              <div class=" mb-1 col-1 text-center">-</div>
              <input type="text" class="rounded border-0 col-5" placeholder="Đến">
            </div>
            <p class="mt-3 fw-semibold">Theo đánh giá:</p>
            <div class="d-flex mb-4">
              <div>
                <div class="d-flex align-items-center">
                  <div class="radio-container pt-2"><input class="form-check-input" type="radio"
                                                           name="rating-star"></div>
                  <div class="style-label"><span
                          class="style-star ms-2">&#9733; &#9733; &#9733; &#9733; &#9733;</span>
                  </div>
                </div>
                <div class="d-flex align-items-center">
                  <div class="radio-container pt-2"><input class="form-check-input" type="radio"
                                                           name="rating-star"></div>
                  <div class="style-label"><span
                          class="style-star mx-2">&#9733; &#9733; &#9733; &#9733; &#x2729;</span>trở
                    lên
                  </div>
                </div>
                <div class="d-flex align-items-center">
                  <div class="radio-container pt-2"><input class="form-check-input" type="radio"
                                                           name="rating-star"></div>
                  <div class="style-label"><span
                          class="style-star mx-2">&#9733; &#9733; &#9733; &#x2729; &#x2729;</span>trở
                    lên
                  </div>
                </div>
                <div class="d-flex align-items-center">
                  <div class="radio-container pt-2"><input class="form-check-input" type="radio"
                                                           name="rating-star"></div>
                  <div class="style-label"><span
                          class="style-star mx-2">&#9733; &#9733; &#x2729; &#x2729; &#x2729;</span>trở
                    lên
                  </div>
                </div>
                <div class="d-flex align-items-center">
                  <div class="radio-container pt-2"><input class="form-check-input" type="radio"
                                                           name="rating-star"></div>
                  <div class="style-label"><span
                          class="style-star mx-2">&#9733; &#x2729; &#x2729; &#x2729; &#x2729;</span>trở
                    lên
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row d-flex justify-content-evenly mt-4">
            <button id="remove-filter" class="col-3 p-2 border-0 rounded sub-cta-button">Hủy</button>
            <button id="filter-btn" class="col-6 p-2 border-0 rounded sub-cta-button-background">Áp dụng
            </button>
          </div>
        </div>
      </div>
    </div>
    <div class="col-10 background-container rounded p-4_5">
      <h4 id="category-title" class="main-color">Tranh thêu tay</h4>
      <hr class="mb-5"/>
      <div>
        <div class="row mt-1">
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1 row">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
        </div>
        <div class="row mt-1">
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
        </div>
        <div class="row mt-1">
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
        </div>
        <div class="row mt-1">
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
        </div>
        <div class="row mt-1">
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card p-2" style="cursor: pointer">
              <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
              <div class="card-body px-1">
                <h6 class="card-title text-start pb-2">Tranh thêu sông nước</h6>

                <p class="card-text text-center fw-semibold h5 mt-2"
                   style="color: var(--sub-cta-button)">
                  1.840.000
                  VNĐ</p>
                <!--                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>-->
              </div>
            </div>
          </div>
        </div>
        <div>
          <nav>
            <ul class="pagination d-flex justify-content-center">
              <li class="page-item">
                <a class="page-link disabled" href="#" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <li class="page-item"><p class="page-link">1</p></li>
              <li class="page-item">
                <a class="page-link disabled" href="#" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
</section>

<jsp:include page="public/footer.jsp"/>
<script src="/template/script/header.js"></script>
</body>
</html>
