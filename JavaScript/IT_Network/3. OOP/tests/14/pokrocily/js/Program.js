class Programator extends Osoba {

    constructor(jmeno, prijmeni) {
        super(jmeno, prijmeni);
        this._hodinovaSazba = 600;
    }

    toString() {
        return "Programátor " + super.toString();
    }

    pracuj() {
        const aktualniUkol = this._vezmiUkol();
        if (!aktualniUkol) {
            return;
        }
        document.write(`<p>${this} pracuje na úkolu: <strong>${aktualniUkol}</strong>.</p>`);
        aktualniUkol.stav = "dokončeno";
        this._odeberUkol(aktualniUkol);
        this._odpracovano++;
    }
}