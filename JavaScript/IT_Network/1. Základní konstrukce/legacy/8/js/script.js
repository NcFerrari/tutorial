window.onload = function () {
    let button = document.getElementById("result");
    let number = document.getElementById("input");
    let number2 = document.getElementById("input2");

    function count() {
        alert(parseInt(number.value) + parseInt(number2.value));
    }

    button.onclick = count;
}