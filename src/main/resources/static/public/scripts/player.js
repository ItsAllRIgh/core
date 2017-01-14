$.getJSON(window.location.href + "/getMyChars", function (data) {
    $.each(data, function () {
        createPlayerCard(this)
    });
});

createPlayerCard = function (data) {
    if (data != null) {
        console.log(data);

        var characterCard = "<div class='card col-md-3'><img src='" + data.avatar + "' alt='avatar' style='width:100%'><div class='container'><h4><b>" + data.name + "</b></h4><p>" + data.species.name + "</p></div></div>";
        $("#cards").append($(characterCard));

    }

};
