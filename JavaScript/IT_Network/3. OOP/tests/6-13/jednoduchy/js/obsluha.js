window.onload = function () {
    document.getElementById("ascButton").onclick = () => {
        autos.output(list, "asc");
    }
    document.getElementById("descButton").onclick = () => {
        autos.output(list, "desc");
    }
    let list = document.getElementById("list");

    let autos = new Autos();
    autos.cars.push(new Car("Škoda Octavia 1.9 TDI", 2001, 220000, 55000));
    autos.cars.push(new Car("Škoda Rapid 1.4 TDI", 2015, 56000, 275000));
    autos.cars.push(new Car("Porsche 911, 2 981 ccm", 2010, 7560, 3999000));
    autos.cars.push(new Car("Peugeot 306", 1996, 350000, 11000));
    autos.cars.push(new Car("Fiat Dobló cargo", 2015, 193000, 11000));

    autos.output(list);

    autos.cars.sort(function (a, b) {
        return a.price - b.price;
    });
}

class Autos {
    cars = [];

    output(list, orderBy) {
        list.innerHTML = "";
        for (let car of this.cars) {
            if (orderBy === "asc") {
                list.insertAdjacentHTML("beforeend", `<li>${car}</li>`);
            } else {
                list.insertAdjacentHTML("afterbegin", `<li>${car}</li>`);
            }
        }
    }
}

class Car {

    constructor(brand, madeOn, tachoState, price) {
        this.brand = brand;
        this.madeOn = madeOn;
        this.tachoState = tachoState;
        this.price = price;
    }

    toString() {
        return `${this.brand}, rv: ${this.madeOn}, najeto: ${this.tachoState}, cena: ${this.price} Kč.`;
    }
}