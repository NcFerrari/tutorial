let canvas = document.createElement("canvas");
let context = canvas.getContext("2d");

window.onload = function () {
    canvas.width = 500;
    canvas.height = 500;
    document.body.appendChild(canvas);

    drawLines();

    let k = document.getElementById("kValueText");
    let q = document.getElementById("qValueText");
    let drawGraphButton = document.getElementById("drawGraphButton");
    // y = kx + q;
    drawGraphButton.onclick = function () {
        context.clearRect(0, 0, canvas.width, canvas.height);
        drawLines();
        let xPoint = canvas.width / 20;
        let yPoint = canvas.height / 20;
        context.save();
        context.translate(canvas.width / 2, canvas.height / 2);
        context.beginPath();
        context.strokeStyle = "rgb(0, 0, 255)";
        context.lineWidth = 2;
        if (k.value !== "0") {
            context.moveTo((((-10) - q.value) / k.value) * xPoint, 10 * yPoint);
            context.lineTo((((10) - q.value) / k.value) * xPoint, -10 * yPoint);
        } else {
            context.moveTo(-10 * xPoint, -q.value * yPoint);
            context.lineTo(10 * xPoint, -q.value * yPoint);
        }
        context.closePath();
        context.stroke();
        context.restore();
    }
}

function drawLines() {
    context.save();
    let xIndex = canvas.width / 20;
    let yIndex = canvas.height / 20;
    for (let i = 0; i < 20; i++) {
        context.beginPath();
        context.strokeStyle = "rgb(173,168,168)";
        context.moveTo(i * xIndex, 0);
        context.lineTo(i * xIndex, canvas.height);
        context.closePath();
        context.moveTo(0, i * yIndex);
        context.lineTo(canvas.width, i * yIndex);
        context.stroke();
    }
    context.beginPath();
    context.strokeStyle = "rgb(0,0,0)";
    context.lineWidth = 3;
    context.moveTo(canvas.width / 2, 0);
    context.lineTo(canvas.width / 2, canvas.height);
    context.closePath();
    context.moveTo(0, canvas.height / 2);
    context.lineTo(canvas.width, canvas.height / 2);
    context.stroke();
    context.restore();
}