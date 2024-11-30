$(document).ready(function () {
    $('#myTable').DataTable( {
        destroy: true,
        scrollY: "200px"
    }); // Khởi tạo DataTable
    $('.dt-search label').text("Tìm kiếm: ");
    $('.dt-search label').css("margin-right", "10px");
    $('.dt-length label').text("Số lượng hiển thị mỗi trang");
    $('.dt-length label').css("margin-left", "10px");
    $('.dt-info').css("display", "none");
    $('.dt-search input').css("width", "300px");
    $('table.dataTable th.dt-type-numeric').css("text-align", "center");
});

$('#editBtn').click(function () {
    window.scrollTo({ top: 0, behavior: 'smooth' });
    $('#title').text('Chỉnh sửa giảm giá')
    $('#containerEditBtn').html(`<button class="style-update-btn" id="editBtn" type="submit">Cập nhật</button>`);
    $('#containerCancelBtn').html(`<button type="button" id="cancelEditBtn" class="style-cancel-btn">Hủy</button>`)
    $('#cancelEditBtn').click(function () {
        location.reload();
    });

    $('#nameDiscount').prop('disabled', false);

    $('#description').prop('disabled', false);
    
    $('.percent-discount').prop('disabled', false);
    
    $('.amount-limit').prop('disabled', false);

    $('#startDateDiscount').prop('disabled', false);
    
    $('#endDateDiscount').prop('disabled', false);
    
    $('.edit-hidden').removeClass('d-none');
});