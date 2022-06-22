window.onload = function () {
    let img = document.createElement("img");
    let imgOn = "img/img0.png";
    let imgOff = "img/img1.png";
    img.setAttribute("src", imgOn);

    img.onload = function () {
        document.body.appendChild(img);
    }
    img.onclick = function () {
        if (img.getAttribute("src") === imgOn) {
            img.setAttribute("src", imgOff);
        } else {
            img.setAttribute("src", imgOn);
        }
    }
}