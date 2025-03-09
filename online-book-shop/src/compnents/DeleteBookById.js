import React, { useState } from "react";
import BookService from "../services/BookService";
// import "./DeleteBook.css"; // Import the CSS file
 
const DeleteBook = () => {
    const [id, setId] = useState("");
 
    const message = useState("");
 
    const handleSubmit = (e) => {
        e.preventDefault();
 
        // Call the deleteBook API method
        BookService.deleteBook(id)
            .then(() => {
                alert(`Book with ID ${id} deleted successfully!`);
                setId({ id: "" }); // Clear the input
                window.location.reload();
            })
            .catch((error) => {
                alert(`Error: ${error.response?.data?.message || error.message}`);
            });
    };
 
    return (
        <form onSubmit={handleSubmit} className="delete-book-form">
            <h2>Delete Book</h2>
            <div className="form-group">
                <label htmlFor="id">Enter Book ID to delete:</label>
                <input
                    type="number"
                    id="id"
                    name="id"
                    value={id}
                    onChange={(e) => setId(e.target.value)}
                    required
                />
            </div>
            <button type="submit" className="submit-button">Submit</button>
            {message && <p className="message">{message}</p>}
        </form>
    );
};
 
export default DeleteBook;