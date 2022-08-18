class Arrows {
    northArrow;
    eastArrow;
    southArrow;
    westArrow;
    obsluha;

    constructor(obsluha) {
        this.northArrow = new Image(64, 64);
        this.northArrow.src = "img/arrows/nahoru.png";
        this.eastArrow = new Image(64, 64);
        this.eastArrow.src = "img/arrows/doprava.png";
        this.southArrow = new Image(64, 64);
        this.southArrow.src = "img/arrows/dolu.png";
        this.westArrow = new Image(64, 64);
        this.westArrow.src = "img/arrows/doleva.png";

        let arrows = document.getElementById("arrowsView");
        arrows.appendChild(this.westArrow);
        arrows.appendChild(this.northArrow);
        arrows.appendChild(this.southArrow);
        arrows.appendChild(this.eastArrow);
        this.obsluha = obsluha;
    }

    setArrows(location) {
        location.getWest() != null ? this.enableArrow(this.westArrow, location.getWest()) : this.disableArrow(this.westArrow);
        location.getNorth() != null ? this.enableArrow(this.northArrow, location.getNorth()) : this.disableArrow(this.northArrow);
        location.getSouth() != null ? this.enableArrow(this.southArrow, location.getSouth()) : this.disableArrow(this.southArrow);
        location.getEast() != null ? this.enableArrow(this.eastArrow, location.getEast()) : this.disableArrow(this.eastArrow);
    }

    enableArrow(arrow, location) {
        arrow.style.opacity = "1";
        arrow.onclick = () => {
            this.obsluha.setActualLocation(location);
        }
    }

    disableArrow(arrow) {
        arrow.onclick = "";
        arrow.style.opacity = "0.2";
    }
}