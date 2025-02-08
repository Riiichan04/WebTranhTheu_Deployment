<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<link rel="icon" href="https://res.cloudinary.com/dh90ponfw/image/upload/v1739021556/favicon_wuet0u.ico">
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/2643e782c1.js" crossorigin="anonymous"></script>
<!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <%-- Tạm thời --%>
    <link class="base-theme" rel="stylesheet" href="../../template/style/index.css">
    <link rel="stylesheet" href="../../template/style/user/header.css">
    <link rel="stylesheet" href="../../template/style/user/footer.css">
    <link rel="stylesheet" href="../../template/style/style.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<!-- DataTable -->
<link href="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.css" rel="stylesheet">
<script src="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.js"></script>
<script>
    window.themeElement = $(".base-theme")
    function setDefaultTheme() {
        if (localStorage.getItem("themeUrl") === null) {
            window.themeElement.attr("href", "../../template/style/index.css")
            localStorage.setItem("themeUrl", "../../template/style/index.css")
        }
        else window.themeElement.attr("href", localStorage.getItem("themeUrl"))
    }
    setDefaultTheme()
    //Cần lưu thêm thông tin vào localStorage
    function changeTheme(name) {
        let changedUrl = ""
        switch (name) {
            case "default": {
                changedUrl = "../../template/style/index.css"
                break
            }
            case "old": {
                changedUrl = "../../template/style/old-index.css"
                break
            }
            default: break
        }
        window.themeElement.attr("href", changedUrl)
        localStorage.setItem("themeUrl", changedUrl)
    }
</script>