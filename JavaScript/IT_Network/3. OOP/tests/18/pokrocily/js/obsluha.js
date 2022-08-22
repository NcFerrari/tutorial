window.onload = function () {
    let img = document.createElement("img");
    img.src = "img/ball.svg";
    img.style.width = "50px";
    img.style.height = "50px";
    let plocha = new Plocha();
    plocha.pridejBalon(img);
    plocha.go();
}

class Plocha {

    static width = 800;
    static height = 500;
    static maxSize = Plocha.width > Plocha.height ? Plocha.height : Plocha.width;

    constructor() {
        this.box = document.getElementById("box");
        this.box.style.width = `${Plocha.width}px`;
        this.box.style.height = `${Plocha.height}px`;
        this.box.style.boxShadow = "3px 3px 7px gray";
        this.box.style.border = "1px solid black";
    }

    pridejBalon(img) {
        this.img = img;
        this.box.appendChild(this.img);
    }

    go() {
        
    }
}