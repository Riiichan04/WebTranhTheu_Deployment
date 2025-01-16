$(".category-element").click(function () {
    $(".category-element").removeClass("category-active");
    $(this).addClass("category-active");
    $("#category-title").text($(this).text());
})

$(".card").click(function () {
    window.location = "../page/product.html"
})

$("#remove-filter").click(function () {
    $("input[type=text]").val("");
    $("input[type=radio]").prop('checked', false);
})

$("#filter-btn").click(function () {
    location.reload();
})

let pathName = window.location.href.split("/")
let patternName = pathName[pathName.length - 1] //Lấy pattern name ra. Nếu không có phần này thì servlet bắt lỗi
let currentPage = 1 //Trang hiện tại
let maxPage
const amount = 25 //Số lượng sp/trang cần display

function getProductsByCategory() {
    $.ajax({
        url: '/category-product-getter',
        method: 'GET',
        data: {
            page: currentPage,
            amount: amount,
            maxPage: maxPage,
            patternName: patternName
        },
        success: function (response) {
            response = $.parseJSON(response)
            if (response.result) {
                if (maxPage == null) maxPage = response.maxPage
                getOneProductsRow(response.listProducts)
                currentPage = response.currentPage
            }
            else {
                $("#category-displayed-product").append(`<p class="d-flex justify-content-center align-items-center">${response.notice}</p>`)
            }
        },
        error: function (response) {

        }
    })
}

function getOneProductsRow(listProducts) {
    let productHtml = `<div class='row'>`
    for (let product of listProducts) {
        productHtml += `
            <div class="" style="width: 20%">
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
    $("#category-displayed-product").append(productHtml)
}

getProductsByCategory()