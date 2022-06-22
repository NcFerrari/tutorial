let listy = [];

window.onload = function () {
    document.body.style.overflow = "hidden";

    for (let i = 0; i < 5; i++) {
        let img = new Image();
        img.src = "javor.png";
        img.onload = function () {
            document.body.appendChild(img);
        }
        listy.push(img);
        img.style.position = "absolute";
    }
    for (let i = 0; i < listy.length; i++) {
        listy[i].style.left = i * window.innerWidth / listy.length + "px";
        listy[i].style.top = -listy[i].height + "px";
    }

    setInterval(move, 20);
}

function move() {
    for (let list of listy) {
        let newPosition = parseInt(list.style.top) + 2;
        if (newPosition > window.innerHeight) {
            newPosition = -list.height;
        }
        list.style.top = newPosition + "px";
    }
}