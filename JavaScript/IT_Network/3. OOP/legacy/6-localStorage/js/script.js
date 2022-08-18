window.onload = function () {

    localStorage.setItem("local", "test");

    document.write(localStorage.getItem("local"));

    localStorage.removeItem("local");

    localStorage.clear();

    localStorage.length;

    localStorage.key(0);

    for (let i = 0; i < localStorage.length; i++) {
        document.write(localStorage.key(i) + "\t" + localStorage.getItem(localStorage.key(i)));
    }
}