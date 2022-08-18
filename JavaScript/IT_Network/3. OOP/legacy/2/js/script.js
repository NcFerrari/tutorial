'use strict';

window.onload = function() {
    new Zdravic().pozdrav();
}

class Zdravic {

    pozdrav() {
        document.write("Achoj prdi!");
    }
}