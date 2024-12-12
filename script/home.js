const listData = []
const LIMIT_PRODUCT = 100
let currentLimitProduct = 0

listData.push(`
            <div class="col">
                <div onclick="showProductPage()" class="card p-2" style="cursor: pointer">
                    <img src="../asset/image/product_image.png" class="card-img-top" alt="...">
                    <div class="card-body px-1">
                        <h6 class="card-title text-center pb-2">Tranh thêu phong cảnh</h6>
                        <p class="card-text text-center fw-semibold h5 mt-2" style="color: var(--sub-cta-button)">1.500.000 VNĐ</p>
                    </div>
                </div>
            </div>`)

function createRowProduct(rowLength) {
    const productContainer = document.createElement("div")
    const listProduct = createListProduct(5)
    productContainer.className = "row mt-1"
    for (let i = 0; i < rowLength; i++) {
        productContainer.innerHTML += listProduct[i];
    }
    return productContainer
}

function createListProduct(rowLength) {
    const result = []
    for (let i = 0; i < rowLength; i++) {
        const element = listData[Math.floor(Math.random() * listData.length)]
        result.push(element)
    }
    return result
}

function showProductPage() {
    window.location = "../page/product.html"
}

$("#full-product-button").click(function () {
    if (currentLimitProduct <= LIMIT_PRODUCT) {
        for (let num = 0; num < 4; num++) {
            $("#full-product__product-list").append(createRowProduct(5));
        }
        currentLimitProduct += 4 * 5
    }
    if (currentLimitProduct > LIMIT_PRODUCT) {
        $(this).attr('disabled', true)
    }
})

$(".open-category-button").click(function () {
    window.location = "../page/category.html"
})
