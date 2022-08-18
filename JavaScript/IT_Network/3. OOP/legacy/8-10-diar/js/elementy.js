class Elementy {

    constructor(tool, manager) {
        this.nazevInput = document.getElementById("nazev");
        this.datumInput = document.getElementById("datum");
        this.potvrditButton = document.getElementById("potvrdit");
        this.vypisElement = document.getElementById("seznam-ukolu");

        this.tool = tool;
        this.manager = manager;
        this.nastavUdalosti();
    }

    nastavUdalosti() {
        this.potvrditButton.onclick = () => {
            let zaznam = this.vytvorNovyZaznamZInputu();
            this.pridejZaznamDoLokalnichZaznamu(zaznam);
            this.manager.aktualizujASetridDiar();
            this.manager.vypisZpracovaneZaznamyDoVypisu();
        }
    }

    vytvorNovyZaznamZInputu() {
        let datum = this.datumInput.value;
        let nazev = this.nazevInput.value;
        return new Zaznam(datum, [new Ukol(nazev, false)]);
    }

    /**
     * Toto je čistě logická metoda. Takováto logika (co se týče ukládání) by za normálních okolností určitě byla na BE
     *
     * U této metody musíme usuzovat, že přidat záznam do lokálních záznamů znamená:
     * 1. načíst lokální záznamy
     * 2. zpracovat je do použitelného pole (vyparsovat z JSON objektu)
     * 3. PŘIDAT ZÁZNAM (s mapou by to bylo lehčí)
     * 4. převést pole zpátky do JSON
     * 5. uložit záznam
     *
     * @param zaznam
     */
    pridejZaznamDoLokalnichZaznamu(zaznam) {
        let jsonZaznamy = this.tool.nactiLokalniZaznamy();
        let zaznamy = this.tool.prevedZJSON(jsonZaznamy);
        this._vlozNovyZaznamPokudNeexistuje(zaznamy, zaznam); //tohle by nahradila mapa, která v Javě má metodu putIfAbsent. V JS nevím, jestli něco takového je
        jsonZaznamy = this.tool.prevedNaJSON(zaznamy);
        this.tool.ulozDoLokalnichZaznamu(jsonZaznamy);
    }

    /**
     * Tato metoda projde záznamy. Pokud záznam již existuje (existuje datum v seznamu), tak přidá k tomuto datu úkol.
     * Pokud neexistuje, tak celý záznam přidá do pole
     *
     * PS: a současně tu máme i připravenou v podstatě logiku, kdybychom najednou někdy v budoucnu rozšířili aplikaci
     * a chtěli i přidávat víc úkolů pro jeden den :)
     *
     * @param zaznamy
     * @param novyZaznam
     * @private
     */
    _vlozNovyZaznamPokudNeexistuje(zaznamy, novyZaznam) {
        for (let zaznam of zaznamy) {
            if (zaznam.datum === novyZaznam.datum) {
                zaznam.ukoly.push(novyZaznam.ukoly[0]);
                return;
            }
        }
        zaznamy.push(novyZaznam);
    }

    vytvorAPridejTlacitko(titulek, callback, element) {
        const button = document.createElement("button");
        button.onclick = callback;
        button.innerText = titulek;
        element.appendChild(button);
    }
}