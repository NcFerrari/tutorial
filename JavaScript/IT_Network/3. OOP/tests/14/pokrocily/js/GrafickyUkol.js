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

class GrafickyUkol extends Ukol {
	constructor(popisUkolu) {
		super(popisUkolu);
	}

	vytvorWireframe() {
		if (this.stav === 'připraven') this.stav = 'ke schválení';
		else document.write('<p>Teď nelze vytvořit wireframe!</p>');
	}

	vytvorPsdNavrh() {
		if (this.stav === 'schváleno') this.stav = 'PSD připraveno';
		else document.write('<p>Teď nelze vytvořit PSD!</p>');
	}

	nakodujSablonu() {
		if (this.stav === 'PSD připraveno') this.stav = 'dokončeno';
		else document.write('<p>Teď nelze vytvořit Šablonu!</p>');
	}
}
