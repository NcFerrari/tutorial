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

class ProgramatorskyUkol extends Ukol {
	constructor(popisUkolu) {
		super(popisUkolu);
	}

	navrhni() {
		if (this.stav === 'připraven') this.stav = 'navrhnuto';
		else document.write('<p>Teď nelze navrhovat!</p>');
	}

	implementuj() {
		if (this.stav === 'navrhnuto') this.stav = 'implementováno';
		else document.write('<p>Teď nelze implementovat!</p>');
	}

	otestuj() {
		if (this.stav === 'implementováno') this.stav = 'dokončeno';
		else document.write('<p>Teď nelze testovat!</p>');
	}
}
