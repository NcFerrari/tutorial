function cssStyle1() {
    $("section ul li").css("border-top", "2px solid red");
    $("section ul li").css("border-radius", "15px");
    $("section ul li").css("border-bottom", "2px solid blue");
}

function cssJSONFormat() {
    $("section ul li").css({
        "border-top": "2px solid red",
        "border-radius": "20px",
        "background": "#ac6dd0"
    });
}

function getCSSValue() {
    let border = $("section ul li").css("border");
    console.log(border);
}

function getCSSValues() {
    let styly = $("section ul li").css(["border", "color", "background"]);
    console.log(styly);
}

function browser() {
    let div = document.createElement("div");
    div.id = "zpravy";
    $("section").append(div);
    $("*").on("click", function (e) {
        let messages = ["Tato položka má tyto styly:"];
        let styly = $(this).css(["border", "color", "background"]);
        $.each(styly, function (props, value) {
            messages.push(props + ":" + value);
        });
        let message = messages.join("<br>");
        $("#zpravy").html(message);
        e.stopPropagation();
    });
}

function widthAndHeightModified() {
    $("*").on("click", function () {
        $(this).width($(this).width() + 10);
    });
}

function getElementPosition() {
    let div = document.createElement("div");
    div.id = "zpravy";
    $("section").append(div);
    $("section ul li").css({"margin-top": "50px"});
    $("section ul li").on("click", function () {
        $("#zpravy").html("TOP: " + $(this).offset().top + ", LEFT: " + $(this).offset().left);
    });
}

let functions = [cssStyle1, cssJSONFormat, getCSSValue, getCSSValues, browser, widthAndHeightModified, getElementPosition];

function prepareForAction() {
    $("section").empty();
    let ul = document.createElement("ul");
    $("section").append(ul);
    let gods = ["Apophis", "Anubis", "Ba'al", "Sokar", "Ti", "Ra"];
    for (let god of gods) {
        let li = document.createElement("li");
        li.textContent = god;
        ul.appendChild(li);
    }
}
