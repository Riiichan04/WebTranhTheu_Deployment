const MAX_VALUE = 5
const MIN_VALUE = 1
let currentRating = 0

function displayRating(rating, starWidth) {
    const starPosition = Math.trunc(rating)
    const starPositionWidthRating = rating - Math.floor(rating)
    const starMaskWidth = starWidth * (1 - starPositionWidthRating) * 0.8 //Do phần star chiếm 80% element
    const starPadding = starWidth / 10
    $("#product-info__rating .product-info__star-mask").each(function (index) {
        if (index === starPosition) {
            $(this).css("width", starMaskWidth + starPadding + "px")
        }
        if (index > starPosition) {
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

$("#product-review__star .product-info__star-container").click(function () {
    const maskElement = $("#product-review__star .product-info__star-mask")
    const currentElement = $(this).index()
    if (maskElement.eq(currentElement).css("width") === "0px" && (maskElement.eq(currentElement + 1).css("width") === $(this).css("width") || currentElement === maskElement.length - 1)) {
        maskElement.css("width", "100%");
        currentRating = 0
    } else {
        currentRating = currentElement + 1
        for (let i = 0; i <= currentElement; i++) {
            maskElement.eq(i).css("width", "0");
        }
        for (let i = currentElement + 1; i < maskElement.length; i++) {
            maskElement.eq(i).css("width", "100%");
        }
    }
})

$("#send-comment").click(function () {
    const commentText = $("#product-review--comment").val()
    const countComment = $("#count-comment")
    const totalStar = $("#current-star-rating")

    const countTotalComment = parseInt(countComment.text()) + 1
    let newCurrentStarRating = (parseInt(totalStar.text()) * (countTotalComment - 1) + currentRating) / countTotalComment
    newCurrentStarRating = `${newCurrentStarRating}`.length === 1 ? newCurrentStarRating + ".0" : newCurrentStarRating
    if (currentRating === 0 || commentText === "") return

    const commentElement = document.createElement("div")
    commentElement.className = "row product-review__comment-component mt-4_5"
    commentElement.innerHTML =
        `
            <div class="col-3 text-center">
                <h5>Admin</h5>
                <p>22/11/2024</p>
                <div class="row">
                    <div class="col-2"></div>
                    <div class="col d-flex justify-content-center comment-rating">
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                            <div class="product-info__star-mask"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                        <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                            <div class="product-info__star-mask"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                            <div class="product-info__star-mask"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star sample_half" style="color: #4d6a55;"></i>
                            <div class="product-info__star-mask"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                        </div>
                        <div class="col-2 product-info__star-container   px-0">
                            <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                            <div class="product-info__star-mask" style="width: 100%"></div>
                            <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                        </div>
                    </div>
                    <div class="col-2"></div>
                </div>
            </div>
            <div class="col-8">
                <p class="" style="white-space: pre-line">
                    ${commentText}
                </p>
            </div>
        `
    const listMask = commentElement.querySelectorAll(".product-info__star-mask")
    for (let i = 0; i < currentRating; i++) {
        listMask[i].style.width = "0";
    }
    for (let i = currentRating + 1; i < listMask.length; i++) {
        listMask[i].style.width = "100%";
    }

    countComment.text(countTotalComment)
    totalStar.text(newCurrentStarRating)
    $("#comment-container").prepend(commentElement)
    $(this).attr("disabled", true)
})

displayRating(4.0, $(".product-info__star-container").width())