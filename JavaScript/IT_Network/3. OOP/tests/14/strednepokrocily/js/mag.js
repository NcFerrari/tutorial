class Mag extends Bojovnik {

    constructor(jmeno, maxZivot, utok, obrana, mana, magickyUtok) {
        super(jmeno, maxZivot, utok, obrana);
        this.mana = mana;
        this.maxMana = mana;
        this.magickyUtok = magickyUtok;
        this.puvodniUtok = utok;
    }

    utoc(protivnik) {
        this._utok = this.puvodniUtok;
        if (this.mana === this.maxMana) {
            this._utok += this.magickyUtok;
            this.mana = 0;
        } else {
            this.mana += 10;
        }
        super.utoc(protivnik);
    }

    manaProcenta() {
        return this.mana / this.maxMana * 100;
    }
}