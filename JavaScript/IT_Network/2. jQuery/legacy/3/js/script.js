let title;
let menuItems = ["Ukázka 1", "Ukázka 2", "Ukázka 3", "Ukázka 4", "Ukázka 5"];

window.onload = function () {
    createMenu();

    title = document.getElementById("title");
    let listItems = document.getElementsByTagName("li");
    for (let item of listItems) {
        item.onclick = select;
    }
    title.textContent = listItems[0].innerText;
}

function createMenu() {
    let ul = document.createElement("ul");
    document.getElementById("menu").appendChild(document.createElement("nav").appendChild(ul));
    for (let menuItem of menuItems) {
        let li = document.createElement("li");
        ul.appendChild(li);
        li.innerText = menuItem;
    }
    ul.children[0].className = "selected";
}

function select() {
    document.getElementsByClassName("selected")[0].className = "";
    this.className = "selected";
    title.textContent = this.innerText;
}