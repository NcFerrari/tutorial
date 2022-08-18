window.onload = function () {
    const clovek = new Clovek("Karel Novák");

    document.write(clovek.pozdrav());
}

class Clovek {
    name;

    constructor(name) {
        this.name = name;
    }

    pozdrav() {
        return `Ahoj, já jsem ${this.name}.`;
    }
}