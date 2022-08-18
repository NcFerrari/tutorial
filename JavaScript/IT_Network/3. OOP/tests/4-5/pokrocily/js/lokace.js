class Location {
    imgPath;
    text;
    north;
    east;
    south;
    west;
    key;
    name;

    constructor(imgPath, text, name) {
        this.imgPath = imgPath;
        this.text = text;
        this.name = name;
    }

    setLocations(north, east, south, west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    setKey(key) {
        this.key = key;
    }

    getKey() {
        return this.key;
    }

    getText() {
        return this.text;
    }

    getNorth() {
        return this.north;
    }

    getEast() {
        return this.east;
    }

    getSouth() {
        return this.south;
    }

    getWest() {
        return this.west;
    }

    getImgPath() {
        return this.imgPath;
    }

    getName() {
        return this.name;
    }
}