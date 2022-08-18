class Note {

    id;
    title;
    text;
    color;

    constructor(id, title, color, text = "...") {
        this.id = id;
        this.title = title;
        this.color = color;
        this.text = text;

        let div = document.getElementById("notes");
        let note = document.createElement("div");
        note.className = "note";
        note.style.background = this.color;
        div.appendChild(note);

        let xButton = document.createElement("button");
        xButton.innerText = "X";
        xButton.className = "xButton";
        xButton.onclick = () => {
            notes = notes.filter(n => n.id !== this.id);
            div.removeChild(note);
            save();
        }
        note.appendChild(xButton);

        let h2 = document.createElement("h2");
        h2.innerText = this.title;
        h2.setAttribute("contenteditable", "true");
        h2.onkeyup = (evt) => {
            this.title = h2.innerText;
            save();
        }
        note.appendChild(h2);

        let p = document.createElement("p");
        p.innerText = this.text;
        p.setAttribute("contenteditable", "true");
        p.onkeyup = () => {
            this.text = p.innerText;
            save();
        }
        note.appendChild(p)
    }
}