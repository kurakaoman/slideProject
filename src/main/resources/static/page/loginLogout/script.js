/* Open */
function openNav() {
    document.getElementById("myNav").style.height = "30%";
}

/* Close */
function closeNav() {
    document.getElementById("myNav").style.height = "0%";
}

/* Login */
$("#login-buttonbla").click(function () {
     //utwórz dwie zmienne username i password i przypisz im wartości z odpowiednich inputów
    console.log("1) zaloguj_się - Click!");
    var username = $("#username").val();
    var password = $("#password").val();

    console.log("2) " + username,password);

    //window.location = "url"
    $.get({
        //adres żądania
        url:"/demo/slide/project/customer/" + username,
        //Header Authorization, <value>
        beforeSend:function (xhr) {
            xhr.setRequestHeader("Authorization",btoa(username + ":" + password));
            console.log("3) poszło rządanie GET ->");
        },

        succes:function (response) {
            console.log("4) udane logowanie! :-)", response);
            $("#bad-password").hide();
            $("#bad-login").hide();
        },
        error:function () {
            $("#bad-password").removeAttr("hidden");
            $("#bad-login").removeAttr("hidden");
            console.log("4) nie udane logowanie! :-(", response);
        }
    })
})
