let a = 56;
let b = 28;
let u;
let v;

window.onload = function () {
    u = new Uzivatel("Jan Novák", 28);
    v = new Uzivatel("Josef Nový", 32);
    vypisPromenne();
    a = b;
    u = v;
    vypisPromenne();
    v.jmeno = "John Doe";
    vypisPromenne();
    v.jmeno = null;
    u = null;
    vypisPromenne();
}

function vypisPromenne() {
    console.table(
        {
            "a": a,
            "b": b,
            "uživatel u": u,
            "uživatel v": v
        }
    );
}

class Uzivatel {
    jmeno;
    vek;

    constructor(jmeno, vek) {
        this.jmeno = jmeno;
        this.vek = vek;
    }

    getUzivatel() {
        return `${this.jmeno} ${this.vek}`;
    }
}