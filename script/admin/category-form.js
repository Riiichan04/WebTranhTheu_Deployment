function changeFormOnCategory(btn) {
    const formWrapper = document.getElementById('formWrapper');
    switch (btn) {
        case 'addCategoryBtn':
            formWrapper.innerHTML = `<iframe src="category-form/add-category-form.html" class="w-100 h-100" id="addIframe"></iframe>`;
            break;
        case 'readAndEditUserBtn':
            formWrapper.innerHTML = `<iframe src="category-form/read-edit-category-form.html" class="w-100 h-100" id="readAndEditIframe"></iframe>`;
            break;
        case 'deleteBtn':
            formWrapper.innerHTML = `<iframe src="category-form/delete-popup.html" class="w-100 h-100" id="deleteIframe"></iframe>`;
            break;
    }
}

$('#myTable').DataTable().on('draw', function () {
    $('#addCategoryBtn').click(function () {
        changeFormOnCategory(this.id);
        $('#formWrapper').removeClass('hidden');

        $('#addIframe').on('load', function () {
            const iframeDoc = $(this).contents();

            // Gán sự kiện vào phần tử bên trong iframe
            iframeDoc.find('#cancelBtn').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });

            iframeDoc.find('#overlay').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });
        });
    });

    $('.btn-read-edit').click(function () {
        changeFormOnCategory('readAndEditUserBtn');
        $('#formWrapper').removeClass('hidden');

        $('#readAndEditIframe').on('load', function () {
            const iframeDoc = $(this).contents();

            // Gán sự kiện vào phần tử bên trong iframe
            iframeDoc.find('#cancelBtn').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });

            iframeDoc.find('#overlay').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });
        });

    });

    $('.btn-delete').click(function () {
        changeFormOnCategory('deleteBtn');
        $('#formWrapper').removeClass('hidden');

        $('#deleteIframe').on('load', function () {
            const iframeDoc = $(this).contents();

            // Gán sự kiện vào phần tử bên trong iframe
            iframeDoc.find('#cancelBtn').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });

            iframeDoc.find('#overlay').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });
        });

    });

});
