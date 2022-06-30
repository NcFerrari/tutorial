function addClass() {
    $("section ul li:first").addClass("my-class");
}

function addClassWithColoring() {
    $("section ul li").on("click", function () {
        $(this).addClass("aktivni");
    });
}

function removingClass() {
    $("section ul li").addClass("aktivni");
    $("section ul li").on("click", function () {
        $(this).removeClass("aktivni");
    });
}

function hasClass() {
    $("section ul li").on("click", function () {
        if ($(this).hasClass("aktivni")) {
            $(this).removeClass("aktivni");
        } else {
            $(this).addClass("aktivni");
        }
    });
}

function toggleClass() {
    $("section ul li").on("click", function () {
        $(this).toggleClass("aktivni");
    });
}

function addClassWithAnonmiousFunction() {
    $("section ul li").addClass(function () {
        if ($(this).text() === "PHP") {
            return "aktivni";
        }
        return "chciBytPHP";
    });
}

let functions = [addClass, addClassWithColoring, removingClass, hasClass, toggleClass, addClassWithAnonmiousFunction];

function prepareForAction() {
    $("section").empty();
    $("section").append(document.createElement("ul"));
    let languages = ["HTML", "css", "js", "PHP", "ASP .NET", "Java"];
    let ul = $("section ul");
    for (let language of languages) {
        let li = document.createElement("li");
        li.innerText = language.toUpperCase();
        ul.append(li);
    }
}
