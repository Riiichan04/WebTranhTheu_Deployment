$(document).ready(function () {
    const table = $('#myTable').DataTable({
        destroy: true,
        scrollY: "470px",
        ajax: {
            url: '/admin/order-management/get-order',
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

                    // xử lý tình trạng đơn hàng
                    var statusOrder = json[i].orderStatus;
                    if (statusOrder) {
                        switch (statusOrder) {
                            case 1:
                                json[i].orderStatus = "Chờ xác nhận";
                                break;
                            case 2:
                                json[i].orderStatus = "Chờ lấy hàng";
                                break;
                            case 3:
                                json[i].orderStatus = "Chờ giao hàng";
                                break;
                            case 4:
                                json[i].orderStatus = "Đã giao";
                                break;
                            case 5:
                                json[i].orderStatus = "Đã nhận hàng";
                                break;
                            case 6:
                                json[i].orderStatus = "Đơn yêu cầu hoàn trả";
                                break;
                            default:
                                json[i].orderStatus = "";
                        }
                    } else {
                        json[i].orderStatus = "";
                    }

                    // xử lý tình trạng thanh toán
                    var statusPayment = json[i].paymentStatus;
                    if (statusPayment) {
                        switch (statusPayment) {
                            case 0:
                                json[i].paymentStatus = "Chưa trả tiền";
                                break;
                            case 1:
                                json[i].paymentStatus = "Đã trả tiền";
                                break;
                            default:
                                json[i].paymentStatus = "";
                        }
                    } else {
                        json[i].paymentStatus = "";
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
                targets: 7, // Cột hành động
                render: function (data, type, row) {
                    return `
                        <button class="btn-read-edit" data-id="${row.id}">Xem và Chỉnh Sửa</button>
                        <!--<button class="btn-delete" data-id="${row.id}">Tắt</button>-->
                    `;
                }
            }
        ],
        columns: [
            {data: null}, // Cột STT
            {data: 'name'},
            {data: 'username'},
            {data: 'totalPrice'},
            {data: 'createdAt'},
            {data: 'orderStatus'},
            {data: 'paymentStatus'},
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

    // $('#addOrderBtn').on("click", function (event) {
    //     event.preventDefault();
    //     const url = "/admin/order-management/add-order-form";
    //     $.ajax({
    //         url: url,
    //         type: "GET",
    //         success: function (data) {
    //             openOverlay();
    //             $("#formWrapper").html(data);
    //
    //             // Ngăn sự kiện click trong form không lan lên formWrapper
    //             $('form').on('click', function (event) {
    //                 event.stopPropagation();
    //             });
    //
    //             $('#formContainer').css({
    //                 'width': '700px',
    //                 'max-height': '90vh',
    //                 'z-index': '2',
    //                 'overflow': 'auto',
    //             });
    //
    //             $(document).on('change', '.product-select', function() {
    //                 event.preventDefault();
    //                 const productId = $(this).val();
    //
    //                 // Lưu giá trị của 'this' vào một biến để sử dụng trong callback
    //                 var $selectElement = $(this);
    //
    //                 $.ajax({
    //                     url: "/admin/order-management/add-order-form/get-product-price",
    //                     type: "GET",
    //                     data: {productId: productId},
    //                     success: function (data) {
    //                         var selectHtml = '<select class="style-select product-price-select">';
    //
    //                         // Lặp qua mảng data và tạo các <option>
    //                         data.forEach(function(item) {
    //                             selectHtml += `<option value="${item.id}" ${item.available>0 ? '' : 'disabled'}>${item.width}x${item.height} - Tồn kho: ${item.available}</option>`;
    //                         });
    //
    //                         selectHtml += '</select>'; // Đóng thẻ select
    //
    //                         // Chèn HTML vào phần tử .product-price của phần tử cha
    //                         $selectElement.parent().parent().find('.product-price').html(selectHtml);
    //                     },
    //                     error: function () {
    //                         alert("Tải nội dung thất bại");
    //                         hiddenOverlay();
    //                     }
    //                 });
    //             });
    //
    //             $('#cancelBtn').click(function () {
    //                 hiddenOverlay();
    //             });
    //
    //             $('#add-order-form').on('submit', function (event) {
    //                 event.preventDefault(); // Ngăn chặn reload trang
    //
    //                 // Gửi dữ liệu qua AJAX
    //                 $.ajax({
    //                     url: '/admin/order-management/add-order',
    //                     type: 'POST',
    //                     data: {
    //                         userId: $('#user').val(),
    //                         productSelected: $('.product-price-select').val(),
    //                         amountProduct: $('.amount-product-input').val(),
    //                         discountId: $('#discount').val(),
    //                         addressShipping: $("#address-shipping").val(),
    //                         deliveredAt: $("#deliver-date").val(),
    //                         statusOrder: $("#status-order").val(),
    //                         reasonCancelOrder: $("#reason-cancel-order").val(),
    //                         method: $("#method").val(),
    //                         statusPay: $("#status-payment").val(),
    //                     },
    //                     success: function (response) {
    //                         if (response.success) {
    //                             alert('Thêm danh mục thành công!');
    //                             $('#add-order-form')[0].reset(); // Reset form
    //                             table.ajax.reload();
    //                             hiddenOverlay();
    //                         } else {
    //                             alert('Lỗi khi thêm danh mục!');
    //                         }
    //                     },
    //                     error: function () {
    //                         alert('Lỗi khi thêm danh mục!');
    //                     }
    //                 });
    //             });
    //         },
    //         error: function () {
    //             alert("Có lỗi xảy ra khi tải nội dung.");
    //         }
    //     });
    // });

    $('.btn-read-edit').on("click", function (event) {
        event.preventDefault();
        const url = "/admin/order-management/update-order";
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

    $('.btn-delete').on("click", function (event) {
        event.preventDefault();
        const url = "/admin/order-management/delete-order";
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