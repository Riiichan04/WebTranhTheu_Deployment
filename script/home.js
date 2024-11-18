const productSample = `
<div class="col">
    <div class="card p-2" style="cursor: pointer">
        <img src="../asset/product_image.png" class="card-img-top" alt="...">
        <div class="card-body px-1">
            <h6 class="card-title text-start pb-2">Tranh thêu thám tử lừng danh Conan</h6>
            <div class="col d-flex justify-content-start comment-rating">
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
            <p class="card-text text-center fw-semibold h5 mt-2" style="color: var(--sub-cta-button)">20.000.000 VNĐ</p>
        </div>
    </div>
</div>`

let limitProduct = 100

$("#full-product-button").click(function () {
    if (limitProduct > 0) {
        for (let num = 0; num < 4; num ++) {
            const productContainer = document.createElement("div")
            productContainer.className = "row mt-1"
            for (let i = 0; i < 5; i++) {
                productContainer.innerHTML += productSample;
            }
            $("#full-product__product-list").append(productContainer);
        }
        limitProduct -= 4*5
    }
    if (limitProduct <= 0) {
        $(this).attr('disabled', true)
    }
})