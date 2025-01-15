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


// Nút chia sẻ (copy vào clipboard)
$("#product-detail__share-btn i").click(function () {
    const msg = $("#product-detail__share-btn .notification-message")
    // Hiển thị message
    msg.removeClass("d-none")
    msg.addClass("d-block")
    navigator.clipboard.writeText(window.location.href) //Viết url hiện tại vào clipboard
    setTimeout(() => {  // Ẩn message
        msg.removeClass("d-block")
        msg.addClass("d-none")
    }, 1000)
})

//Nút thêm vào danh sách yêu thích
$("#product-detail__loved-btn i").click(function () {
    const msg = $("#product-detail__loved-btn .notification-message")
    //Thay đổi trạng thái icon và nội dung message
    if ($(this).hasClass("fa-regular")) {
        $(this).removeClass("fa-regular")
        $(this).addClass("fa-solid")
        msg.text("Đã thêm vào mục Yêu thích")
    } else {
        $(this).removeClass("fa-solid")
        $(this).addClass("fa-regular")
        msg.text("Đã gỡ khỏi mục Yêu thích")
    }

    // Hiển thị message
    msg.removeClass("d-none")
    msg.addClass("d-block")
    setTimeout(() => { // Ẩn message
        msg.removeClass("d-block")
        msg.addClass("d-none")
    }, 1000)
})

// Tăng số lươợng sản phẩm mua
$("#product-detail__add-amount").click(function () {
    const amountElement = $("#product-detail__amount")
    let value = parseInt(amountElement.prop("innerText"))
    value++
    //Số lượng sản phẩm mua không vượt quá MAX_VALUE
    if (value === MAX_VALUE) {
        $(this).attr("disabled", true);
    }
    //Gỡ disable cho nút giảm
    $("#product-detail__remove-amount").attr("disabled", false);
    amountElement.text(value + "")
})

// Giảm số lươợng sản phẩm mua
$("#product-detail__remove-amount").click(function () {
    const amountElement = $("#product-detail__amount")
    let value = parseInt(amountElement.prop("innerText"))
    value--
    //Số lượng sản phẩm mua không ít hơn MIN_VALUE
    if (value === MIN_VALUE) {
        $(this).attr("disabled", true);
    }
    //Gỡ disable cho nút tăng
    $("#product-detail__add-amount").attr("disabled", false);
    amountElement.text(value + "")
})

// Nút mua ngay -> Mở trang thanh toán
$("#purchase-btn").click(function () {
    window.location = "../page/purchase.html"
})

// Nút thêm vào giỏ
$("#add-to-cart-btn").click(function () {
    const cartBadge = $("#cart-badge")
    cartBadge.removeClass("d-none")
    let cartValue = parseInt(cartBadge.prop("innerText"))
    cartValue += parseInt($("#product-detail__amount").prop("innerText"))
    cartBadge.text(cartValue)
    cartBadge.css("display", "flex");
})

// Click vào số sao ở mục đánh giá để bình luận số sao
$("#product-review__star .product-info__star-container").click(function () {
    const maskElement = $("#product-review__star .product-info__star-mask") //Lấy list mask cucomment
    const currentElement = $(this).index()  //Lấy số sao muốn đánh giá
    //Xử lý trường hợp click lại số sao vừa đánh giá để clear số sao đánh giá
    if (maskElement.eq(currentElement).css("width") === "0px" && (maskElement.eq(currentElement + 1).css("width") === $(this).css("width") || currentElement === maskElement.length - 1)) {
        maskElement.css("width", "100%");
        currentRating = 0
    } else {
        //Tắt mask từ cho số sao cần hiển thị
        currentRating = currentElement + 1
        for (let i = 0; i <= currentElement; i++) {
            maskElement.eq(i).css("width", "0");
        }
        //Bật mask cho số sao còn lại
        for (let i = currentElement + 1; i < maskElement.length; i++) {
            maskElement.eq(i).css("width", "100%");
        }
    }
})

// Nút gửi bình luận
$("#send-comment").click(function () {
    const commentText = $("#product-review--comment").val()
    const countComment = $("#count-comment")
    const totalStar = $("#current-star-rating")

    //Tính toán tổng đánh giá mới cho sản phẩm và tăng ố lượng bình luận của sản phẩm
    const countTotalComment = parseInt(countComment.text()) + 1
    let newCurrentStarRating = (parseInt(totalStar.text()) * (countTotalComment - 1) + currentRating) / countTotalComment
    newCurrentStarRating = `${newCurrentStarRating}`.length === 1 ? newCurrentStarRating + ".0" : newCurrentStarRating
    if (currentRating === 0 || commentText === "") return

    //Tạo element sản phẩm (Sẽ chuyển vào DAO)
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
    //Cập nhật số sao của bình luận
    const listMask = commentElement.querySelectorAll(".product-info__star-mask")
    for (let i = 0; i < currentRating; i++) {
        listMask[i].style.width = "0";
    }
    for (let i = currentRating; i < listMask.length; i++) {
        listMask[i].style.width = "100%";
    }

    //Thêm nội dung, hiển thị elememt bình luận và cập nhật các giá trị cần thiết
    countComment.text(countTotalComment)
    totalStar.text(newCurrentStarRating)
    $("#comment-container").prepend(commentElement)
    $(this).attr("disabled", true)
})

