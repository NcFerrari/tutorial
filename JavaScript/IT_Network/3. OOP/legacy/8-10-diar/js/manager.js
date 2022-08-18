window.onload = function () {
    new Manager();
}

class Manager {

    constructor() {
        this.init();
        this.vypisZpracovaneZaznamyDoVypisu();
    }

    init() {
        this.tool = new Tool();
        this.diar = new Diar(this.tool);
        this.elementy = new Elementy(this.tool, this);
    }

    refreshVypisu(pole) {
        this.elementy.vypisElement.innerHTML = "";
        for (let zaznam of pole) {
            let ukolInfo = document.createElement("p");
            ukolInfo.className = "ukol";
            let datum = document.createElement("h3");
            datum.innerHTML = this.tool.formatData(zaznam.datum);
            ukolInfo.appendChild(datum);
            this.pridejUkoly(zaznam, pole, ukolInfo);
        }
    }

    vypisZpracovaneZaznamyDoVypisu() {
        this.refreshVypisu(this.diar.zaznam);
    }

    aktualizujASetridDiar() {
        this.diar.nactiZaznamyZLocalStorage();
        this.diar.setridDiar();
    }

    pridejUkoly(zaznam, pole, ukolInfo) {
        for (let ukol of zaznam.ukoly) {
            this.pridejPrvkyUkolu(ukol, zaznam, pole, ukolInfo);
        }
    }

    pridejPrvkyUkolu(ukol, zaznam, pole, ukolInfo) {
        ukolInfo.innerHTML += `<h4>${ukol.nazev}</h4><br>úkol ${ukol.splneno ? "<span class='zelene tucne'>" : "<span class='cervene tucne'>ne"}splněn</span><br>`;
        this.elementy.vypisElement.appendChild(ukolInfo)
        this.pridejTlacitka(ukol, zaznam, pole, ukolInfo);
    }

    pridejTlacitka(ukol, zaznam, pole, ukolInfo) {
        //tlačítko smazat
        this.elementy.vytvorAPridejTlacitko("Smazat", () => {
            if (confirm("Opravdu si přejete odstranit úkol?")) {
                zaznam.ukoly = zaznam.ukoly.filter(z => z !== ukol);
                if (zaznam.ukoly.length === 0) {
                    pole = pole.filter(z => z !== zaznam);
                }
                let jsonZaznamy = this.tool.prevedNaJSON(pole);
                this._ulozZaznamy(jsonZaznamy);
                this.vypisZpracovaneZaznamyDoVypisu();
            }
        }, ukolInfo);

        //tlačítko označit
        this.elementy.vytvorAPridejTlacitko("Označit jako " + (ukol.splneno ? "ne" : "") + "splněn", () => {
            ukol.splneno = !ukol.splneno;
            let jsonZaznamy = this.tool.prevedNaJSON(pole);
            this._ulozZaznamy(jsonZaznamy);
            this.vypisZpracovaneZaznamyDoVypisu();
        }, ukolInfo);
    }

    _ulozZaznamy(jsonZaznamy) {
        this.tool.ulozDoLokalnichZaznamu(jsonZaznamy);
        this.elementy.vypisElement.innerHTML = "";
        this.aktualizujASetridDiar();
    }
}