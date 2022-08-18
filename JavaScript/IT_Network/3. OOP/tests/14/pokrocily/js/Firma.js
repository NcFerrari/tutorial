/*  _____ _______         _                      _
 * |_   _|__   __|       | |                    | |
 *   | |    | |_ __   ___| |___      _____  _ __| | __  ___ ____
 *   | |    | | '_ \ / _ \ __\ \ /\ / / _ \| '__| |/ / / __|_  /
 *  _| |_   | | | | |  __/ |_ \ V  V / (_) | |  |   < | (__ / /
 * |_____|  |_|_| |_|\___|\__| \_/\_/ \___/|_|  |_|\_(_)___/___|
 *                                _
 *              ___ ___ ___ _____|_|_ _ _____
 *             | . |  _| -_|     | | | |     |  LICENCE
 *             |  _|_| |___|_|_|_|_|___|_|_|_|
 *             |_|
 *
 * IT ZPRAVODAJSTVÍ  <>  PROGRAMOVÁNÍ  <>  HW A SW  <>  KOMUNITA
 *
 * Tento zdrojový kód je součástí výukových seriálů na
 * IT sociální síti WWW.ITNETWORK.CZ
 *
 * Kód spadá pod licenci prémiového obsahu a vznikl díky podpoře
 * našich členů. Je určen pouze pro osobní užití a nesmí být šířen.
 * Více informací na http://www.itnetwork.cz/licence
 */

'use strict';

class Firma {
    constructor() {
        this._projekty = [];
        this._manazer = null;
        this._grafik = null;
        this._programator = null;
        document.write('<h1>Firma byla založena.</h1>');
    }

    najmiProgramatora(zamestnanec) {
        this._overManazera();
        if (this._programator) throw new Error('Místo programátora je již obsazené.');
        this._programator = zamestnanec;
        this._programator.nadrizeny = this._manazer;
        document.write(`<p>Firma najmula programátora - ${this._programator}.</p>`);
    }

    najmiGrafika(zamestnanec) {
        this._overManazera();
        if (this._grafik) throw new Error('Místo grafika je již obsazené.');
        this._grafik = zamestnanec;
        this._grafik.nadrizeny = this._manazer;
        document.write(`<p>Firma najmula grafika - ${this._grafik}.</p>`);
    }

    najmiManazera(zamestnanec) {
        if (this._manazer) throw new Error('Místo manažera je již obsazené.');
        this._manazer = zamestnanec;
        document.write(`<p>Firma najmula manažera. - ${this._manazer}</p>`);
    }

    _overManazera() {
        if (!this._manazer)
            throw new Error('Nejprve je nutné najmout manažera!');
    }

    prijmiProjekt(projekt) {
        this._projekty.push(projekt);
    }

    zpracujProjekty() {
        if (!this._manazer || !this._grafik || !this._programator)
            throw new Error('<p>Nemáme potřebné zaměstnance!</p>');
        for (const projekt of this._projekty) {
            document.write('<hr><h2>Začínáme projekt ' + projekt + '.</h2>');
            this._rozdelPraci(projekt);
            while (!projekt.dokonceny()) {
                this._grafik.pracuj();
                this._programator.pracuj();
                this._manazer.pracuj();
            }
            document.write('<p><b>Projekt ' + projekt + ' dokončen.</b></p>');
        }
    }

    //rozdělíme práci mezi naše pracovníky.
    _rozdelPraci(projekt) {
        for (const ukol of projekt.ukoly) {
            if (ukol instanceof GrafickyUkol) this._manazer.pridelUkol(this._grafik, ukol);
            else if (ukol instanceof ProgramatorskyUkol) this._manazer.pridelUkol(this._programator, ukol);
        }
    }

    vypisZamestnance() {
        //přehled o zaměstnancích
        document.write('<hr><h2>Přehled o zaměstnancích.</h2>');
        if (this._manazer) document.write('<p>' + this._manazer.vratPrehled() + '</p>');
        if (this._grafik) document.write('<p>' + this._grafik.vratPrehled() + '</p>');
        if (this._programator) document.write('<p>' + this._programator.vratPrehled() + '</p>');
    }
}
