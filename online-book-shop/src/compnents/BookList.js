import BookService from "../services/BookService";
import React, { useState, useEffect } from "react";
 
const BookList = () => {
    const [books, setBooks] = useState([]);
    useEffect(() => {
        BookService.getAllBooks()
            .then(response => {
                setBooks(response.data);
            })
            .catch((error) => {
                console.log(error);
            });
    }, []);
    return (
        <>
            <h2>Book List</h2>
            <ul>
                {books.map((book) => {
                    return (<li key={book.id}>
                        {book.title}|{book.author_id}|{book.prize}
                    </li>)
                })}
            </ul>
        </>
    );
};
export default BookList;