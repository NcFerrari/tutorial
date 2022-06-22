let canvas;
let context;
let img;
let angle = 0;
let size = 50;
let increment = 1;

window.onload = function () {
    canvas = document.createElement("canvas");
    context = canvas.getContext("2d");
    canvas.width = 526;
    canvas.height = 431;
    canvas.style.boxShadow = "3px 3px 7px gray";
    document.body.appendChild(canvas);
    img = document.getElementById("ajda");
    img.style.display = "none";
    context.drawImage(img, 0, 0);
    setInterval(rotate, 5);
}

function rotate() {
    context.clearRect(0, 0, canvas.width, canvas.height);
    context.drawImage(img, 0, 0);
    context.save();
    context.translate(canvas.width / 2, canvas.height / 2);
    context.rotate(angle++ * Math.PI / 180);
    context.fillStyle = "rgba(255,255,25, 0.5)";
    context.fillRect(-size / 2, -size / 2, size, size);
    context.restore();
    size += increment;
    if (size === maxSize() || size === 50) {
        increment = -increment;
    }
}

function maxSize() {
    let height = canvas.width <= canvas.height ? canvas.width : canvas.height;
    return Math.floor(Math.sqrt((height * height) / 2));
}