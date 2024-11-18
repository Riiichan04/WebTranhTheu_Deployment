$('#editBtn').click(function () {
    window.scrollTo({ top: 0, behavior: 'smooth' });
    $('#title').text('Chỉnh sửa danh mục')
    $('#containerEditBtn').html(`<button class="style-update-btn" id="editBtn" type="submit">Cập nhật</button>`);
    $('#containerCancelBtn').html(`<button type="button" id="cancelEditBtn" class="style-cancel-btn">Hủy</button>`)
    $('#cancelEditBtn').click(function () {
        location.reload();
    });

    const nameCategory = $('#nameCategory');
    nameCategory.prop('disabled', false);
    nameCategory.css('color', 'black');

    $('.edit-hidden').removeClass('d-none');
});

$(document).ready(function () {
    $('#myTable').DataTable( {
        destroy: true,
        scrollY: "300px"
    }); // Khởi tạo DataTable
    $('.dt-search label').text("Tìm kiếm: ");
    $('.dt-search label').css("margin-right", "10px");
    $('.dt-length label').text("Số lượng hiển thị mỗi trang");
    $('.dt-length label').css("margin-left", "10px");
    $('.dt-info').css("display", "none");
    $('.dt-search input').css("width", "300px");
    $('table.dataTable th.dt-type-numeric').css("text-align", "center");
});