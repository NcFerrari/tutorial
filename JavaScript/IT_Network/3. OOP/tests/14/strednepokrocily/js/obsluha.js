let arena;
window.onload = function () {

    arena = document.getElementById("arena");

    let saruman = new Mag("Saruman", 250, 30, 10, 30, 160);
    let aragorn = new Bojovnik("Aragorn", 400, 45, 20);
    let change = true;

    while (saruman.zije() && aragorn.zije()) {
        if (change) {
            utok(saruman, aragorn);
        } else {
            utok(aragorn, saruman);
        }
        showLife(saruman);
        showMana(saruman);
        showLife(aragorn);
        arena.innerHTML += "<hr>";
        change ^= true;
    }
}

function utok(bojovnik1, bojovnik2) {
    bojovnik1.utoc(bojovnik2);
    arena.innerHTML += `<div class="fightStatus">${bojovnik1.zprava}<br>${bojovnik2.zprava}</div>`;

    arena.innerHTML += `<h2>Stav Bojovníků</h2>`;
}

function showLife(bojovnik) {
    let life = document.createElement("div");
    life.className = "life";
    life.style.background = `linear-gradient(90deg, red ${bojovnik.zivotProcenta()}%, white 0%)`;
    life.innerHTML += `${bojovnik.jmeno}`;
    arena.appendChild(life);
}

function showMana(bojovnik) {
    let mana = document.createElement("div");
    mana.className = "mana";
    mana.style.background = `linear-gradient(90deg, #0000dd ${bojovnik.manaProcenta()}%, white 0%)`;
    mana.innerHTML += `MANA`;
    arena.appendChild(mana);
}