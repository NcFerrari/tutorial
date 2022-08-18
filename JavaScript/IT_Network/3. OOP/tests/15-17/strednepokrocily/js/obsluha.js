window.onload = function () {

    let usecka = new Usecka();
    let form = document.getElementsByTagName('form')[0];
    let aX = document.getElementById("aX");
    let aY = document.getElementById("aY");
    let bX = document.getElementById("bX");
    let bY = document.getElementById("bY");
    let vysledky = document.getElementById("answer");
    form.addEventListener("submit", (e) => {
        usecka.setBodA(new Bod(aX.value, aY.value));
        usecka.setBodB(new Bod(bX.value, bY.value));
        vysledky.innerText = `Délka úsečky je ${usecka.vypocet()} cm`;
        e.preventDefault();
    });
}

class Usecka {

    setBodA(bodA) {
        this.bodA = bodA;
    }

    setBodB(bodB) {
        this.bodB = bodB;
    }

    vypocet() {
        let a = Math.abs(this.bodA.x - this.bodB.x);
        let b = Math.abs(this.bodA.y - this.bodB.y);
        return Math.round(Math.sqrt(a * a + b * b) * 100) / 100;
    }
}

class Bod {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
}