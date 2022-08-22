window.onload = function () {

    let radians = 6.28;
    let stupne = 90;

    document.write(`${radians} radiánů na stupně: ${Matika.radianyNaStupne(radians)}<br>`);
    document.write(`${stupne} stupňů na radiány: ${Matika.stupneNaRadiany(stupne)}`);

}

class Matika {

    static stupneNaRadiany(stupne) {
        return stupne * (Math.PI / 180);
    }

    static radianyNaStupne(radiany) {
        return 180 * radiany / Math.PI;
    }
}