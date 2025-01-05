$(document).ready(function () {
    $('#myTable').DataTable( {
        destroy: true,
        scrollY: "470px",
        ajax: {
            url: '/admin/topic-management/get-topic',
            dataSrc: function (json) {
                for (var i = 0; i < json.length; i++) {
                    var timestamp = json[i].createdAt;

                    // Sử dụng Intl.DateTimeFormat để định dạng ngày theo định dạng "DD-MM-YYYY"
                    if (timestamp && !isNaN(Date.parse(timestamp))) {
                        var date = new Date(timestamp);
                        var formattedDate = new Intl.DateTimeFormat('en-GB').format(date); // 'en-GB' để định dạng "DD/MM/YYYY"
                        json[i].createdAt = formattedDate;
                    } else {
                        json[i].createdAt = ''; // Nếu không phải là ngày hợp lệ, để trống
                    }

                    // xử lý trạng thaí chủ đề
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
            {data: 'name'}, // Tên danh mục
            {data: 'quantity'}, // Số lượng
            {data: 'numProductBought'}, // Số sản phẩm đã bán
            {data: 'createdAt'}, // Ngày tạo
            {data: 'status'}, // Ngày tạo
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

    $('#addTopicBtn').on("click", function(event) {
        event.preventDefault();
        const url = "/admin/topic-management/add-topic";
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
    });

    $('.btn-read-edit').on("click", function(event) {
        event.preventDefault();
        const url = "/admin/topic-management/update-topic";
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

                $('#myTopicEditTable').DataTable().columns.adjust();

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
        const url = "/admin/topic-management/delete-topic";
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

