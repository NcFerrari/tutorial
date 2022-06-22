window.onload = function () {
    createControllButtons();
    createTable();
}

let table;
let defaultXSize = 5;
let defaultYSize = 3;
let focusedCell;

function createTable() {
    let newTable = document.createElement("table");
    document.body.appendChild(newTable);

    //add rows
    for (let i = 0; i < defaultYSize; i++) {
        let tr = document.createElement("tr");
        newTable.appendChild(tr);
        for (let j = 0; j < defaultXSize; j++)
            tr.appendChild(createTd());
    }
    table = newTable;
}

function createTr() {
    let tr = document.createElement("tr");
    for (let i = 0; i < table.firstElementChild.childNodes.length; i++) {
        tr.appendChild(createTd());
    }
    return tr;
}

function createTd() {
    let td = document.createElement("td");
    let input = document.createElement("input");
    input.type = "text";

    input.onfocus = function () {
        focusedCell = this;
        console.log(getSelectedRow() + ", " + getSelectedColumn());
    }

    td.appendChild(input);
    return td;
}

function createButton(title, parent) {
    let button = document.createElement("button");
    button.textContent = title;
    parent.appendChild(button);
    return button;
}

function createControllButtons() {
    createButton("Přidat řádek dolů", document.body).onclick = addRowAfterSelected;
    createButton("Přidat řádek nahoru", document.body).onclick = addRow;
    createButton("Přidat sloupec vlevo", document.body).onclick = addColumnLeft;
    createButton("Přidat sloupec vpravo", document.body).onclick = addColumnRight;
    createButton("Odstranit řádek", document.body).onclick = deleteRow;
    createButton("Odstranit sloupec", document.body).onclick = deleteColumn;
}

function addColumnLeft() {
    let columnIndex = getSelectedColumn();
    for (let row of table.childNodes) {
        row.insertBefore(createTd(), row.childNodes[columnIndex]);
    }
}

function addColumnRight() {
    for (let row of table.childNodes) {
        if (table.childNodes[0].childNodes.length === getSelectedColumn()) {
            table.childNodes[getSelectedColumn()].appendChild(createTd());
        } else {
            row.insertBefore(createTd(), row.childNodes[getSelectedColumn() + 1]);
        }
    }
}

function addRow() {
    table.insertBefore(createTr(), table.childNodes[getSelectedRow()]);
}

function addRowAfterSelected() {
    if (table.childNodes.length === getSelectedRow()) {
        table.appendChild(createTd());
    } else {
        table.insertBefore(createTr(), table.childNodes[getSelectedRow() + 1]);
    }
}

function deleteRow() {
    let rowIndex = getSelectedRow();
    focusedCell = table.childNodes[rowIndex+1].childNodes[getSelectedColumn()];
    table.removeChild(table.childNodes[rowIndex]);
}

function deleteColumn() {
    for (let i = 0; i < table.childNodes.length; i++) {
        table.childNodes[i].removeChild(table.childNodes[i].childNodes[getSelectedRow()]);
    }
}

function getSelectedRow() {
    return Array.prototype.indexOf.call(table.childNodes, focusedCell.parentElement.parentElement)
}

function getSelectedColumn() {
    return Array.prototype.indexOf.call(focusedCell.parentElement.parentElement.childNodes, focusedCell.parentElement);
}