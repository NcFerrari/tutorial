window.onload = function () {
    let theads = document.getElementsByTagName("thead");
    let thead = theads[0];
    let theadTr = thead.children[0]
    let ths = theadTr.children;
    for (let i = 0; i < ths.length; i++) {
        let button = document.createElement("button");
        button.setAttribute("orderBy", "DSC");
        button.onclick = function () {
            sort(this, i);
        };
        button.textContent = "S";
        ths[i].appendChild(button);
    }
}

function sort(button, buttonNumber) {
    if (button.getAttribute("orderBy") === "ASC") {
        button.setAttribute("orderBy", "DISC");
    } else {
        button.setAttribute("orderBy", "ASC");
    }

    let sortingArray = [];
    let trs = document.getElementsByTagName("tr");
    for (let cells of trs) {
        if (cells.children[buttonNumber].tagName === "TH") {
            continue;
        }
        sortingArray.push(cells);
    }

    sortingArray.sort(function (a, b) {
        return a.children[buttonNumber].textContent - b.children[buttonNumber].textContent;
    });

    sortingArray.sort(function (a, b) {
        if (button.getAttribute("orderBy") === "ASC") {
            return a.children[buttonNumber].textContent - b.children[buttonNumber].textContent;
        }
        return b.children[buttonNumber].textContent - a.children[buttonNumber].textContent;
    });

    let tbody = sortingArray[0].parentElement;
    for (let tr of sortingArray) {
        tbody.appendChild(tr);
    }
}