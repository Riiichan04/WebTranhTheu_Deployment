$(document).ready(function () {
    // Kiểm tra và hủy bảng nếu đã khởi tạo
    if ($.fn.DataTable.isDataTable('#myProductEditTable')) {
        $('#myProductEditTable').DataTable().destroy(); // Hủy bảng
        $('#myProductEditTable').empty(); // Làm sạch nội dung bảng (nếu cần thay đổi cấu trúc cột)
    }

    // Khởi tạo lại DataTable
    var table = $('#myProductEditTable').DataTable({
        scrollY: "300px",
        scrollX: "100%",
        initComplete: function () {
            // Tùy chỉnh giao diện
            $('.dt-search label').text("Tìm kiếm: ").css("margin-right", "10px");
            $('.dt-length label').text("Số lượng hiển thị mỗi trang").css("margin-left", "10px");
            $('.dt-info').css("display", "none");
            $('.dt-search input').css("width", "300px");
            $('table.dataTable th.dt-type-numeric').css("text-align", "center");
        }
    });

    // Sự kiện cho nút Edit
    $('#editBtn').click(function () {
        // Cập nhật giao diện
        $('#title').text('Chỉnh sửa sản phẩm');
        $('.read').addClass('d-none');
        $('#title-img').text('Xóa hình ảnh');
        $('#code_product').prop('disabled', false);
        $('#nameProduct').prop('disabled', false);
        $('#descriptionProduct').prop('disabled', false);
        $('.price').prop('disabled', false);
        $('.quantityProduct').prop('disabled', false);
        $('.widthProduct').prop('disabled', false);
        $('.heightProduct').prop('disabled', false);
        $('.material').prop('disabled', false);
        $('#status').prop('disabled', false);
        $('#provider').prop('disabled', false);
        $('#type').prop('disabled', false);
        $('.edit-hidden').removeClass('d-none');
        // Lặp qua tất cả các hàng của DataTable và hiển thị phần tử 'edit-hidden'
        table.rows().every(function () {
            var row = this.node();
            $(row).find('.edit-hidden').removeClass('d-none');
        });
        //vẽ lại giao diện cột
        table.columns.adjust().draw();
    });

    // Sự kiện cho nút Cancel
    $('#cancelEditBtn').click(function () {
        $('#read-edit-category-form')[0].reset(); // Reset form
        $('#title').text('Xem sản phẩm');
        $('.read').removeClass('d-none');
        $('#title-img').text('Hình ảnh');
        $('#code_product').prop('disabled', true);
        $('#nameProduct').prop('disabled', true);
        $('#descriptionProduct').prop('disabled', true);
        $('#price').prop('disabled', true);
        $('#quantityProduct').prop('disabled', true);
        $('#widthProduct').prop('disabled', true);
        $('#heightProduct').prop('disabled', true);
        $('.material').prop('disabled', true);
        $('#status').prop('disabled', true);
        $('#provider').prop('disabled', true);
        $('#type').prop('disabled', true);
        $('.edit-hidden').addClass('d-none');
        // Lặp qua tất cả các hàng của DataTable và hiển thị phần tử 'edit-hidden'
        table.rows().every(function () {
            var row = this.node();
            $(row).find('.edit-hidden').addClass('d-none');
        });
        //vẽ lại giao diện cột
        table.columns.adjust().draw();
    });

    function addProductPrice() {
        const productRow = document.querySelector('.product-price-row');
        const newRow = productRow.cloneNode(true);
        newRow.querySelectorAll('input').forEach(input => input.value = '');
        document.getElementById('product_price').appendChild(newRow);
    }

    function removeProductPrice(button) {
        const row = button.parentElement.parentElement;
        if (document.querySelectorAll('.product-price-row').length > 1) {
            row.remove();
        } else {
            alert("Phải có ít nhất một loại sản phẩm!");
        }
    }

});


