$("#role").change(function () {
    var selectedValue = $(this).val();
    console.log(selectedValue);
})


$("#create").click(function () {
    var name = $("#userName").val();
    var password =$("#password").val();
    var mobileNumber= $("#mobileNumber").val();

    var user = {
        username: name,
        password: password,
        mobileNumber: mobileNumber
    };


    console.log("To jest user:");
    console.log(user);
    console.log(">---USER---<");
    $.post({
        url:"/register/newUser",
        data: JSON.stringify(user),
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            window.location.href="/page/profilPage/adminPanel.html?adminId="+response;
        }
    })

})