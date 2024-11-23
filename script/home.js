const listData = []

$.getJSON("../asset/data.json", (data) => {
    $.each(data, (index, element) => {
        listData.push(`
            <div class="col">
                <div class="card p-2" style="cursor: pointer">
                    <img src="../asset/product_image.png" class="card-img-top" alt="...">
                    <div class="card-body px-1">
                        <h6 class="card-title text-start pb-2">${element.title}</h6>
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
                        <p class="card-text text-center fw-semibold h5 mt-2" style="color: var(--sub-cta-button)">${element.price}</p>
                    </div>
                </div>
            </div>`)
    })

    $("#hot-product-section>div").append(createRowProduct(5))
    $("#most-rated-product-section>div").append(createRowProduct(5))

})

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


let limitProduct = 100
$("#full-product-button").click(function () {
    if (limitProduct > 0) {
        for (let num = 0; num < 4; num++) {
            $("#full-product__product-list").append(createRowProduct(5));
        }
        limitProduct -= 4 * 5
    }
    if (limitProduct <= 0) {
        $(this).attr('disabled', true)
    }
})
