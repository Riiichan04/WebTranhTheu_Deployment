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

// Khởi tạo DataTable
if ($.fn.DataTable.isDataTable('#myProductEditTable')) {
    $('#myProductEditTable').DataTable().destroy();
}

$('#myProductEditTable').DataTable({
    scrollY: "300px",
    scrollX: "100%",
    initComplete: function() {
        // Tùy chỉnh giao diện DataTable
        $('.dt-search label').text("Tìm kiếm: ").css("margin-right", "10px");
        $('.dt-length label').text("Số lượng hiển thị mỗi trang").css("margin-left", "10px");
        $('.dt-info').css("display", "none");
        $('.dt-search input').css("width", "300px");
        $('table.dataTable th.dt-type-numeric').css("text-align", "center");
    },
});

$('#editBtn').click(function () {
    window.scrollTo({ top: 0, behavior: 'smooth' });
    $('#title').text('Chỉnh sửa sản phẩm');
    $('#title-img').text('Hình ảnh (Tick chọn để xóa)');
    $('#containerEditBtn').html(`<button class="style-update-btn" id="editBtn" type="submit">Cập nhật</button>`);
    $('#containerCancelBtn').html(`<button type="button" id="cancelEditBtn" class="style-cancel-btn">Hủy</button>`)
    $('#cancelEditBtn').click(function () {
        location.reload();
    });
    $('#code_product').prop('disabled', false);
    
    $('#nameProduct').prop('disabled', false);

    $('#descriptionProduct').prop('disabled', false);

    $('#price').prop('disabled', false);
    
    $('#quantityProduct').prop('disabled', false);
    
    $('#widthProduct').prop('disabled', false);
    
    $('#heightProduct').prop('disabled', false);
    
    $('.material').prop('disabled', false);
    
    $('#provider').prop('disabled', false);
    
    $('#policy').prop('disabled', false);
    
    $('#title-topic-product').text('Xóa chủ đề (Chọn nhiều)');
    
    $('#topic-product').prop('disabled', false);
    
    $('#titleCategory').text('Xóa danh mục');
    
    $('#category').prop('disabled', false);

    $('#status').prop('disabled', false);
    
    $('.reviewByStar').prop('disabled', false);
    
    $('.comment').prop('disabled', false);

    $('.edit-hidden').removeClass('d-none');
});