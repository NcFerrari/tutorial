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

class Manazer extends Osoba {
    constructor(jmeno, prijmeni) {
        super(jmeno, prijmeni);
        this._hodinovaSazba = 1000;
    }

    pracuj() {
        const ukol = this._vezmiUkol();
        if (!ukol) return;
        document.write(`<p>${this} pracuje na úkolu: <b>${ukol}</b> (${ukol.souvisejiciUkol}).</p>`);
        ukol.zkontrolujUkol();
        ukol.souvisejiciUkol.odpovednaOsoba.zpracujNavrh(ukol.souvisejiciUkol);
        this._odeberUkol(ukol);
        this._odpracovano++;
    }

    pridelUkol(osoba, ukol) {
        osoba.pridejUkol(ukol);
    }

    toString() {
        return 'Manažer ' + super.toString();
    }
}
