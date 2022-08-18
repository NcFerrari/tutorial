window.onload = function () {
    let car = new Car("Audi");
    console.log(car.brand);
    car.brand = "píčovina";
    console.log(car.brand);
    for (let props in car) {
        console.log(`${props}:${car[props]}`);
    }

    console.log("TESTING");

    let testCar = new Car("Škoda");
    for (let props in testCar) {
        console.log(testCar[props]);
    }
    testCar.distance += 657;
    testCar.brand = "Porsche";
    for (let props in testCar) {
        console.log(testCar[props]);
    }
    delete testCar.distance;
    delete testCar.brand;
    for (let props in testCar) {
        console.log(testCar[props]);
    }
}

class Car {
    distance;

    get function() {
        return this.brand;
    }

    constructor(brand) {
        Object.defineProperty(this, "brand", {
            value: brand,
            enumerable: true
        });
        this.distance = 0;
    }
}