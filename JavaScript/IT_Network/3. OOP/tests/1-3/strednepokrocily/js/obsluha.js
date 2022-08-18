window.onload = function () {

    let smajla = new Smajlik();

    let img = new Image();
    img.src = "img/smajlik.png";
    document.body.appendChild(img);
    let p = document.createElement("p");
    p.innerText = `Obsah žluté části je ${smajla.getObsah()} cm2.`;
    document.body.appendChild(p);
}

class Smajlik {

    obsah;

    constructor() {
        this.obsah = (Math.PI * 25 * 25);
        this.obsah -= (2 * (Math.PI * 5.5 * 5.5));
        this.obsah -= (20 * 5);
    }

    getObsah() {
        return this.obsah;
    }
}