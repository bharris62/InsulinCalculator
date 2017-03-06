function addMeal() {
    var meal = {
        insulinRatio: $("#insulinRatio").val(),
        carb: $("#carb").val(),
        protein: $("#protein").val(),
        fat: $("#fat").val(),
        correctionFactor: $("#correctionFactor").val()
    };
    $.post(
        "/post-meal",
        JSON.stringify(meal),
        function(data) {
            $("#text").val("");
        }
    );
}