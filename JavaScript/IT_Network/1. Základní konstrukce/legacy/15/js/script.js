window.onload = function () {
    let canvas = document.createElement("canvas");
    canvas.width = 500;
    canvas.height = 500;
    let context = canvas.getContext("2d");
    // context.fillRect(50, 50, 100, 100);
    // context.strokeRect(200, 50, 100, 100);
    //
    document.body.appendChild(canvas);
    //
    // for (let i = 0; i < 10; i++) {
    //     context.moveTo(50 + (i * 25), 180);
    //     context.lineTo(50 + (i * 25) + 20, 180);
    // }
    // context.stroke();
    //
    //
    context.arc(100, 100, 30, 0, Math.PI * 2);

    context.fillStyle = "#234698";
    context.strokeStyle = "#FF0000";
    context.fill();
    context.stroke();
}