$("#role").change(function () {
    var selectedValue = $(this).val();
    console.log(selectedValue);
})


$("#create").click(function () {
    var name = $("#userName").val();
    var password =$("#password").val();
    var mobileNumber= $("#mobileNumber").val();

    var selectedValue = $("#role").val();
    console.log(selectedValue+"inside user");
    if(selectedValue == "Customer"){
        var customer= {
    name: name
        }
        $.post({
            url: "/v1/customer/newCustomer01",
            data: JSON.stringify(customer),
            contentType: "application/json; charset=utf-8",
            success:
            //tu cchiałbym stworzyć zmeinna która przyjmowałaby wartość tkaka jak odpowiedz i przypisać ją do tworzonego obiektu user
                console.log("nowy customer gotowy")
        })
        //user.setCustomer(customer);
    } else if(selectedValue == "Manager"){
        var manager= {
    username: name
        }
        $.post({
            url: "/v1/manager/newManager01",
            data: JSON.stringify(manager),
            contentType: "application/json; charset=utf-8",
            success:
                console.log("nowy manager gotowy")
        })
        //user.setManager(manager);
    } else if(selectedValue == "Admin"){
        var admin = {
            username:name
        }
        $.post({
            url: "/v1/admin/newAdmin01",
            data: JSON.stringify(admin),
            contentType: "application/json; charset=utf-8",
            success:
                console.log("nowy admin gotowy")
        })
        //user.setAdmin(admin);
    } else {
        console.log("something goes wrong !! no role!");
    }

    var user = {
        username: name,
        password: password,
        mobileNumber: mobileNumber,
        customer: selectedValue == "Customer"? customer: null,
        manager: selectedValue == "Manager"? manager: null,
        admin: selectedValue == "Admin"? admin: null
    };


    console.log("To jest user:");
    console.log(user);
    console.log(">---USER---<");
    $.post({
        url:"/register/newUser",
        data: JSON.stringify(user),
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            if(selectedValue == "Admin"){
                window.location.href="/page/profilPage/adminPanel.html?adminId="+response;
            } else if(selectedValue =="Manager") {
                window.location.href = "/page/profilPage/managerPanel.html?managerId=" + response;
            } else {
                window.location.href = "/page/profilPage/customerPanel.html?customerId=" + response;

            }
        }
    })

})