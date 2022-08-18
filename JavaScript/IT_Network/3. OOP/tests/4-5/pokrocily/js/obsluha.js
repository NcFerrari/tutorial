let locationView;
let p = document.createElement("p");
let img = new Image();
let arrows;
let addedKey;
let containKey = false;

window.onload = function () {
    arrows = new Arrows(this);
    locationView = document.getElementById("locationView");
    locationView.appendChild(img);
    locationView.appendChild(p);
    initLocation();
}

function initLocation() {
    let dum = new Location("img/dum.png", "Stojíš před svým rodným domem, cítíš vůni čerstvě nasekaného dřeva, která se line z hromady vedle vstupních dveří.");
    let hrad = new Location("img/hrad.png", "Stojíš před okovanou branou gotického hradu, která je zřejmě jediným vchodem do pevnosti. Klíčová dírka je pokryta pavučinami, což vzbuzuje dojem, že je budova opuštěná.", "hrad");
    let rybnik = new Location("img/rybnik.png", "Došel jsi ke břehu malého rybníka. Hladina je v bezvětří jako zrcadlo. Kousek od tebe je dřevěná plošina se stavidlem.");
    let lesUHradu = new Location("img/les.png", "Jsi na lesní cestě, která se klikatí až za obzor, kde mizí v siluetě zapadajícího slunce. Ticho podvečerního lesa občas přeruší zpěv posledních ptáků.");
    let lesURybnika = new Location("img/les.png", "Jsi na lesní cestě, která se klikatí až za obzor, kde mizí v siluetě zapadajícího slunce. Ticho podvečerního lesa občas přeruší zpěv posledních ptáků.");
    let lesUDomu = new Location("img/les.png", "Jsi na lesní cestě, která se klikatí až za obzor, kde mizí v siluetě zapadajícího slunce. Ticho podvečerního lesa občas přeruší zpěv posledních ptáků.");
    let rozcesti = new Location("img/les2.png", "Nacházíš se na lesním rozcestí.");
    dum.setLocations(null, null, null, lesUDomu);
    hrad.setLocations(null, lesUHradu, null, null);
    rybnik.setLocations(null, null, null, lesURybnika);
    rozcesti.setLocations(null, lesURybnika, lesUDomu, lesUHradu);
    lesUHradu.setLocations(null, rozcesti, null, hrad);
    lesURybnika.setLocations(null, rybnik, null, rozcesti);
    lesUDomu.setLocations(rozcesti, dum, null, null);

    let locations = [dum, rybnik, rozcesti, lesUHradu, lesURybnika, lesUDomu];
    locations[Math.round(Math.random() * locations.length)].setKey(keyComponent());

    setActualLocation(dum);
}

function setActualLocation(location) {
    p.innerHTML = location.getText();
    img.src = location.getImgPath();
    img.id = location.getName();
    img.onclick = function () {
        if (this.id === "hrad") {
            if (containKey) {
                alert("HRAD ÚSPĚŠNĚ ODEMČEN!");
            } else {
                alert("Nemáte klíč k odemčení hradu!");
            }
        }
    }
    if (location.getKey() != undefined && !containKey) {
        addedKey = location.getKey();
        document.body.appendChild(addedKey);
    } else if (addedKey != undefined && location.getKey() === undefined) {
        document.body.removeChild(addedKey);
        addedKey = location.getKey();
    }
    arrows.setArrows(location, this);
}

function keyComponent() {
    let key = new Image();
    key.src = "img/klic.svg";
    key.style.position = "absolute";
    key.style.top = "200px";
    key.style.left = "200px";
    key.onclick = function () {
        containKey = true;
        addedKey = undefined;
        document.body.removeChild(this);
        alert("SEBRALI JSTE KLÍČEK");
    }
    return key;
}