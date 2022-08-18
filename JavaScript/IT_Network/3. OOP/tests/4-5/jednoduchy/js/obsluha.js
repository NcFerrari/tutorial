window.onload = function () {
    let vysledky = document.getElementById("vysledky");
    let a = document.getElementById("prvniCisloInput");
    let b = document.getElementById("druheCisloInput");

    document.getElementById("vypocitejButton").onclick = () => {
        vysledky.innerHTML = new Kalkulacka().vypis(parseFloat(a.value), parseFloat(b.value));
    }
}

class Kalkulacka {

    secti(a, b) {
        return a + b;
    }

    odecti(a, b) {
        return (this.secti(a, -b));
    }

    vynasob(a, b) {
        return a * b;
    }

    vydel(a, b) {
        if (b != 0) {
            return this.vynasob(a, 1 / b);
        }
        return "nelze dělit nulou";
    }

    vypis(a, b) {
        return `<h3>Výsledky</h3>Součet: ${this.secti(a, b)}<br>Rozdíl: ${this.odecti(a, b)}<br>Součin: ${this.vynasob(a, b)}<br>Podíl: ${this.vydel(a, b)}<br>`;
    }
}