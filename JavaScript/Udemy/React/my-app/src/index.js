import ReactDOM from "react-dom/client";
import Book from "./book"
import "./index.css"

const books = [{
    id: 0,
    image: "./images/book.jpg",
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
            books.map(book => {
                if (book.id === 0) {
                    return <Book {...book} key={book.id}>
                        <p>Poznámka</p>
                    </Book>
                } else {
                    return <Book {...book} key={book.id}/>
                }
            })
        }
    </section>
}

const TypicalForm = () => {
    const handleButtonClick = () => {
        alert("omfg");
    }

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
        <form onSubmit={metodaZFormulare}>
            <h2>Typical Form</h2>
            <input type={"text"} onChange={(evt) => {
                console.log(evt.target.value)
            }}/>
            <button type={"submit"} onClick={submitEvent}>Button</button>
        </form>
    </section>
}