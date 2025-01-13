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
