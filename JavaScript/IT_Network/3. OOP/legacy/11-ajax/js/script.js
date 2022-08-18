window.onload = function () {
    let xhr = new XMLHttpRequest();
    let url = "https://pokeapi.co/api/v2/";

    xhr.open("GET", url + "pokemon");
    xhr.send();

    xhr.onload = function () {
        document.write(this.response);
    }
}