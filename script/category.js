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

//Sẽ làm sau khi merge file data.json
// const listData = []
// const LIMIT_PRODUCT = 100
// let currentLimitProduct = 0
//
// $.getJSON("../asset/data.json", (data) => {
//     $.each(data, (index, element) => {
//         listData.push(`
//             <div class="col">
//                 <div onclick="showProductPage()" class="card p-2" style="cursor: pointer">
//                     <img src="../asset/product_image.png" class="card-img-top" alt="...">
//                     <div class="card-body px-1">
//                         <h6 class="card-title text-start pb-2">${element.title}</h6>
//                         <div class="col d-flex justify-content-start comment-rating">
//                             <div class="col-2 product-info__star-container   px-0">
//                                 <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
//                                 <div class="product-info__star-mask"></div>
//                                 <i class="fa-regular fa-star product-info__star-outline"
//                                    style="color: #4d6a55;"></i>
//                             </div>
//                             <div class="col-2 product-info__star-container   px-0">
//                                 <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
//                                 <div class="product-info__star-mask"></div>
//                                 <i class="fa-regular fa-star product-info__star-outline"
//                                    style="color: #4d6a55;"></i>
//                             </div>
//                             <div class="col-2 product-info__star-container   px-0">
//                                 <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
//                                 <div class="product-info__star-mask"></div>
//                                 <i class="fa-regular fa-star product-info__star-outline"
//                                    style="color: #4d6a55;"></i>
//                             </div>
//                             <div class="col-2 product-info__star-container   px-0">
//                                 <i class="fa-solid fa-star product-info__star sample_half"
//                                    style="color: #4d6a55;"></i>
//                                 <div class="product-info__star-mask"></div>
//                                 <i class="fa-regular fa-star product-info__star-outline"
//                                    style="color: #4d6a55;"></i>
//                             </div>
//                             <div class="col-2 product-info__star-container   px-0">
//                                 <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
//                                 <div class="product-info__star-mask" style="width: 100%"></div>
//                                 <i class="fa-regular fa-star product-info__star-outline"
//                                    style="color: #4d6a55;"></i>
//                             </div>
//                         </div>
//                         <p class="card-text text-center fw-semibold h5 mt-2" style="color: var(--sub-cta-button)">${element.price}</p>
//                     </div>
//                 </div>
//             </div>`)
//     })
//
// })
//
// function createRowProduct(rowLength) {
//     const productContainer = document.createElement("div")
//     const listProduct = createListProduct(5)
//     productContainer.className = "row mt-1"
//     for (let i = 0; i < rowLength; i++) {
//         productContainer.innerHTML += listProduct[i];
//     }
//     return productContainer
// }
//
// function createListProduct(rowLength) {
//     const result = []
//     for (let i = 0; i < rowLength; i++) {
//         const element = listData[Math.floor(Math.random() * listData.length)]
//         result.push(element)
//     }
//     return result
// }
//
// function showProductPage() {
//     window.location = "../page/product.html"
// }