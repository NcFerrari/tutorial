let title;
let menuItemIndex = 0;
let menuItemsMethods = [replace, changeFullElement, changeTagOnly, cloneWithoutFunction, anyListenerOnElement, cloneElementWithListener];
let paragraphs = [];
let text = "Chci Pozdravit Penny !";

$(function () {
    createParagraphs();
    createMenu();
    setFunctionToMenuItems();
    createActivateButton();
});

function createParagraphs() {
    for (let word of text.split(" ")) {
        let p = document.createElement("p")
        paragraphs.push(p);
        p.textContent = word;
    }
    sectionClear();
}

function createMenu() {
    let ul = document.createElement("ul");
    document.getElementById("menu").appendChild(document.createElement("nav").appendChild(ul));
    for (let i = 1; i <= menuItemsMethods.length; i++) {
        let li = document.createElement("li");
        ul.appendChild(li);
        li.innerText = menuItemsMethods[i - 1].name;
    }
    ul.children[0].className = "selected";
}

function setFunctionToMenuItems() {
    title = document.getElementById("title");
    let listItems = document.getElementsByTagName("li");
    for (let i = 0; i < listItems.length; i++) {
        listItems[i].onclick = function () {
            menuItemIndex = i;
            document.getElementsByClassName("selected")[0].className = "";
            this.className = "selected";
            title.textContent = this.innerText;
            sectionClear();
        }
    }
    title.textContent = listItems[0].innerText;
}

function createActivateButton() {
    let activateButton = document.createElement("input");
    activateButton.type = "button";
    activateButton.value = "Activate";
    activateButton.onclick = function () {
        menuItemsMethods[menuItemIndex]();
    };
    document.getElementById("activate").appendChild(activateButton);
}

function sectionClear() {
    let section = document.getElementsByTagName("section")[0];
    while (section.hasChildNodes()) {
        section.removeChild(section.lastChild);
    }
    $("p").remove();
    for (let p of paragraphs) {
        section.appendChild(p);
    }
    $("p").prop("onclick", null).off("click");
}

function replace() {
    $("p").replaceWith("<div>Nahrazeno</div>");
}

function changeFullElement() {
    $("p").replaceWith("<div>Knock</div>");
    $("div:last").replaceWith("<div>Penny!</div>");
}

function changeTagOnly() {
    $("p").each(function () {
        let obsah = $(this).html();
        $(this).replaceWith("<div>" + obsah + "</div>");
    });
}

function cloneWithoutFunction() {
    $("#activate").clone().insertAfter("#activate");
}

function anyListenerOnElement() {
    $("p").on("click", function () {
        $(this).clone().insertAfter($("p:last"));
    });
}

function cloneElementWithListener() {
    $("p").on("click", function () {
        $(this).clone(true).insertAfter($("p:last"));
    });
}
