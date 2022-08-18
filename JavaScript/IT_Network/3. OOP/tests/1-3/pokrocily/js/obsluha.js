window.onload = function () {
    let rozpoznavac = new RozpoznavacObdobi();
    document.write(rozpoznavac.zjisti(new Date()).split(/[<>]/)[2] + "<br>");
    showFullYear(rozpoznavac);
}

function showFullYear(rozpoznavac) {
    let date = new Date(new Date().getFullYear(), 0, 1);
    for (let i = 0; i < 365; i++) {
        document.write(`<span style="display: inline-block; min-width: 40px">${date.getDate()}.${date.getMonth() + 1}</span> - ${rozpoznavac.zjisti(date)} <br>`);
        date.setDate(date.getDate() + 1);
    }
}

class RozpoznavacObdobi {

    jaro = "<span style='white-space: nowrap;background: orange'>Astronomické jaro začíná zpravidla 21. března a končí 21. června.</span>";
    leto = "<span style='white-space: nowrap;background: red'>Astronomické léto začíná zpravidla 21. června a končí 23. září.</span>";
    podzim = "<span style='white-space: nowrap;background: green'>Astronomický podzim začíná zpravidla 23. září a končí 21. prosince.</span>";
    zima = "<span style='white-space: nowrap;background: lightblue'>Astronomická zima začíná zpravidla 21. prosince a Končí 21. března.</span>";

    formatingDate = new Date();

    vsechnaObdobi = [
        new Obdobi(this.jaro, new Date(this.formatingDate.getFullYear(), 2, 21), new Date(this.formatingDate.getFullYear(), 5, 20)),
        new Obdobi(this.leto, new Date(this.formatingDate.getFullYear(), 5, 21), new Date(this.formatingDate.getFullYear(), 8, 22)),
        new Obdobi(this.podzim, new Date(this.formatingDate.getFullYear(), 8, 23), new Date(this.formatingDate.getFullYear(), 11, 20)),
        new Obdobi(this.zima, new Date(this.formatingDate.getFullYear(), 11, 21), new Date(this.formatingDate.getFullYear(), 2, 20))
    ];

    zjisti(date) {
        for (let obdobi of this.vsechnaObdobi) {
            if (this.isDateBetweenDates(date, obdobi.zacatek, obdobi.konec)) {
                return obdobi.text;
            }
        }
        return "neznámé období";
    }

    isDateBetweenDates(date, firstDate, secondDate) {
        if (this.isDateBeforeDate(secondDate, firstDate)) {
            if (this.isDateBeforeDate(firstDate, date) || this.isDateBeforeDate(date, secondDate)) {
                return true;
            }
        }
        if (this.isDateBeforeDate(firstDate, date) && this.isDateBeforeDate(date, secondDate)) {
            return true;
        }
        return false;
    }

    isDateBeforeDate(firstDate, secondDate) {
        if (firstDate.getMonth() < secondDate.getMonth()) {
            return true;
        } else if (firstDate.getMonth() === secondDate.getMonth()) {
            if (firstDate.getDate() <= secondDate.getDate()) {
                return true;
            }
        }
        return false;
    }
}

class Obdobi {
    constructor(text, zacatek, konec) {
        this.text = text;
        this.zacatek = zacatek;
        this.konec = konec;
    }
}