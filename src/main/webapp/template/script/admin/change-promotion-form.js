$(document).ready(function () {
    $('#myTable').DataTable( {
        destroy: true,
        scrollY: "470px",
        ajax: {
            url: '/admin/promotion-management/get-promotion',
            dataSrc: function (json) {
                for (var i = 0; i < json.length; i++) {
                    var startTime = json[i].startTime;

                    // Sử dụng Intl.DateTimeFormat để định dạng ngày theo định dạng "DD-MM-YYYY"
                    if (startTime && !isNaN(Date.parse(startTime))) {
                        var date = new Date(startTime);
                        var formattedDate = new Intl.DateTimeFormat('en-GB').format(date); // 'en-GB' để định dạng "DD/MM/YYYY"
                        json[i].startTime = formattedDate;
                    } else {
                        json[i].startTime = ''; // Nếu không phải là ngày hợp lệ, để trống
                    }

                    var endTime = json[i].endTime;

                    // Sử dụng Intl.DateTimeFormat để định dạng ngày theo định dạng "DD-MM-YYYY"
                    if (endTime && !isNaN(Date.parse(endTime))) {
                        var date = new Date(endTime);
                        var formattedDate = new Intl.DateTimeFormat('en-GB').format(date); // 'en-GB' để định dạng "DD/MM/YYYY"
                        json[i].endTime = formattedDate;
                    } else {
                        json[i].endTime = ''; // Nếu không phải là ngày hợp lệ, để trống
                    }

                    // xử lý tình trạng đơn hàng
                    var status = json[i].status;
                    if(status) {
                        switch (status) {
                            case 0:
                                json[i].status = "Vô hiệu hóa";
                                break;
                            case 1:
                                json[i].status = "Đang hoạt động";
                                break;
                            default: json[i].status = "";
                        }
                    } else {
                        json[i].status = "";
                    }
                }
                return json;
            }
        },
        columnDefs: [
            {
                targets: 0, // Cột STT
                render: function (data, type, row, meta) {
                    return meta.row + 1; // Tự động tăng STT
                }
            },
            {
                targets: 6, // Cột hành động
                render: function (data, type, row) {
                    return `
                        <button class="btn-read-edit" data-id="${row.id}">Xem và Chỉnh Sửa</button>
                        <button class="btn-delete" data-id="${row.id}">Tắt</button>
                    `;
                }
            }
        ],
        columns: [
            {data: null}, // Cột STT
            {data: 'name'},
            {data: 'startTime'},
            {data: 'endTime'},
            {data: 'countProduct'},
            {data: 'status'},
            {data: null} // Cột hành động
        ]
    }); // Khởi tạo DataTable
    $('.dt-search label').text("Tìm kiếm: ").css("margin-right", "10px");
    $('.dt-length label').text("Số lượng hiển thị mỗi trang").css("margin-left", "10px");
    $('.dt-info').hide()
    $('.dt-search input').css("width", "300px");
    $('table.dataTable th.dt-type-numeric').css("text-align", "center");

    // Gắn sự kiện click cho formWrapper
    $('#formWrapper').on('click', function (event) {
        hiddenOverlay() // Tắt overlay
    });

    $('#addPromotionBtn').on("click", function(event) {
        event.preventDefault();
        const url = "/admin/promotion-management/add-promotion";
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
                    'width': '650px',
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
        const url = "/admin/promotion-management/update-promotion";
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
                    'width': '650px',
                    'max-height': '90vh',
                    'z-index': '2',
                    'overflow': 'auto',
                });

                $('#myPromotionEditTable').DataTable().columns.adjust();

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
        const url = "/admin/promotion-management/delete-promotion";
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
});

