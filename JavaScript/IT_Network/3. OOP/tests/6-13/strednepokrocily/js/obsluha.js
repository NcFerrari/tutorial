let resultDiv;

window.onload = function () {
    resultDiv = document.getElementById("found");
    let input = document.getElementById("inputText");
    document.getElementById("findButton").onclick = () => {
        getData("https://swapi.dev//api/people/?search=" + input.value);
    }
}

function getData(url) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.send();
    xhr.onload = () => {
        resultDiv.innerHTML = "";
        let data = JSON.parse(xhr.response).results;
        for (let person of data) {
            let personDiv = document.createElement("div");
            personDiv.className = "personDiv";
            personDiv.innerHTML += `<h2>${person.name}</h2><br>`;
            personDiv.innerHTML += `<span>Výška: ${person.height}</span><br>`;
            personDiv.innerHTML += `<span>Hmotnost: ${person.mass}</span><br>`;
            personDiv.innerHTML += `<span>Narozen: ${person.birth_year}</span><br>`;
            resultDiv.appendChild(personDiv);
        }
    }
}

