class Tool {

    constructor(jazyk = "cs-CZ") {
        this.jazyk = jazyk;
    }

    prevedZJSON(object) {
        return JSON.parse(object);
    }

    prevedNaJSON(object) {
        return JSON.stringify(object);
    }

    nactiLokalniZaznamy() {
        return localStorage.getItem("zaznamy") !== null ? localStorage.getItem("zaznamy") : "[]";
    }

    ulozDoLokalnichZaznamu(zaznamy) {
        localStorage.setItem("zaznamy", zaznamy);
    }

    formatData(datum) {
        return new Date(datum).toLocaleDateString(this.jazyk, {
            weekday: "long",
            day: "numeric",
            month: "long",
            year: "numeric"
        });
    }

    setridPolePodleDatumu(pole) {
        pole.sort((a, b) => new Date(a.datum) - new Date(b.datum));
    }
}