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

function getProductsByCategory(page) {
    console.log(page)
    $.ajax({
        url: '/category-product-getter',
        method: 'GET',
        data: {
            page: page,
            amount: amount,
            maxPage: maxPage,
            patternName: patternName
        },
        success: function (response) {
            response = $.parseJSON(response)
            if (response.result) {
                if (maxPage == null) maxPage = response.maxPage
                //Thêm product vào category
                getOneProductsRow(response.listProducts)
                currentPage = response.currentPage

                $("#current-page").text((currentPage) + "")
                //Disable và enable các button chuyển trang
                if (currentPage === 1) {
                    $("#prev-page").addClass("disabled")
                    $("#next-page").removeClass("disabled")
                }
                if (currentPage === maxPage && maxPage !== 1) {
                    $("#next-page").addClass("disabled")
                    $("#prev-page").removeClass("disabled")
                }
                if (maxPage === 1) {
                    $("#next-page").addClass("disabled")
                    $("#prev-page").addClass("disabled")
                }
                //Set active cho button category đang chọn
                $(".category-element").each(function () {
                    if ($(this).data("categoryName") === patternName) {
                        $(this).addClass("active")
                    }
                })
            }
            else {
                $("#category-displayed-product").html(`<p class="d-flex justify-content-center align-items-center">${response.notice}</p>`)
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
    $("#category-displayed-product").html(productHtml)
}


$("#prev-page").click(function () {
    getProductsByCategory(--currentPage)
})

$("#next-page").click(function () {
    getProductsByCategory(++currentPage)
})

getProductsByCategory(currentPage)


function changeCategoryName(pattern) {
    let url = window.location.href
    url = url.substring(0, url.lastIndexOf("/")+1) + pattern
    if (patternName !== pattern) {
        window.history.pushState({}, '', url)
        patternName = pattern
        currentPage = 1
        maxPage = null
        getProductsByCategory(currentPage)
    }

}

$(".category-element").click(function() {
    $(".category-element").removeClass("category-active");
    $(this).addClass("category-active");
    $("#category-title").text($(this).text());
    $("#breadcrumb-current").text($(this).text())
    document.title = $(this).text() + " - Nét Việt"
    changeCategoryName($(this).attr("data-categoryName"))
})