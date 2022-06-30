function getFirstElement() {
    $("section ul li:first").addClass("green");
}

function getFirstElements() {
    $("section ul li:first-of-type").addClass("green");
}

function getLastElement() {
    $("section ul li:last").addClass("green");
}

function getLastElements() {
    $("section ul li:last-of-type").addClass("green");
}

function getNthElement() {
    let value = prompt("Zadej číslo k výběru");
    $("section ul li:nth-child(" + value + ")").addClass("green");
}

function getNthElementFromEnd() {
    let value = prompt("Zadej číslo k výběru");
    $("section ul li:nth-last-child(" + value + ")").addClass("green");
}

function getExcludedElements() {
    $("section ul li:not([data-nesmysl^='69'])").addClass("yellow");
}

function getIncludedElements() {
    $("ul li:contains('A')").addClass("blue");
}

let functions = [getFirstElement, getFirstElements, getLastElement, getLastElements, getNthElement, getNthElementFromEnd,
    getExcludedElements, getIncludedElements];

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
