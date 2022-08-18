window.onload = function () {
    document.write("<h1>Auta</h1>")
    let dacka = new Auto("Dačka");
    let karel = new Clovek("Karel", dacka);
    let bohdan = new Clovek("Bohdan", dacka);
    karel.auto.rozjed(30);
    bohdan.auto.rozjed(30);
    bohdan.auto.natankuj(50);
    bohdan.auto.rozjed(10);
    karel.vypis();
    bohdan.vypis();
    bohdan.auto = new Auto("Škoda");
    bohdan.auto.rozjed(30);
    karel.vypis();
    bohdan.vypis();
}

class Clovek {
    name;
    auto;

    constructor(name, auto) {
        this.name = name;
        this.auto = auto;
    }

    vypis() {
        document.write(`${this.name} má auto značky ${this.auto.name} se stavem tachometru ${this.auto.tachometr} km a stavem paliva ${this.auto.palivo} l.<br>`);
    }
}

class Auto {
    name;
    palivo = 50;
    tachometr = 0;

    constructor(name) {
        this.name = name;
    }

    rozjed(vzdalenost) {
        let maloPaliva = "";
        if (vzdalenost > this.palivo) {
            vzdalenost = this.palivo;
            maloPaliva = `<br>Došlo palivo! Je třeba natankovat.`;
        }
        this.tachometr += vzdalenost;
        this.palivo -= vzdalenost;
        document.write(`Auto ${this.name} ujelo ${vzdalenost} km.${maloPaliva}<br>`);
    }

    natankuj(litry) {
        this.palivo += litry;
        document.write(`Auto ${this.name} je natankováno, stav paliva ${this.palivo} l.<br>`);
    }
}