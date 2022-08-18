window.onload = function () {

    const clovek = {
        jmeno: "Jan",
        prijmeni: "Novák"
    }

    Object.defineProperty(clovek, "celeJmeno", {
        get: function () {
            return `${this.jmeno} ${this.prijmeni}`;
        },

        set: function (noveJmeno) {
            this.jmeno = noveJmeno.split(" ")[0];
            this.prijmeni = noveJmeno.split(" ")[1];
        }
    });

    console.log(clovek.celeJmeno);

    clovek.celeJmeno = "Lubor Pešek";

    console.log(clovek.celeJmeno);
}

class Clovek {

    get celeJmeno() {
        return `${this.jmeno} ${this.prijmeni}`;
    }
    set celeJmeno(noveJmeno) {
        const cast = noveJmeno.split(' ');
        this.jmeno = cast[0];
        this.prijmeni = cast[1];
    }

    constructor(jmeno, prijmeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }
}

const clovek = new Clovek('Jan', 'Novak');