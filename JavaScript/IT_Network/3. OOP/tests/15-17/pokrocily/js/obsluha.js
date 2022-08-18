window.onload = function () {

    let slovnik = new Slovnik();
    let pridejPrekladTextField = document.getElementById("pridejPrekladTextField");
    document.getElementById("pridejPrekladButton").onclick = () => {
        let cs = pridejPrekladTextField.value;
        let en = pridejPrekladTextField.value;
        slovnik.pridejPreklad(new Preklad(cs.split(" ")[0], en.split(" ")[1]));
        pridejPrekladTextField.value = "";
    };
    let vysledekPrekladu = document.getElementById("vysledekPrekladu");
    document.getElementById("najdiPrekladTextField").onkeyup = function (evt) {
        let vysledek = slovnik.vyhledejPreklad(this.value);
        if (vysledek === null && this.value !== "") {
            vysledekPrekladu.innerText = "...";
        } else {
            vysledekPrekladu.innerText = vysledek;
        }
    }

    let vypisSlovniku = document.getElementById("vypisSlovniku");
    document.getElementById("slovnik").onclick = () => {
        if (slovnik.isVypisSlovnikuVisible) {
            vypisSlovniku.innerHTML = "";
        } else {
            slovnik.vypisPrekladu(vypisSlovniku);
        }
        slovnik.isVypisSlovnikuVisible = !slovnik.isVypisSlovnikuVisible;
    }
}

class Slovnik {

    isVypisSlovnikuVisible = false;
    element;

    constructor() {
        this.preklady = localStorage.getItem("preklady") !== null ? JSON.parse(localStorage.getItem("preklady")) : [];
    }

    pridejPreklad(preklad) {
        let index = this._vyhledejIndex(preklad.cs);
        let index2 = this._vyhledejIndex(preklad.en);
        if (index > -1) {
            alert(`Toto české slovo již ve slovníku existuje (${this.preklady[index].cs} má překlad ${this.preklady[index].en})`);
            return;
        }
        if (index2 > -1) {
            alert(`Toto anglické slovo již ve slovníku existuje (${this.preklady[index2].en} má překlad ${this.preklady[index2].cs})`);
            return;
        }
        this.preklady.push(preklad);
        this._ulozDoLS();
        if (this.isVypisSlovnikuVisible && this.element !== undefined) {
            this.vypisPrekladu(this.element);
        }
    }

    smazPreklad(preklad) {
        let index = this._vyhledejIndex(preklad.cs);
        if (index > -1) {
            this.preklady.splice(index, 1);
            this._ulozDoLS();
        }
    }

    vyhledejPreklad(slovo) {
        let index = this._vyhledejIndex(slovo);
        if (index > -1) {
            if (this.preklady[index].cs === slovo) {
                return this.preklady[index].en;
            }
            return this.preklady[index].cs;
        }
        return null;
    }

    vypisPrekladu(element) {
        this.element = element;
        element.innerHTML = "";
        let table = document.createElement("table");
        element.appendChild(table);
        for (let preklad of this.preklady) {
            let tr = document.createElement("tr");
            element.appendChild(tr);
            let td1 = document.createElement("td");
            td1.className = "text";
            td1.innerText = preklad.cs;
            let td2 = document.createElement("td");
            td2.className = "text";
            td2.innerText = preklad.en;
            let x = document.createElement("td");
            x.innerText = "X";
            x.className = "xButton";
            x.onclick = () => {
                this.smazPreklad(preklad);
                this.vypisPrekladu(element);
            }
            tr.append(td1, td2, x);
            tr.onmouseenter = () => {
                x.style.background = "white";
            }
        }
    }

    _ulozDoLS() {
        localStorage.setItem("preklady", JSON.stringify(this.preklady));
    }

    _vyhledejIndex(slovo) {
        for (let i = 0; i < this.preklady.length; i++) {
            if (this.preklady[i].cs === slovo || this.preklady[i].en === slovo) {
                return i;
            }
        }
        return -1;
    }
}

class Preklad {

    constructor(cs, en) {
        this.cs = cs;
        this.en = en;
    }
}