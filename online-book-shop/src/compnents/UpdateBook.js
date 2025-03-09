import React, { useState } from "react";
import BookService from "../services/BookService";

const UpdateBook = () => {
    const [book, setBook] = useState({
        id: "",
        authorId: "",
        title: "",
        price: ""
    });

    const [message, setMessage] = useState("");

    const handleChange = (e) => {
        const { name, value } = e.target;
        setBook({ ...book, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Validate that authorId exists in the database
        BookService.getBookById(book.id)
            .then((response) => {
                if (response.data) {
                    // Call the updateBook API method
                    BookService.updateBook(book.id, {
                        author_id: book.authorId,
                        title: book.title,
                        prize: book.price,
                    })
                        .then(() => {
                            alert("Book updated successfully!");
                            setBook({ id: "", authorId: "", title: "", price: "" }); // Reset the form
                            window.location.reload();
                        })
                        .catch((error) => {
                            setMessage(`Error: ${error.response?.data?.message || error.message}`);
                        });
                } else {
                    setMessage("Error: Book ID does not exist.");
                }
            })
            .catch((error) => {
                setMessage(`Error: ${error.response?.data?.message || error.message}`);
            });
    };

    return (
        <form onSubmit={handleSubmit} className="update-book-form">
            <h2>Update Book</h2>
            <div className="form-group">
                <label htmlFor="id">Enter Book ID to update:</label>
                <input
                    type="number"
                    id="id"
                    name="id"
                    value={book.id}
                    onChange={handleChange}
                    required
                />
            </div>
            <div className="form-group">
                <label htmlFor="authorId">Author ID:</label>
                <input
                    type="number"
                    id="authorId"
                    name="authorId"
                    value={book.authorId}
                    onChange={handleChange}
                    required
                />
            </div>
            <div className="form-group">
                <label htmlFor="title">Title:</label>
                <input
                    type="text"
                    id="title"
                    name="title"
                    value={book.title}
                    onChange={handleChange}
                    required
                />
            </div>
            <div className="form-group">
                <label htmlFor="price">Price:</label>
                <input
                    type="number"
                    id="price"
                    name="price"
                    value={book.price}
                    onChange={handleChange}
                    required
                />
            </div>
            <button type="submit" className="submit-button">Submit</button>
            {message && <p className="message">{message}</p>}
        </form>
    );
};

export default UpdateBook;
