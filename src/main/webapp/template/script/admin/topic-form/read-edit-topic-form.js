$('#editBtn').click(function () {
    window.scrollTo({ top: 0, behavior: 'smooth' });
    $('#title').text('Chỉnh sửa chủ đề')
    $('#containerEditBtn').html(`<button class="style-update-btn" id="editBtn" type="submit">Cập nhật</button>`);
    $('#containerCancelBtn').html(`<button type="button" id="cancelEditBtn" class="style-cancel-btn">Hủy</button>`)
    $('#cancelEditBtn').click(function () {
        location.reload();
    });

    $('#nameTopic').prop('disabled', false);

    $('.status-topic').prop('disabled', false);

    $('.edit-hidden').removeClass('d-none');
});

// Khởi tạo DataTable
if ($.fn.DataTable.isDataTable('#myTopicEditTable')) {
    $('#myTopicEditTable').DataTable().destroy();
}

$('#myTopicEditTable').DataTable({
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