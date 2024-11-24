function changeFormOnUser(btn) {
    const formWrapper = document.getElementById('formWrapper');
    switch (btn) {
        case 'addUserBtn':
            formWrapper.innerHTML = `<iframe src="user-form/add-user-form.html" class="form-popup" id="addIframe"></iframe>`;
            break;
        case 'readAndEditUserBtn':
            formWrapper.innerHTML = `<iframe src="user-form/read-edit-user-form.html" class="form-popup" id="readAndEditIframe"></iframe>`;
            break;
        case 'deleteBtn':
            formWrapper.innerHTML = `<iframe src="user-form/delete-popup.html" class="form-popup" id="deleteIframe"></iframe>`;
            break;
    }
}

$('#myTable').DataTable().on('draw', function () {
    $('#addUserBtn').click(function () {
        changeFormOnUser(this.id);
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
        changeFormOnUser('readAndEditUserBtn');
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
        changeFormOnUser('deleteBtn');
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