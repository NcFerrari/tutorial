const activateButtonText = "Activate";
let menuItemIndex = 0;
let menuItemsMethods = [remove, removeWithCriteria, emptyExample, emptySpecificListItem, detachText, detachTextIntoParagraph];
let activated = true;
let activateButton;
let detachedFields = [];

$(function () {
    createMenu();
    setFunctionToMenuItems();
    createActivateButton();
});

function createMenu() {
    let ul = document.createElement("ul");
    document.getElementById("menu").appendChild(ul);
    for (let i = 1; i <= menuItemsMethods.length; i++) {
        let li = document.createElement("li");
        ul.appendChild(li);
        li.innerText = menuItemsMethods[i - 1].name;
    }
    // ul.children[0].className = "selected";
    $("li:first").addClass("selected");
}

function setFunctionToMenuItems() {
    let listItems = document.querySelectorAll("#menu ul li");
    for (let i = 0; i < listItems.length; i++) {
        listItems[i].onclick = function () {
            menuItemIndex = i;
            document.getElementsByClassName("selected")[0].className = "";
            this.className = "selected";
            reset();
        }
    }
}

function createActivateButton() {
    activateButton = document.createElement("input");
    activateButton.type = "button";
    activateButton.value = activateButtonText;
    activateButton.onclick = function () {
        if (activated) {
            activated = false;
            activateButton.value = "Deactivate";
            menuItemsMethods[menuItemIndex]();
        } else {
            reset();
        }
    };
    document.getElementById("activate").appendChild(activateButton);
}

function reset() {
    activateButton.value = activateButtonText;
    $("week ul li").prop("onclick", null).off("click");
    activateButton.value = activateButtonText;
    activated = true;

}

function remove() {
    $("week ul li").on("click", function () {
        $(this).remove();
    });
}

function removeWithCriteria() {
    let matcher = prompt("Zadejte kousek, podle kterého se bude odstraňovat");
    $("week ul li").remove(":contains('" + matcher + "')");
    reset();
}

function emptyExample() {
    $("week ul").empty();
}

function emptySpecificListItem() {
    $("week ul li").filter(":contains('e')").empty();
}

function detachText() {
    $("p").text($("#den2").detach().text());
}

function detachTextIntoParagraph() {
    $("week ul li").on("click", function () {
        detachedFields.push($(this).detach().text());
    });

    $("p").on("click", function () {
        let toto = $(this);
        $(this).empty();
        $.each(detachedFields, function (index, value) {
            toto.append(value);
        });
    });
}