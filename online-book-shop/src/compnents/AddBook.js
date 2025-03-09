import React, { useState } from "react";
import BookService from "../services/BookService";
 
const AddBook = () => {
    const [book, setBook] = useState({
        author_id: "",
        title: "",
        prize: ""
    });
 
 
    const handleChange = (e) => {
        setBook({ ...book, [e.target.name]: e.target.value });
    }
 
    const handleSubmit = (e) => {
        e.preventDefault();
        BookService.addBook(book)
            .then((response) => {
                alert("Book added successfully");
            })
            .catch((error) => {
                alert("There was an error adding the book!" + error);
            });
    };
 
    return (
        <>
            <h2>Add Book</h2>
            <form onSubmit={handleSubmit}>
            <div>
                    <label>Author ID:</label>
                    <input
                        type="text"
                        name="authorId"
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Title:</label>
                    <input
                        type="text"
                        name="title"
                        onChange={handleChange}
                        required
                    />
                </div>

                <div>
                    <label>Price:</label>
                    <input
                        type="number"
                        name="prize"
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit">Add Book</button>
            </form>
        </>
    )
}
 
export default AddBook;
 