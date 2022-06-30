let buttonTextUse = "Použít";
let selectedButtonIndex;

$(function () {
    createMenu();
    createActionButton();
    prepareForAction();

    $("nav ul li").on("click", function () {
        $("h2").html($(this).text());
        $(".active").removeClass("active");
        $(this).addClass("active");
        selectedButtonIndex = $(this).index();
        prepareForAction();
    });
});

function createMenu() {
    for (let fc of functions) {
        let li = document.createElement("li");
        li.innerText = fc.name;
        $("nav ul").append(li);
    }
    $("h2").html($("nav ul li:first").text());
    $("nav ul li:first").addClass("active");
    selectedButtonIndex = 0;
}

function createActionButton() {
    let button = document.createElement("input");
    button.type = "button";
    button.value = buttonTextUse;
    $("action").append(button);
    $("action input").on("click", function () {
        if (functions.length > 0) {
            functions[selectedButtonIndex]();
        }
    });
}