window.onload = function () {
    let ptak = new Ptak();
    document.write(ptak + "<br>");
    ptak.jez(20);
    document.write(ptak + "<br>");
    let nasranyPtak = new NasranyPtak();
    document.write(nasranyPtak + "<br>");
    nasranyPtak.provokuj(5);
    document.write(nasranyPtak + "<br>");
    nasranyPtak.jez(100);
    nasranyPtak.provokuj(5);
    document.write(nasranyPtak + "<br>");
}

class Ptak {

    hlad = 100;
    vaha = 50;

    jez(jidlo) {
        if (this.hlad < jidlo) {
            jidlo = this.hlad;
        }
        this.vaha += jidlo;
        this.hlad -= jidlo;
    }

    toString() {
        return `Jsem ${this.constructor.name} s váhou ${this.vaha} a hladem ${this.hlad}.`;
    }
}

class NasranyPtak extends Ptak {

    vztek = 50;

    provokuj(miraProvokace) {
        if (this.hlad > 0) {
            miraProvokace *= 2;
        }
        this.vztek += miraProvokace;
    }

    toString() {
        return super.toString() + `, míra mého vzteku je ${this.vztek}.`;
    }
}