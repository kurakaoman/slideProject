var url = new URL(window.location.href);
var id = url.searchParams.get("adminId");
console.log(id);


$.get({
    url: "/v1/admin/admin",
    data: {id: id},
    success: function(response) {
        console.log(response);
        $("#adminName").text(response.username);

    }
});