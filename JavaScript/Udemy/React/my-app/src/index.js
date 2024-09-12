import ReactDOM from "react-dom/client";
import Book from "./book";
import "./index.css";
import img from "./images/book.jpg";

const books = [{
    id: 0,
    image: img,
    title: "Hillbilly Elegy: A Memoir of a Family and Culture in Crisis",
    author: "J. D. Vance"
}, {
    id: 1,
    image: "https://m.media-amazon.com/images/I/81mpSoJzv4L._SL1446_.jpg",
    title: "I Love You to the Moon and Back",
    author: "Amelia Hepworth"
}, {
    id: 2,
    image: "https://m.media-amazon.com/images/I/9101MLPcFTL._SL1500_.jpg",
    title: "Onyx Storm (Deluxe Limited Edition)",
    author: "Rebecca Yarros"
}, {
    id: 3,
    image: "https://m.media-amazon.com/images/I/81PIs7jhL0L._SL1500_.jpg",
    title: "Never Lie",
    author: "Freida McFadden"
}]

const root = ReactDOM.createRoot(document.getElementById("root"))
root.render(<BookList/>)

function BookList() {
    return <section className="bookList">
        <TypicalForm/>
        {
            books.map((book, index) => {
                if (book.id === 0) {
                    return <Book {...book} key={book.id} number={index}>
                        <p>Poznámka</p>
                    </Book>
                } else {
                    return <Book {...book} key={book.id} number={index}/>
                }
            })
        }
    </section>
}

const TypicalForm = () => {

    function metodaZFormulare() {
        console.log("z formuláře")
    }

    function submitEvent(evt) {
        evt.preventDefault();
        console.log("enter!")
    }

    return <section>
        {/*Pokud je definován event na tlačítko typu submit
        (to je důležité - aby bylo typu submit), tak potom se
        tato metoda onSubmit na formuláři ignoruje a platí to,
        co má tlačítko na metodu onClick (pozor, onClick!! ne onSubmit)*/}
        {/* Pokud máme anonymní metodu, tak se to vyhodnotí tak, že submit nebyl proveden
         a jde tedy k dalšímu. Tím bychom tedy mohli spustit i oba eventy (jak u tlačítka,
         tak u formuláře a to tak, že v každém případě event u tlačítka bude mít
         anonymní metodu.*/}
        {/* pořadí tedy je následovné:
        1. nejdřív se vyhodnotí metoda onClick u tlačítka typu submit. Pokud taková metoda
        existuje, tak ji provede a zbytek ignoruje
        2. pokud není definován onClick nebo je definován anonymní třídou, tak v případě
        anonymní třídy se sice tato metoda provede, ale postupuje se dále k eventu
        onSubmit na formuláři
        3. pokud není metoda onClick, provede se onSubmit na fomuláři.*/}
        <form onSubmit={metodaZFormulare}>
            {/*<form onSubmit={() => console.log("test")}>*/}
            <h2>Typical Form</h2>
            <input type={"text"} onChange={(evt) => {
                console.log(evt.target.value)
            }}/>
            <button type={"submit"} onClick={submitEvent}>Button</button>
            {/*<button type={"submit"} onClick={() => console.log(":)")}>Button</button>*/}
        </form>
    </section>
}