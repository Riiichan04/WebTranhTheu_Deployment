$('#editBtn').on("click", function () {
    const categoryId = $(this).data("id");
    $('#title').text('Chỉnh sửa danh mục');
    $('.read').addClass('d-none');
    $('#cancelEditBtn').click(function () {
        $('#read-edit-category-form')[0].reset();  // Reset form về trạng thái ban đầu
        $('#title').text('Xem danh mục');
        $('.read').removeClass('d-none');
        $('#name-category').prop('disabled', true);
        $('.status-category').prop('disabled', true);
        $('.edit-hidden').addClass('d-none');
    });

    $('#name-category').prop('disabled', false);

    $('.status-category').prop('disabled', false);

    $('.edit-hidden').removeClass('d-none');
});

// Khởi tạo DataTable
if ($.fn.DataTable.isDataTable('#myCategoryEditTable')) {
    $('#myCategoryEditTable').DataTable().destroy();
}

$('#myCategoryEditTable').DataTable({
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