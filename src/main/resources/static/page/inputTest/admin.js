$("#create").click(function () {
    var name = $("#adminName").val();
    var password = $("#adminPassword").val();

    var admin = {
        username: name,
        password: password
    };
    console.log(admin);
    $.post({
        url: "/v1/admin/newAdmin",
        data: JSON.stringify(admin),
        contentType: "application/json; charset=utf-8",
        success: function(response) {
            window.location.href="/page/profilPage/adminPanel.html?adminId="+response;
        },
    })
})

