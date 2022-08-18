window.onload = function () {
    nactiSeznam("https://pokeapi.co/api/v2/pokemon");
}

function nactiSeznam(url) {
    let seznam_div = document.getElementById("poke-seznam");
    let seznam_ul = document.createElement("ul");
    seznam_ul.id = "poke-seznam-ul";
    seznam_div.appendChild(seznam_ul);

    stahniJSON(url, (data) => {
        for (let pokemon of data.results) {
            let novaPolozka = document.createElement("li");
            let poke_url = pokemon.url;
            novaPolozka.innerText = pokemon.name;
            novaPolozka.onclick = () => {
                nactiPokemona(poke_url);
            }
            seznam_ul.append(novaPolozka);
        }
    });
}

function nactiPokemona(url) {
    let pokemon = document.getElementById("poke-detaily");
    pokemon.innerHTML = "";
    stahniJSON(url, (data) => {
        let img = new Image();
        img.src = data.sprites.front_default;
        pokemon.appendChild(img);
        pokemon.innerHTML += `<ul><li>Název: ${data.name}</li><li>Výška: ${data.height}</li><li>Váha: ${data.weight}</li></ul>`;
    });
}

function stahniJSON(url, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.send();
    xhr.onload = () => {
        callback(JSON.parse(xhr.response));
    }
}