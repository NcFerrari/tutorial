'use strict';

window.onload = function () {
    const microsoft = new Firma("Microsoft Corporation", "Redmont, Washington");
    microsoft.vypisInfoOFirme();
    microsoft.pridejZamestnance();
    microsoft.pridejZamestnance();
    microsoft.vypisZamestnancu();
}

class Firma {

    nazev;
    sidlo;
    zamestnanci;

    constructor(nazev, sidlo) {
        this.nazev = nazev;
        this.sidlo = sidlo;
        this.zamestnanci = [];
    }

    vypisInfoOFirme() {
        document.write(`Firma ${this.nazev} sídlí v ${this.sidlo}`);
    }

    pridejZamestnance() {
        const jmeno = prompt("Zadej jméno zaměstnance");
        const vek = prompt("Zadej věk");
        const pozice = prompt("Zadej pracovní pozici");
        const zamestnanec = new Zamestnanec(jmeno, vek, pozice);
        this.zamestnanci.push(zamestnanec);
    }

    vypisZamestnancu() {
        document.write("<h3>Zaměstnanci</h3>");
        const seznam = document.createElement("ul");
        for (const zamestnanec of this.zamestnanci) {
            seznam.innerHTML += `<li><strong>Jméno</strong>: ${zamestnanec.jmeno}</li>`;
            seznam.innerHTML += `<li><strong>Věk</strong>: ${zamestnanec.vek}</li>`;
            seznam.innerHTML += `<li><strong>Pozice</strong>: ${zamestnanec.pozice}</li><br>`;
        }
        document.body.appendChild(seznam);
    }
}

class Zamestnanec {

    jmeno;
    vek;
    pozice;

    constructor(jmeno, vek, pozice) {
        this.jmeno = jmeno;
        this.vek = vek;
        this.pozice = pozice;
    }
}