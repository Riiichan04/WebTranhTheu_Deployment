const MAX_VALUE = 5;
const MIN_VALUE = 1;
let total_price
const formatter = new Intl.NumberFormat('vi-VN', {
    style: 'currency',
    currency: 'VND',
});

//sum price for pay
function calculateTotal() {
    total_price = 0;
    $(".product-checkbox").each(function () {
        let amount = 0;
        let priceEach = 0;
        $(this).change(function () {
            if ($(this).is(':checked')) {
                let cart_item = $(this).parents(".cart-item")
                const amountElement = cart_item.find(".product-detail__amount").prop("innerText")
                const priceEachElement = cart_item.find(".product-detail__price").prop("innerText")
                amount = parseInt(amountElement)
                priceEach = parseInt(priceEachElement.replace(/\D/g, ''), 10)
                console.log(amount)
                console.log(priceEach)
                total_price = total_price + (amount * priceEach);
                console.log(total_price)
                $("#total-price").text(formatter.format(total_price + ""))
            } else {
                total_price = total_price - (amount * priceEach);
                console.log(total_price)
                $("#total-price").text(formatter.format(total_price + ""))
            }
        })
    })
}

calculateTotal();


$(".product-detail__price").each(function () {
    const price = formatter.format($(this).prop("innerText"))
    $(this).text(price + "")
})

//Choose all
$("#checkAll").change(function () {
    if ($(this).is(':checked')) {
        $(".product-checkbox").prop('checked', true);
        total_price = 0;
        $(".product-checkbox").each(function () {
            let amount = 0;
            let priceEach = 0;
            let cart_item = $(this).parents(".cart-item")
            const amountElement = cart_item.find(".product-detail__amount").prop("innerText")
            const priceEachElement = cart_item.find(".product-detail__price").prop("innerText")
            amount = parseInt(amountElement)
            priceEach = parseInt(priceEachElement.replace(/\D/g, ''), 10)
            total_price = total_price + (amount * priceEach);
            console.log(total_price)
            $("#total-price").text(formatter.format(total_price + ""))
        })
    } else {
        $(".product-checkbox").prop('checked', false)
        total_price=0;
        $("#total-price").text(formatter.format(total_price+ ""))
    }
})

// add amount
$(".product-detail__add-amount").click(function () {
    let cart_item = $(this).parents(".cart-item")
    let amountElement = cart_item.find(".product-detail__amount")
    let value = parseInt(amountElement.prop("innerText"))
    value++
    if (value === MAX_VALUE) {
        $(this).attr("disabled", true);
    }
    $("#product-detail__remove-amount").attr("disabled", false);
    amountElement.text(value + "")
})


//remove amount
$(".product-detail__remove-amount").click(function () {
    let cart_item = $(this).parents(".cart-item")
    let amountElement = cart_item.find(".product-detail__amount")
    let value = parseInt(amountElement.prop("innerText"))
    value--
    if (value === MIN_VALUE) {
        $(this).attr("disabled", true);
    }
    cart_item.find(".product-detail__add-amount").attr("disabled", false);
    amountElement.text(value + "")
})
// xóa sản phẩm khỏi giỏ hàng.
$(".bi-trash").click(function (){
    $(this).parents(".cart-item").remove()
})
// chi tiết giảm giá
$(".discount-detail").click(function (){
    $(".discount-detail-info").addClass("show")
})
// bỏ xem giảm giá
$(".cancel-discount").click(function (){
    $(".discount-detail-info").removeClass("show")
})
// Thêm giảm giá.
$('.discount-more').click(function (){
    $(".discount-more-info").addClass("show")
})

$(".cancel-more").click(function (){
    $(".discount-more-info").removeClass("show")
})

