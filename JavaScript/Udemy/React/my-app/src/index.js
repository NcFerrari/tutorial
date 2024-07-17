import React from "react";
import ReactDOM from "react-dom/client";
import Book from "./book"

import "./index.css"

const book1 = {
    image: "./images/book.jpg",
    title: "Hillbilly Elegy: A Memoir of a Family and Culture in Crisis",
    author: "J. D. Vance"
}

const book2 = {
    image: "https://m.media-amazon.com/images/I/81mpSoJzv4L._SL1446_.jpg",
    title: "I Love You to the Moon and Back",
    author: "Amelia Hepworth"
}

const book3 = {
    image: "https://m.media-amazon.com/images/I/9101MLPcFTL._SL1500_.jpg",
    title: "Onyx Storm (Deluxe Limited Edition)",
    author: "Rebecca Yarros"
}

const book4 = {
    image: "https://m.media-amazon.com/images/I/81PIs7jhL0L._SL1500_.jpg",
    title: "Never Lie",
    author: "Freida McFadden"
}

const BookList = () => {
    return <section className="bookList">
        <Book image={book1.image} title={book1.title} author={book1.author}>
            <p>poznámka</p>
            <button>click me</button>
        </Book>
        <Book image={book2.image} title={book2.title} author={book2.author}/>
        <Book image={book3.image} title={book3.title} author={book3.author}/>
        <Book image={book4.image} title={book4.title} author={book4.author}/>
        {console.log("knihy")}
    </section>
}

const root = ReactDOM.createRoot(document.getElementById("root"))
root.render(<BookList/>)