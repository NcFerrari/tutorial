import React from "react";
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

const BookList = () => {
    const firstBook = books[2]
    return <div>
        <Book {...firstBook}>
            <p>poznámka</p>
        </Book>
        <section className="bookList">
            <EventExamples/>
            {books.map(book => {
                return <Book {...book} key={book.id}/>;
            })}
        </section>
    </div>
}

const EventExamples = () => {
    const handleButtonClick = () => {
        alert("omfg");
    }
    return (
        <section>
            <form>
                <h2>Typical Form</h2>
                <input type={"text"} name={"example"} id={"textField"} onChange={() => {
                    console.log("typed")
                }}/>
            </form>
            <button onClick={handleButtonClick}>click</button>
        </section>
    )
}

const root = ReactDOM.createRoot(document.getElementById("root"))
root.render(<BookList/>)