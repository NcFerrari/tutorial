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

const firma = new Firma();
firma.najmiManazera(new Manazer('Jan', 'Chytrý'));
firma.najmiProgramatora(new Programator('Karel', 'Vala'));
firma.najmiGrafika(new Grafik('Tomáš', 'Marný'));

firma.prijmiProjekt(
    new Projekt('E-shop', [
        new GrafickyUkol('Hlavní šablona'),
        new GrafickyUkol('Kategorie'),
        new GrafickyUkol('Detail produktu'),
        new GrafickyUkol('Objednávkový formulář'),
        new ProgramatorskyUkol('Frontend'),
        new ProgramatorskyUkol('Databáze'),
        new ProgramatorskyUkol('Backend'),
        new ProgramatorskyUkol('Administrace'),
        new ProgramatorskyUkol('Server')
    ])
);
firma.prijmiProjekt(
    new Projekt('Firemní web', [
        new GrafickyUkol('Hlavní stránka'),
        new GrafickyUkol('Kontaktní formulář'),
        new ProgramatorskyUkol('Frontend'),
        new ProgramatorskyUkol('Backend'),
        new ProgramatorskyUkol('Server')
    ])
);
firma.zpracujProjekty();
firma.vypisZamestnance();
