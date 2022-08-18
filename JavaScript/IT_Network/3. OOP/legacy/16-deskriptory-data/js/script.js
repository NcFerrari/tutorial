window.onload = function () {

    const object = {};
    Object.defineProperty(object, "vlastnost", {
        value: 25,
        writable: false,
        configurable: false,
        enumerable: false
    });

    for (let prop in object) {
        console.log(prop);
    }

    object.vlastnost = 28;
    console.log(object.vlastnost);

    delete object.vlastnost;
    console.log(object);

    const clovek = {
        jmeno: "Adam",
        vek: 38
    };

    Object.defineProperty(clovek, "profese", {
        value: "kuchař",
        writable: true
    });

    for(let i in clovek) {
        console.log(i);
    }

    clovek.jmeno = "Lubor";
    clovek.profese = "IT";
    console.log(`Mé nové jméno je ${clovek.jmeno} a má nová profese je ${clovek.profese}`);

    delete clovek.vek;
    delete clovek.profese;
    console.log(clovek);

}