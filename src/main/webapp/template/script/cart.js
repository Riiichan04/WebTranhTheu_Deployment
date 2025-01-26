
const formatter = new Intl.NumberFormat('vi-VN', {
    style: 'currency',
    currency: 'VND',
});

//sum price for pay
// function calculateTotal() {
//     total_price = 0;
//     $(".product-checkbox").each(function () {
//         let amount = 0;
//         let priceEach = 0;
//         $(this).change(function () {
//             if ($(this).is(':checked')) {
//                 let cart_item = $(this).parents(".cart-item")
//                 const amountElement = cart_item.find(".product-detail__amount").prop("innerText")
//                 const priceEachElement = cart_item.find(".product-detail__price").prop("innerText")
//                 amount = parseInt(amountElement)
//                 priceEach = parseInt(priceEachElement.replace(/\D/g, ''), 10)
//                 console.log(amount)
//                 console.log(priceEach)
//                 total_price = total_price + (amount * priceEach);
//                 console.log(total_price)
//                 $("#total-price").text(formatter.format(total_price + ""))
//             } else {
//                 total_price = total_price - (amount * priceEach);
//                 console.log(total_price)
//                 $("#total-price").text(formatter.format(total_price + ""))
//             }
//         })
//     })
// }

// calculateTotal();


// $("#product-detail__price").each(function () {
//     const price = formatter.format($(this).prop("innerText"))
//     $(this).text(price + "")
// })

//Choose all
$("#checkAll").change(function () {
    if ($(this).is(':checked')) {
        $(".product-checkbox").prop('checked', true);
        updateTotalPrice()
    } else {
        $(".product-checkbox").prop('checked', false)
        updateTotalPrice()
    }
})
// $(".price-change").click(function (){
//     $(".select-area").addClass("d-none")
//     let priceSelected= $(this).parents(".price-selected")
//     priceSelected.children(".select-area").removeClass("d-none")
// })
// xóa sản phẩm khỏi giỏ hàng.
$(".bi-trash").click(function (){
    removeProduct($(this).parents(".cart-item"))
})
// chi tiết giảm giá
$(".discount-detail").click(function (){
    $(".discount-detail-info").addClass("show")
})
$(".cancel-more").click(function (){
    $(".discount-more-info").removeClass("show")
})

