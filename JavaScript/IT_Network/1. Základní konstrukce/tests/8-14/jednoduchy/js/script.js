window.onload = function () {
    let speakersArray = document.querySelectorAll("[data-hovorici]");
    for (let person of speakersArray) {
        let span = document.createElement("span");
        person.insertBefore(span, person.firstChild);
        span.textContent = person.getAttribute("data-hovorici") + " řekl: ";
    }
}