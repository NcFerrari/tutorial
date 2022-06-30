function getAllHeaders() {
    $(":header").addClass("green");
}

function getFirstXElements() {
    $("section ul li:lt(5)").addClass("yellow");
}

function getAllElementsMinusXLast() {
    $("section ul li:lt(-5)").addClass("red");
}

function getElementsFromXToEnd() {
    $("section ul li:gt(2)").addClass("yellow");
}

function getAllOddElements() {
    $("section ul li:odd").addClass("blue");
}

function getAllEvenElements() {
    $("section ul li:even").addClass("green");
}

function getFirstElement() {
    $("section ul li:first").addClass("red");
}

function getLastElement() {
    $("section ul li:last").addClass("yellow");
}

function getSpecificElement() {
    $("section ul li:eq(3)").addClass("blue");
}

function getSpecifiCelementFromEnd() {
    $("section ul li:eq(-2)").addClass("blue");
}

function getAllElementsWhichContainsSomething() {
    $("section ul:has(h3)").addClass("red");
}

let functions = [getAllHeaders, getFirstXElements, getAllElementsMinusXLast, getElementsFromXToEnd, getAllOddElements,
    getAllEvenElements, getFirstElement, getLastElement, getSpecificElement, getSpecifiCelementFromEnd, getAllElementsWhichContainsSomething];

function prepareForAction() {
    let ids = ["web", "desktop", "zvirata", "barvy", "nesmysly"];
    let words = [["html", "css", "js", "php", "asp .net", "java"],
        ["java", "c# .net", "vb .net", "python", "pascal"],
        ["pes", "kočka", "papoušek", "lev", "drak", "želva"],
        ["růžová", "modrá", "černá", "zelená"],
        ["69", "69 xoxo", "69-nth", "nu69kl tik", "hute 69p ui", "qwe 69rty", "69 BIT", "party 69"]]
    $("section").empty();
    for (let i = 0; i < ids.length; i++) {
        let ul = document.createElement("ul");
        ul.id = ids[i];
        let h3 = document.createElement("h3");
        h3.textContent = ids[i].toUpperCase();
        ul.appendChild(h3);
        for (let word of words[i]) {
            let li;
            if (i === ids.length - 1) {
                li = document.createElement("li");
                li.setAttribute("data-nesmysl", word);
                if (word === "qwe 69rty") {
                    li.id = "qwerty";
                }
            } else {
                li = document.createElement("li");
            }
            li.textContent = word.toUpperCase();
            ul.appendChild(li);
            $("section").append(ul);
        }
    }
}
