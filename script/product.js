function displayRating(rating, starWidth) {
    const starPosition = Math.trunc(rating)
    const starPositionWidthRating = rating - Math.floor(rating)
    const starMaskWidth = starWidth * (1 - starPositionWidthRating)
    const starPadding = ($("#product-info__rating .product-info__star-container").width() - starWidth)/2
    $("#product-info__rating .product-info__star-mask").each(function (index) {
        if (index === starPosition -1) {
            $(this).css("width", starMaskWidth + starPadding + "px")
        }
        if (index > starPosition -1) {
            $(this).css("width", "100%")
        }
    });
}

displayRating(3.6, 31.5)