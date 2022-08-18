window.onload = function () {
    const programator = new Programator("Lubor", 32, "JAVA");
    document.write(programator.predstavSe() + "<br>");
    document.write(programator.programuj());
}

class Clovek {
    constructor(jmeno, vek) {
        this.jmeno = jmeno;
        this.vek = vek;
    }

    predstavSe() {
        return `Jmenuji se ${this.jmeno} a je mi ${this.vek}.`;
    }
}

class Programator extends Clovek {

    constructor(jmeno, vek, jazyk) {
        super(jmeno, vek);
        this.jazyk = jazyk;
    }

    predstavSe() {
        return `Hello world! ${super.predstavSe()}`;
    }

    programuj() {
        return `Programuji v ${this.jazyk}...`;
    }
}