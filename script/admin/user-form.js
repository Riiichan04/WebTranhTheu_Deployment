$(document).ready(function () {
    $('#addUserBtn').click(function () {
        $('#formWrapper').removeClass('hidden');

        const iframeDoc = $('#addIframe').contents();

        // Gán sự kiện vào phần tử bên trong iframe
        iframeDoc.find('#cancelBtn').on('click', function () {
            $('#overlay').addClass('hidden');
            $('#formWrapper').addClass('hidden');
        });

        iframeDoc.find('#overlay').on('click', function() {
            $('#overlay').addClass('hidden');
            $('#formWrapper').addClass('hidden');
        });

    });
});