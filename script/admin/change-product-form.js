function changeFormOnProduct(btn) {
    const formWrapper = document.getElementById('formWrapper');
    switch (btn) {
        case 'addProductBtn':
            formWrapper.innerHTML = `<iframe src="product-form/add-product-form.html" class="w-100 h-100" id="addIframe"></iframe>`;
            break;
        case 'readAndEditUserBtn':
            formWrapper.innerHTML = `<iframe src="product-form/read-edit-product-form.html" class="w-100 h-100" id="readAndEditIframe"></iframe>`;
            break;
        case 'deleteBtn':
            formWrapper.innerHTML = `<iframe src="product-form/delete-popup.html" class="w-100 h-100" id="deleteIframe"></iframe>`;
            break;
    }
}

$('#myTable').DataTable().on('draw', function () {
    $('#addProductBtn').click(function () {
        changeFormOnProduct(this.id);
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
        changeFormOnProduct('readAndEditUserBtn');
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
        changeFormOnProduct('deleteBtn');
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