// Click vào sản phẩm khác sẽ mở cửa sổ sản phẩm khác
$(".other-product__card").click(function () {
    window.open("product.html").focus();
})

$("#send-comment").click(function (e) {
    e.preventDefault()
    if ($("#comment-content").val() === "" && currentRating === 0) {
        //Thông báo nhập chưa đủ nội dung
    } else {
        $.ajax({
            url: '/upload-review',
            type: 'POST',
            data: {
                account: $("#session-account").val(), //Cần một trường input:hidden để chứa trên jsp
                rating: currentRating,
                content: $("#comment-content").val()
            },
            success: (response) => {
                if (response.result) {
                    //Thông báo thành công
                } else {
                    //Thông báo thất bại
                }
            },
            error: (response) => {
                //Thông báo lỗi server
            }
        })
    }
})

//Dùng để lấy các sản phẩm khác
$.ajax({
    url: null,
    type: 'GET',
    data: {
        id: null, //Tạm (Sẽ d8ưa lên jsp)
        topic: null //Tạm (Sẽ đưa lên jsp)
    },
    success: (response) => {
        //Hiển thị các sản phẩm khác
    },
    error: (response) => {
        //Không tìm thấy các sản phẩm tương tự với sản phẩm này
    }
})

let reviewAmount = 1
let currentReviewOffset = 0
let reviewLimit

function getReviewList(amount) {
    if (currentReviewOffset !== -1) {
        $.ajax({
            url: '/get-product-review',
            type: 'GET',
            data: {
                id: new URL(window.location.href).searchParams.get('id'),
                offset: currentReviewOffset,
                amount: amount,
                limit: reviewLimit
            },
            success: (response) => {
                console.log(response)
                response = $.parseJSON(response)
                console.log(response)
                //Hiển thị bình luận
                if (response.result) {
                    reviewLimit = response.limit ? response.limit : reviewLimit
                    for (let review of response.reviewData) {
                        $("#comment-container").append(createReviewElement(review))
                    }
                    currentReviewOffset = response.currentOffset
                } else offset = -1
                console.log(currentReviewOffset)
                console.log(reviewLimit)
                if (currentReviewOffset > reviewLimit || currentReviewOffset === -1) {
                    $("#comment-container").append(`<p class="d-flex justify-content-center row text-center">Đã tải hết bình luận</p>`)
                    $("#load-more-review").attr("disabled", true)
                    $("#load-more-review").addClass("d-none")
                }
            },
            error: (response) => {
                $("#comment-container").append(`<p class="d-flex justify-content-center row text-center">Có lỗi khi tải bình luận của bạn</p>`)
            }
        })
    }
}

function createReviewElement(review) {
    const date = new Date(review.reviewTime)
    const formattedDate = new Intl.DateTimeFormat('en-GB').format(date)

    return `
        <div class="row product-review__comment-component mt-4_5">
            <div class="col-3 text-center">
                <h5>${review.username}</h5>
                <p>${formattedDate}</p>
                <div class="row">
                    <div class="col-2"></div>
                    <div class="col d-flex justify-content-center comment-rating">
                        ${createReviewStar(review.rating)}
                    </div>
                    <div class="col-2"></div>
                </div>
            </div>
            <div class="col-8">
                <p class="" style="white-space: pre-line">
                    ${review.content}
                </p>
            </div>
        </div>
        `
}

//Xử lý sau
function createReviewStar(rating) {
    rating = Math.trunc(rating) //Lấy phần nguyên nếu như rating có dạng x.0
    if (rating > 5) return
    const filledStar = `
    <div class="col-2 product-info__star-container   px-0">
         <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
         <div class="product-info__star-mask" ></div>
         <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
    </div>
    `
    const unfilledStar = `
     <div class="col-2 product-info__star-container   px-0">
         <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
         <div class="product-info__star-mask" style="width: 100%"></div>
         <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
    </div>
    `

    let result = ""
    for (let i = 0; i < rating; i++) {
        result += filledStar
    }
    for (let i = rating; i < 5; i++) {
        result += unfilledStar
    }
    return result
}


$("#load-more-review").click(function () {
    if (currentReviewOffset !== -1) getReviewList(reviewAmount)
})


//Ajax cho phần chuyển đổi thông tin sản phẩm
const urlParams = new URLSearchParams(window.location.search);
let currentWidth = urlParams.get("width")
let currentHeight = urlParams.get("height")
let currentPrice = 0.0

function getPrice(width, height) {
    const productId = urlParams.get("id")
    $.ajax({
        url: '/get-product-price',
        method: 'GET',
        data: {
            width: width,
            height: height,
            id: productId
        },
        success: function (response) {
            response = $.parseJSON(response)
            if (response.result) {
                if (currentWidth !== response.width && currentHeight !== response.height) {
                    const url = new URL(window.location.href)
                    url.searchParams.set("width", response.width)
                    url.searchParams.set("height", response.height)
                    window.history.pushState({}, '', url)
                }
                $("#product-detail__available--value").text(response.available)
                $("#product-details__price").text(response.price)
                currentPrice = response.price
                currentWidth = response.width
                currentHeight = response.height
            }
        },
    })
}


$(".switch-size-btn").click(function () {
    let inputWidth = $(this).data("width")
    let inputHeight = $(this).data("height")
    getPrice(inputWidth, inputHeight)
})

getReviewList(reviewAmount)
getPrice(currentWidth, currentHeight)
