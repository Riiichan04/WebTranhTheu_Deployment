const MAX_VALUE = 5
const MIN_VALUE = 1

function displayRating(rating, starWidth) {
    const starPosition = Math.trunc(rating)
    const starPositionWidthRating = rating - Math.floor(rating)
    const starMaskWidth = starWidth * (1 - starPositionWidthRating)
    const starPadding = ($("#product-info__rating .product-info__star-container").width() - starWidth) / 2
    $("#product-info__rating .product-info__star-mask").each(function (index) {
        if (index === starPosition - 1) {
            $(this).css("width", starMaskWidth + starPadding + "px")
        }
        if (index > starPosition - 1) {
            $(this).css("width", "100%")
        }
    });
}

$("#shipping-location__close-popup").click(function () {
    return $("#shipping-location-container").css("display", "none");
})

$("#show-popup").click(function () {
    return $("#shipping-location-container").css("display", "block");
})

$("#product-detail__add-amount").click(function () {
    const amountElement = $("#product-detail__amount")
    let value = parseInt(amountElement.prop("innerText"))
    value++
    if (value === MAX_VALUE) {
        $(this).attr("disabled", true);
    }
    $("#product-detail__remove-amount").attr("disabled", false);
    amountElement.text(value + "")
})

$("#product-detail__remove-amount").click(function () {
    const amountElement = $("#product-detail__amount")
    let value = parseInt(amountElement.prop("innerText"))
    value--
    if (value === MIN_VALUE) {
        $(this).attr("disabled", true);
    }
    $("#product-detail__add-amount").attr("disabled", false);
    amountElement.text(value + "")
})

$("#purchase-btn").click(function () {
    window.open("purchase.html").focus();
})

$("#add-to-cart-btn").click(function () {
    const cartBadge = $("#cart-badge")
    let cartValue = parseInt(cartBadge.prop("innerText"))
    cartValue += parseInt($("#product-detail__amount").prop("innerText"))
    cartBadge.text(cartValue)
    cartBadge.css("display", "flex");
})

displayRating(3.6, $(".product-info__star-container").width())