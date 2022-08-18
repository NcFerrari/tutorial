class Grafik extends Osoba {

    constructor(jmeno, prijmeni) {
        super(jmeno, prijmeni);
        this._hodinovaSazba = 500;
    }

    toString() {
        return "Grafik " + super.toString();
    }

    pracuj() {
        this.aktualniUUkol = this._vezmiUkol();
        if (!this.aktualniUUkol) {
            return;
        }
        document.write(`<p>${this} navrhuje: <strong>${this.aktualniUUkol}</strong>.</p>`);
        document.write(`<p>${this} předává úkol ke schválení: <strong>${this.aktualniUUkol}</strong>.</p>`);
        this.nadrizeny.pridejUkol(new ManazerskyUkol("Zkontroluj návrh", this.aktualniUUkol));
        this._odpracovano++;
    }

    zpracujNavrh(ukol) {
        document.write(`<p>${this} zpracoval návrh: <strong>${ukol}</strong></p>`)
        ukol.stav = "dokončeno";
        this._odpracovano++;
    }
}