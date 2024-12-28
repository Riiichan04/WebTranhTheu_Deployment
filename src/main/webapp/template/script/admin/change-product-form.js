// Gắn sự kiện click cho formWrapper
$('#formWrapper').on('click', function (event) {
    hiddenOverlay() // Tắt overlay
});

$('#addProductBtn').on("click", function(event) {
    event.preventDefault();
    const url = "product-form/add-product-form.jsp"
    $.ajax({
        url: url,
        type: "GET",
        success: function (data) {
            openOverlay();
            $("#formWrapper").html(data);

            // Ngăn sự kiện click trong form không lan lên formWrapper
            $('form').on('click', function (event) {
                event.stopPropagation();
            });

            $('#formContainer').css({
                'width': '600px',
                'max-height': '90vh',
                'z-index': '2',
                'overflow': 'auto',
            })
            $('#cancelBtn').click(function () {
                hiddenOverlay();
            });
        },
        error: function () {
            alert("Có lỗi xảy ra khi tải nội dung.");
        }
    });
});

$('.btn-read-edit').on("click", function(event) {
    event.preventDefault();
    const url = "product-form/read-edit-product-form.jsp"
    $.ajax({
        url: url,
        type: "GET",
        success: function (data) {
            openOverlay();
            $('#formWrapper').html(data);

            // Ngăn sự kiện click trong form không lan lên formWrapper
            $('form').on('click', function (event) {
                event.stopPropagation();
            });

            $('#formContainer').css({
                'width': '600px',
                'max-height': '90vh',
                'z-index': '2',
                'overflow': 'auto',
            });

            $('#myProductEditTable').DataTable().columns.adjust();

            // Xử lý nút hủy
            $('#cancelBtn').on('click', function () {
                hiddenOverlay();
            })
        },
        error: function () {
            alert("Có lỗi xảy ra khi tải nội dung.");
        }
    });
});

$('.btn-delete').on("click", function(event) {
    event.preventDefault();
    const url = "product-form/delete-popup.jsp"
    $.ajax({
        url: url,
        type: "GET",
        success: function (data) {
            openOverlay();
            $('#formWrapper').html(data);

            // Ngăn sự kiện click trong form không lan lên formWrapper
            $('form').on('click', function (event) {
                event.stopPropagation();
            });

            $('#formContainer').css({
                'width': '500px',
                'max-height': '90vh',
                'z-index': '2',
            })
            $('#cancelBtn').click(function () {
                hiddenOverlay();
            });
        },
        error: function () {
            alert("Có lỗi xảy ra khi tải nội dung.");
        }
    });
})

function hiddenOverlay() {
    $('#formWrapper').css({
        'display': 'none',
    });
}

function openOverlay() {
    $('#formWrapper').css({
        'display': 'flex',
        'justify-content': 'center',
        'align-items': 'center',
    });
}
