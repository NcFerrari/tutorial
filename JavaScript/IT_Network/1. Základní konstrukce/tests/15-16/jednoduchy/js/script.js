let canvas = document.createElement("canvas");
let context = canvas.getContext("2d");

window.onload = function () {
    canvas.width = 351;
    canvas.height = 511;
    document.body.appendChild(canvas);

    let img = new Image();
    img.src = "img/house.png";
    img.onload = function () {
        context.drawImage(img, 0, 0, canvas.width, canvas.height);
        drawRainDrops();
    }
}

function drawRainDrops() {
    for (let i = 0; i < 100; i++) {
        context.beginPath();
        context.strokeStyle = "rgb(94,94,246)";
        let x = Math.random() * canvas.width - 10;
        let y = Math.random() * canvas.height - 20;
        context.moveTo(x, y);
        context.lineTo(x + 10, y + 20);
        context.closePath();
        context.stroke();
    }
}