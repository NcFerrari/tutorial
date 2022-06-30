function setBlueListItems() {
    $("section ul li").addClass("blue");
}

function idExample() {
    $("#barvy").addClass("blue");
}

function moreSelectors() {
    $("#barvy li, #web li").addClass("blue");
}

function classSelector() {
    $("#barvy").addClass("blue");
    setTimeout(function () {
        $(".blue").addClass("red");
    }, 1000);
}

function directChild() {
    $("section > li").addClass("blue");
    setTimeout(function () {
        $("section ul > li").addClass("yellow");
    }, 1000);
}

function directFollowing() {
    $("#desktop + ul li").addClass("blue");
}

function elementSiblings() {
    $("#desktop ~ ul li").addClass("blue");
}

/**
 * syntaxe |= znamená, že vybere buď jen čistý text, který odpovídá hodnotě a nebo všechny atributy,
 * které mají tuto hodnotu a za ní pomlčku
 */
function stupidAttributes1() {
    $("[data-nesmysl|='69']").addClass("blue");
}

/**
 * Syntaxe *= znamená, že vybere všechny elementy, které obsahují kdekoliv hodnotu
 */
function stupidAttributes2() {
    $("[data-nesmysl*='69']").addClass("blue");
}

/**
 * Syntaxe ~= znamená, že vybere elementy, kde se vyskytuje podřetězec ohraničený bílými znaky
 */
function stupidAttributes3() {
    $("[data-nesmysl~='69']").addClass("blue");
}

/**
 * Syntaxe ^= znamená, že vybere elementy, které ZAČÍNAJÍ na daný podřetězec
 */
function stupidAttributes4() {
    $("[data-nesmysl^='69']").addClass("blue");
}

/**
 * Syntaxe $= znamená, že vybere elementy, které KONČÍ na daný podřetězec
 */
function stupidAttributes5() {
    $("[data-nesmysl$='69']").addClass("blue");
}

/**
 * Syntaxe = namená, že vybere elementy, které přesně odpovídají podřetězci
 */
function stupidAttributes6() {
    $("[data-nesmysl='69']").addClass("blue");
}

/**
 * POZOR!!! Pokud použijeme syntaxi != tak to skutečně vybere všechny elementy na stránce, který daný atribut nemají (takže úplně všechno)
 */
function dangerousStupidAttribute() {
    $("[data-nesmysl!='69']").addClass("blue");
}

function specificAttributes() {
    $("[data-nesmysl]").addClass("blue");
}

let functions = [setBlueListItems, idExample, moreSelectors, classSelector, directChild, directFollowing, elementSiblings,
    stupidAttributes1, stupidAttributes2, stupidAttributes3, stupidAttributes4, stupidAttributes5, stupidAttributes6,
    dangerousStupidAttribute, specificAttributes];

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
