window.onload = function () {
    const clovek = {
        jmeno: "Jan",
        vek: 45
    }

    clovek.povolani = "hasič";

    const obdelnik = {
        x: 10,
        y: 20,
        nakresli: function () {
            console.log("nakresleno");
        }
    }

    for (let index in obdelnik) {
        console.log(index, obdelnik[index]);
    }

    if ("x" in obdelnik) {
        console.log("vlastnost existuje!");
    }

    delete obdelnik.x;

    if (!("x" in obdelnik)) {
        console.log("vlastnost neexistuje!");
    }
}