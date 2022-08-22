window.onload = function () {

    document.write(Factory.vytvorAuto("Škoda Octavia", "modrá", "1.9 TDI", "hatchblack", 2022));
    document.write(Factory.vytvorAuto("Škoda Superb", "černá", "2.0 TDI", "sedan", 2022));
    document.write(Factory.vytvorAuto("Škoda Fabia", "červená", "1.2 TSI", "kombi", 2022));
}

class Factory {

    static vytvorAuto(model, barva, motor, karoserie, rokVyroby) {
        let auto = new Auto();
        auto.model = model;
        auto.barva = barva;
        auto.motor = motor;
        auto.karoserie = karoserie;
        auto.rokVyroby = new Date();
        auto.rokVyroby.setFullYear(rokVyroby);
        return auto;
    }
}

class Auto {

    toString() {
        return `${this.model}, barva: ${this.barva}, vyrobecno: ${this.rokVyroby.getFullYear()}, motor: ${this.motor}, karoserie: ${this.karoserie}.<br>`;
    }
}