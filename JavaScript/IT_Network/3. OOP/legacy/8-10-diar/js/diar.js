class Diar {

    constructor(tool) {
        this.tool = tool;
        this.zaznamy = [];

        this.nactiZaznamyZLocalStorage();
    }

    /**
     * Kdyby tato metoda byla pojmenována pouze nactiZaznamy, tak by pak nebylo moc logické, proč tu parsuje nějaký JSON
     * Ono když se takto přemýšlí i nad tou logikou, tak pak to pomáhá trošku i k pojmenování metod
     */
    nactiZaznamyZLocalStorage() {
        let JSONzaznamy = this.tool.nactiLokalniZaznamy();
        this.zaznamy = this.tool.prevedZJSON(JSONzaznamy);
    }

    setridDiar() {
        this.tool.setridPolePodleDatumu(this.zaznamy);
    }
}