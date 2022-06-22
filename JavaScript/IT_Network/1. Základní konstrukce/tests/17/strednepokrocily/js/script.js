let ball;
let loop;
let ySpeed = 0.0;
let yPosition = 0;
let xPosition = 0;
let xSpeed = 5;
let xGrap;

window.onload = function () {
    ball = new Image();
    ball.src = "img/ball.png";
    ball.width = 50;
    ball.height = 50;
    ball.style.position = "absolute";
    document.body.appendChild(ball);
    start();

    ball.ondragstart = function (evt) {
        xGrap = evt.x;
    }

    ball.ondrag = function (evt) {
        if (evt.x > 0 && evt.y > 0) {
            yPosition = (evt.y - ball.height / 2);
            xPosition = (evt.x - ball.width / 2);
            ball.style.left = xPosition + "px";
            ball.style.top = yPosition + "px";
        }
    }
    ball.ondragend = function (evt) {
        xSpeed = (evt.x - xGrap) / 50;
        start();
    }

    window.onresize = function () {
        if (yPosition > window.innerHeight - ball.height) {
            yPosition = window.innerHeight - ball.height;
            ball.style.top = yPosition + "px";
        }
        if (ySpeed === 0.0) {
            start();
        }
    }
}

function move() {
    ySpeed += 0.05;
    yPosition += ySpeed;
    xPosition += xSpeed;
    ball.style.top = yPosition + "px";
    ball.style.left = xPosition + "px";
    if (yPosition >= window.innerHeight - ball.height && ySpeed > 0) {
        if (ySpeed <= 1) {
            ball.style.top = window.innerHeight - ball.height;
            ySpeed = 0.0;
            xSpeed = 0;
            clearInterval(loop);
        } else {
            ySpeed = -ySpeed + 1.5;
        }
    }
    if (xPosition >= window.innerWidth - ball.width || xPosition <= 0) {
        xSpeed = -xSpeed;
    }
}

function start() {
    loop = setInterval(move, 6);
}