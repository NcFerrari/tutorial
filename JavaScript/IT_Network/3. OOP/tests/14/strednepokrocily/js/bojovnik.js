'use strict';

class Bojovnik {
    constructor(jmeno, maxZivot, utok, obrana) {
        this.jmeno = jmeno;
        this._zivot = maxZivot;
        this._maxZivot = maxZivot;
        this._utok = utok;
        this._obrana = obrana;
        this.zprava = '';
    }

    // nahodne cele cislo od 1 do...
    _vygenerujCeleCislo(maxCislo) {
        return Math.floor(Math.random() * maxCislo) + 1;
    }

    utoc(protivnik) {
        const silaUtoku = this._utok + this._vygenerujCeleCislo(6);
        this.zprava = `<b>${this.jmeno}</b> útočí úderem ${silaUtoku} hp.`;
        protivnik.branSe(silaUtoku);
    }

    branSe(silaUtoku) {
        let vyslednaSilaUtoku = silaUtoku - (this._obrana + this._vygenerujCeleCislo(6));
        if (vyslednaSilaUtoku < 0) vyslednaSilaUtoku = 0;
        this._zivot -= vyslednaSilaUtoku;
        if (this._zivot < 0) this._zivot = 0;
        this.zprava = `<b>${this.jmeno}</b> utrpěl poškození ${vyslednaSilaUtoku} hp`;
        if (this._zivot === 0) this.zprava += ` a <b>byl poražen</b>`;
        this.zprava += '.';
    }

    zije() {
        return this._zivot > 0;
    }

    zivotProcenta() {
        return this._zivot / this._maxZivot * 100;
    }
}