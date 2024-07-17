import React from "react";
import ReactDOM from "react-dom/client";
import Book from "./book"

import "./index.css"

const image = "./images/book.jpg"
const title = "Hillbilly Elegy: A Memoir of a Family and Culture in Crisis"
const author = "J. D. Vance"

const BookList = () => {
    return <section className="bookList">
        <Book image={image} title={title} author={author}/>
        <Book image={image} title={title} author={author}/>
        <Book image={image} title={title} author={author}/>
        <Book image={image} title={title} author={author}/>
        {console.log("knihy")}
    </section>
}

const root = ReactDOM.createRoot(document.getElementById("root"))
root.render(<BookList/>)