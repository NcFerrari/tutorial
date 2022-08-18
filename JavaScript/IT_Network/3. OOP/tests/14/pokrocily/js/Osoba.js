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

class Osoba {
	constructor(jmeno, prijmeni) {
		this._jmeno = jmeno;
		this._prijmeni = prijmeni;
		this.nadrizeny = null;
		this._odpracovano = 0;
		this._hodinovaSazba = 0;
		this._frontaUkolu = [];
	}

	pracuj() {
		this._odpracovano++;
		document.write(`<p>${this} pracuje.</p>`);
	}

	pridejUkol(ukol) {
		this._frontaUkolu.push(ukol);
		ukol.odpovednaOsoba = this;
	}

	_vezmiUkol() {
		for (const ukol of this._frontaUkolu) {
			if (ukol.stav === 'připraven') {
				return ukol;
			}
		}
		document.write(`<p>${this} nemá co dělat!</p>`);
		return null;
	}

	_odeberUkol(ukol) {
		const index = this._frontaUkolu.indexOf(ukol);
		this._frontaUkolu.splice(index, 1);
	}

	toString() {
		return `${this._jmeno} ${this._prijmeni}`;
	}
	
	vratPrehled() {	
		return `${this} má odpracováno ${this._odpracovano} hodin, výplata bude  ${this
			._odpracovano * this._hodinovaSazba} Kč.`;
	}
}
