let canvas = document.createElement("canvas");
let context = canvas.getContext("2d");
let on = "img/switch1.png";
let off = "img/switch0.png";
let bulbOff = "img/lamp0.png";
let bulbOn = "img/lamp1.png";
let bulb1 = new Image();
let bulb2 = new Image();
let switch1 = new Image();
let switch2 = new Image();

window.onload = function () {
    document.body.appendChild(canvas);
    canvas.width = 700;
    canvas.height = 4 * canvas.width / 7;

    let cabelWidth = canvas.width - canvas.width / 7;
    let cabelHeight = canvas.height - canvas.height / 4;

    context.strokeRect(canvas.width / 14, canvas.height / 8, cabelWidth, cabelHeight);
    context.strokeRect(canvas.width / 14, canvas.height / 8, 2 * cabelWidth / 3, cabelHeight);
    let batery = new Image();
    batery.src = "img/batery.png";
    batery.onload = function () {
        context.drawImage(batery, canvas.width / 14 - batery.width / 2, canvas.height / 8 + cabelHeight / 2 - batery.height / 2);
    }
    bulb1.src = bulbOn;
    bulb1.onload = function () {
        context.save();
        context.translate(2 * cabelWidth / 3 + canvas.width / 14 + bulb1.height, cabelHeight - bulb1.height);
        context.rotate(90 * Math.PI / 180);
        context.drawImage(bulb1, 0, 0);
        context.restore();
    }
    bulb2.src = bulbOn;
    bulb2.onload = function () {
        context.save();
        context.translate(canvas.width / 14 + cabelWidth - bulb2.height, 2 * cabelHeight / 3);
        context.rotate(-90 * Math.PI / 180);
        context.drawImage(bulb2, 0, 0);
        context.restore();
    }
    switch1.src = on;
    switch1.setAttribute("switched", "true");
    switch1.onload = function () {
        switch1.setAttribute("x", canvas.width / 14 + canvas.width / 12);
        switch1.setAttribute("y", canvas.height / 8 - switch1.height / 2);
        context.drawImage(switch1, switch1.getAttribute("x"), switch1.getAttribute("y"));
    }
    switch2.src = on;
    switch2.setAttribute("switched", "true");
    switch2.onload = function () {
        switch2.setAttribute("x", canvas.width / 14 + 2 * cabelWidth / 3);
        switch2.setAttribute("y", canvas.height / 8 + cabelHeight / 2 - switch2.width);
        context.save();
        context.translate(switch2.getAttribute("x"), switch2.getAttribute("y"));
        context.rotate(90 * Math.PI / 180);
        context.drawImage(switch2, -switch2.width / 2, -switch2.height / 2);
        context.restore();
    }
    canvas.onclick = function (evt) {
        if (evt.x >= switch1.getAttribute("x") && evt.x <= Number.parseFloat(switch1.getAttribute("x")) + Number.parseFloat(switch1.width) && evt.y >= switch1.getAttribute("y") && evt.y <= Number.parseFloat(switch1.getAttribute("y")) + Number.parseFloat(switch1.height)) {
            if (switch1.getAttribute("switched") === "true") {
                switch1.src = off;
                switch1.setAttribute("switched", "false");
                switchBulbs(false);
            } else {
                switch1.src = on;
                switch1.setAttribute("switched", "true");
                switchBulbs(true);
            }
        } else if (evt.x >= Number.parseFloat(switch2.getAttribute("x")) - switch2.height / 2 &&
            evt.x <= Number.parseFloat(switch2.getAttribute("x")) + switch2.height / 2 &&
            evt.y >= Number.parseFloat(switch2.getAttribute("y")) - switch2.width / 2 &&
            evt.y <= Number.parseFloat(switch2.getAttribute("y")) + switch2.width / 2) {
            if (switch2.getAttribute("switched") === "true") {
                switch2.src = off;
                switch2.setAttribute("switched", "false");
                switchBulb(false);
            } else {
                switch2.src = on;
                switch2.setAttribute("switched", "true");
                switchBulb(true);
            }
        }
    }
}

function switchBulbs(light) {
    if (light) {
        if (switch2.getAttribute("switched") === "true") {
            bulb1.src = bulbOn;
        }
        bulb2.src = bulbOn;
    } else {
        bulb1.src = bulbOff;
        bulb2.src = bulbOff;
    }
}

function switchBulb(light) {
    if (light && switch1.getAttribute("switched") === "true") {
        bulb1.src = bulbOn;
    } else {
        bulb1.src = bulbOff;
    }
}
