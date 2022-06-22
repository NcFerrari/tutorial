window.onload = function () {
    createTable();
}

function createTable() {
    let days = ["po", "út", "st", "čt", "pá", "so", "ne"];
    let currentDate = new Date();
    let firstDayInMonth = getFirstDayOfMonth(currentDate.getFullYear(), currentDate.getMonth());
    let daysInMonth = getDaysInMonth(currentDate.getFullYear(), currentDate.getMonth());
    let table = document.createElement("table");
    document.body.appendChild(table);

    let tr = document.createElement("tr");
    table.appendChild(tr);

    for (let i = 0; i < 7; i++) {
        let th = document.createElement("th");
        tr.appendChild(th);
        th.textContent = days[i];
    }

    tr = document.createElement("tr");
    table.appendChild(tr);
    let daysCount = 0;
    for (let i = -firstDayInMonth + 2; i <= daysInMonth; i++) {
        let td = document.createElement("td");
        tr.appendChild(td);
        daysCount++;
        if (daysCount === 7) {
            daysCount = 0;
            tr = document.createElement("tr");
            table.appendChild(tr);
        }
        if (i < 1) {
            continue;
        }
        td.textContent = "" + i;
    }
}

function getFirstDayOfMonth(year, month) {
    let date = new Date(year, month, 1);
    return date.getDay();
}

function getDaysInMonth(year, month) {
    let date = new Date(year, month + 1, 0);
    return date.getDate();
}