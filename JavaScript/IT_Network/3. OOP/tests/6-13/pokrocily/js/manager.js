notes = [];
id = 0;

window.onload = function () {
    new Manager();
}

class Manager {
    constructor() {
        for (let note of load()) {
            notes.push(new Note(note.id, note.title, note.color, note.text));
        }
        if (notes.length > 0) {
            id = notes[notes.length - 1].id + 1;
        }
        document.getElementById("createNoteButton").onclick = () => {
            let note = new Note(id++, document.getElementById("inputText").value, document.getElementById("colorChooser").value);
            notes.push(note);
            save();
            document.getElementById("inputText").value = "";
        }
    }
}

function save() {
    let toSave = JSON.stringify(this.notes);
    localStorage.setItem("notes", toSave);
}

function load() {
    let fromSave = localStorage.getItem("notes");
    return fromSave === null ? [] : JSON.parse(fromSave);
}