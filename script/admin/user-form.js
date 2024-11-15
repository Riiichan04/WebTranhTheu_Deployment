function changeFormOnUser(id) {
    const formWrapper = document.getElementById('formWrapper');
    switch (id) {
        case 'addIframe':
            formWrapper.innerHTML = `<iframe src="user-form/add-user-form.html" class="w-100 h-100" id="addIframe"></iframe>`;
            break;
        case 'readAndEditIframe':
            formWrapper.innerHTML = ``;
            break;
        case 'deleteIframe':
            formWrapper.innerHTML = ``;
            break;
    }
}

$(document).ready(function () {
    $('#addUserBtn').click(function () {
        changeFormOnUser('addIframe');
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

    $('#readAndEditUserBtn').click(function () {
        changeFormOnUser('readAndEditIframe');
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

    $('#deleteBtn').click(function () {
        changeFormOnUser('deleteIframe');
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
