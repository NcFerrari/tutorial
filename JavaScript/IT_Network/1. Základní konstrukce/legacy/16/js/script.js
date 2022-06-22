let canvas = document.createElement("canvas");
let context = canvas.getContext("2d");

let functions = [drawRect, drawLine, drawOval, drawImage, drawText, rotate, showShadow, showGradientStyle, barevneSpektrum];

window.onload = function () {
    let canvasContainer = document.getElementById("canvasContainer");
    let draw = true;
    canvas.width = 800;
    canvas.height = 500;
    let buttons = document.getElementsByTagName("li");
    buttons[0].onclick = function () {
        if (canvasContainer.contains(canvas)) {
            canvasContainer.removeChild(canvas);
        } else {
            canvasContainer.appendChild(canvas);
        }
    };

    for (let button = 1; button < buttons.length; button++) {
        buttons[button].onclick = function () {
            if (draw) {
                context.save();
                functions[button - 1]();
            } else {
                context.restore();
                context.clearRect(0, 0, canvas.width, canvas.height);
            }
            draw ^= true;
        }
    }
}

function drawRect() {
    context.fillRect(50, 50, 100, 100);

    context.strokeRect(200, 50, 100, 100);

    context.fillStyle = "rgb(33,255,0)";
    context.fillRect(350, 50, 100, 100);

    context.strokeStyle = "rgb(255,0,0)";
    context.lineWidth = 15;
    context.strokeRect(500, 50, 100, 100);
}

function drawLine() {
    context.beginPath();
    context.moveTo(0, 0);
    context.lineTo(150, 150);
    context.closePath();
    context.stroke();

    context.beginPath();
    context.moveTo(0, 200);
    context.lineTo(50, 300);
    context.lineTo(100, 200);
    context.lineTo(150, 300);
    context.lineTo(200, 200);
    context.stroke();

    context.beginPath();
    context.moveTo(300, 50);
    context.lineTo(300, 100);
    context.lineTo(350, 100);
    context.lineTo(350, 50);
    context.closePath();
    context.stroke();
}

function drawOval() {
    context.beginPath();
    context.arc(100, 100, 50, 0, Math.PI * 2);
    context.fill();

    context.beginPath();
    context.arc(200, 100, 50, 0, Math.PI * 2);
    context.stroke();

    context.beginPath();
    context.moveTo(300, 50);
    context.lineTo(400, 50);
    context.arc(300, 50, 100, 0, Math.PI / 4);
    context.closePath();
    context.stroke();

    context.beginPath();
    context.arc(100, 300, 50, 0, Math.PI, true);
    context.stroke();
    context.beginPath();
    context.arc(200, 300, 50, 0, Math.PI);
    context.stroke();
}

function drawImage() {
    let img = new Image();
    img.src = "img/Ajda.jpg";
    img.onload = function () {
        context.drawImage(img, 0, 0, canvas.width, canvas.height);
    }
}

function drawText() {
    context.font = "30px sans-serif";
    context.fillText("Testovací text", 50, 50);
}

function rotate() {
    context.save();
    context.translate(50, 50);
    context.rotate(45 * Math.PI / 180);
    context.strokeRect(0, 0, 50, 50);
    context.restore();
}

function showShadow() {
    context.save();

    context.shadowOffsetX = 3;
    context.shadowOffsetY = 3;
    context.shadowBlur = 7;
    context.shadowColor = "red";

    context.strokeRect(50, 50, 100, 100);

    context.fillRect(200, 50, 100, 100);

    context.beginPath();
    context.arc(100, 250, 50, 0, Math.PI * 2);
    context.stroke();
    context.closePath();

    context.beginPath();
    context.arc(250, 250, 50, 0, Math.PI * 2);
    context.fill();
    context.closePath();

    context.restore();
}

function showGradientStyle() {
    let gradient = context.createLinearGradient(0, 0, canvas.width, 0);
    gradient.addColorStop(0, "yellow");
    gradient.addColorStop(0.16, "orange");
    gradient.addColorStop(0.33, "red");
    gradient.addColorStop(0.5, "green");
    gradient.addColorStop(0.66, "blue");
    gradient.addColorStop(0.83, "indigo");
    gradient.addColorStop(1, "purple");
    context.fillStyle = gradient;
    context.fillRect(0, 0, canvas.width, 100);

    context.font = "28px Calibri"
    context.fillText("Nějaká dlouhá věta, která slouží pro test. Zobrazuje se v barvách duhy.", 0, 150);

    let gradientOval = context.createRadialGradient(50, 300, 0, 50, 300, 50);
    gradientOval.addColorStop(0, "yellow");
    gradientOval.addColorStop(0.16, "orange");
    gradientOval.addColorStop(0.33, "red");
    gradientOval.addColorStop(0.5, "green");
    gradientOval.addColorStop(0.66, "blue");
    gradientOval.addColorStop(0.83, "indigo");
    gradientOval.addColorStop(1, "purple");
    context.fillStyle = gradientOval;
    context.fillRect(0, 250, 100, 100);

    gradientOval = context.createRadialGradient(150, 300, 0, 150, 300, 55);
    gradientOval.addColorStop(0, "yellow");
    gradientOval.addColorStop(0.16, "orange");
    gradientOval.addColorStop(0.33, "red");
    gradientOval.addColorStop(0.5, "green");
    gradientOval.addColorStop(0.66, "blue");
    gradientOval.addColorStop(0.83, "indigo");
    gradientOval.addColorStop(1, "purple");
    context.fillStyle = gradientOval;
    context.beginPath();
    context.arc(150, 300, 50, 0, Math.PI * 2);
    context.closePath();
    context.fill();
}


function barevneSpektrum() {
    let red = document.getElementById("red");
    let green = document.getElementById("green");
    let blue = document.getElementById("blue");
    red.hidden = false;
    green.hidden = false;
    blue.hidden = false;
    red.oninput = function () {
        repaint(red.value, green.value, blue.value);
    }
    green.oninput = function () {
        repaint(red.value, green.value, blue.value);
    }
    blue.oninput = function () {
        repaint(red.value, green.value, blue.value);
    }
    repaint(red.value, green.value, blue.value);
}

function repaint(r, g, b) {
    let img = new Image();
    img.src = "img/Ajda.jpg";
    img.onload = function () {
        context.drawImage(img, 0, 0, canvas.width, canvas.height);
        let data = context.getImageData(0, 0, canvas.width, canvas.height);
        for (let i = 0; i < data.data.length; i += 4) {
            data.data[i] = r - data.data[i];
            data.data[i + 1] = g - data.data[i + 1];
            data.data[i + 2] = b - data.data[i + 2];
        }
        context.putImageData(data, 0, 0);
    }
}