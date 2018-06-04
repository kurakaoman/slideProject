/* Open */
function openNav() {
    document.getElementById("myNav").style.height = "30%";
}

/* Close */
function closeNav() {
    document.getElementById("myNav").style.height = "0%";
}

/* Login */
$("#login-button").click(function () {
     //pobierz dane z inputów
    console.log("zalogujsię - Click!");
    var username = $("#username").val();
    var password = $("#password").val();
    console.log(username,password);

    $.post({
        //adres żądania
        url:"/demo/slide/project/customer/" + username,
        //Header Authorization, <value>
        beforeSend:function (xhr) {
            xhr.setRequestHeader("Authorization",btoa(username + ":" + password));
        },
        succes:function (response) {
            console.log("udane logowanie!", response);
        },
        error:function () {
            $("#bad-password").show();
            $("#bad-login").show();
        }
    })
})
