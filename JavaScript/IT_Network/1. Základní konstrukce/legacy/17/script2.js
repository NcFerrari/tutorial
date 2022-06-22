let canvas;
let context;
let kolo;
let angle = 0;

window.onload = function () {
    canvas = document.getElementById("canvas");
    context = canvas.getContext("2d");
    kolo = document.getElementById("kolo");
    kolo.style.display = "none";
    setInterval(repaint, 5);
}

function repaint() {
    context.clearRect(0, 0, canvas.width, canvas.height);
    context.save();
    context.translate(canvas.width / 2, canvas.height / 2);
    context.rotate(angle++ * Math.PI / 180);
    context.drawImage(kolo, -kolo.width / 2, -kolo.height / 2);
    context.restore();
}