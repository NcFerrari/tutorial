window.onload = function () {
    const lubor = new Uzivatel("Lubor", 32);
    let json = JSON.stringify(lubor);

    const magda = {
        "jmeno": "Magda",
        "vek": 32
    }
    document.write(`${lubor.jmeno} ${lubor.vek}<br>`);
    document.write(`${magda.jmeno} ${magda.vek}<br>`);
    document.write(json + `<br>`);

    const simon = JSON.parse(`{
        "jmeno": "Šimon",
        "vek": 19
    }`);
    document.write(`${simon.jmeno}, ${simon.vek}`);

    json = JSON.stringify(simon, null, 4);
    document.write(`<pre>${json}</pre>`);
}

class Uzivatel {

    constructor(jmeno, vek) {
        this.jmeno = jmeno;
        this.vek = vek;
    }
}

const jsonObject = {
    "jmeno": "Šimon",
    "vek": 19,
    "dovednosti": ["programování", "grafika", "plavání"],
    "automobil": {
        "spz": "13ABC",
        "abs": true
    },
    "manzelka": null
}