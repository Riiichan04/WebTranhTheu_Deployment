let offset = 1
let amount = 5
let limitProduct

function getOneProductsRow(listProducts) {
    let productHtml = `<div class='row'>`
    for (let product of listProducts) {
        productHtml += `
            <div class="col">
                <div onclick="window.location='/product?id=${product.id}'" class="card p-2" style="cursor: pointer">
                    <img src="${product.thumbnail}" class="card-img" alt="">
                    <div class="card-body px-1">
                        <h6 class="card-title text-center pb-2">${product.title}</h6>
                        <p class="card-text text-center fw-semibold h5 mt-2" style="color: var(--sub-cta-button)">${product.price}</p>
                    </div>
                </div>
            </div>
        `
    }
    productHtml += `</div>`
    $("#full-product__product-list").append(productHtml)
}

function sendProductRequest() {
    $.ajax({
        url: '/get-product-row',
        method: 'GET',
        data: {
            offset: offset,
            limit: limitProduct
            // amount: amount
        },
        success: function(response) {
            response = $.parseJSON(response)
            if (response.result) {
                limitProduct = response.limit ? response.limit : limitProduct
                let countProduct = response.listProducts.length
                getOneProductsRow(response.listProducts)
                //Còn cần sửa thêm
                offset = response.currentOffset
            }
            else {
                offset = -1
            }
            //Tạm
            if (offset >= limitProduct) {
                $("#full-product-button").addClass("d-none")
                $("#full-product-button").attr("disabled", true)
                $("#more-product-btn").append("<p class='mt-4 d-flex justify-content-center text-center'>Bạn đã xem hết sản phẩm</p>")
            }
        },
        error: function(response) {

        }
    })
}

$("#full-product-button").click(function () {
    // if ($(window).scrollTop + $(window).offsetHeight + 100 > $(this).offsetHeight && offset !== -1) {
    if (offset !== -1) sendProductRequest()
})

sendProductRequest()