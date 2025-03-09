import BookService from "../services/BookService";
import React, { useState } from "react";
 
const GetBookById = () => {
    const [id, setId] = useState("");
    const [book, setBook] = useState(null);
    const [message, setMessage] = useState("");
 
    const handleChange = (e) => {
        setId(e.target.value);
    };
 
    const handleSubmit = (e) => {
        e.preventDefault();
 
        BookService.getBookById(id)
            .then((response) => {
                setBook(response.data); // Set the retrieved book data
                setId(""); // Clear the input
            })
            .catch((error) => {
                setMessage(`Error: ${error.response?.data?.message || error.message}`);
            });
    };
 
    return (
        <div className="book-list-table">
 
            <form onSubmit={handleSubmit} className="getbookbyid-book-form">
                <h2>Get Book by ID</h2>
                <div className="form-group">
                    <label htmlFor="id">Enter Book ID:</label>
                    <input
                        type="number"
                        id="id"
                        name="id"
                        value={id}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="submit-button">Submit</button>
                {message && <p className="message">{message}</p>}
            </form>
 
            {book && (
                <table className="book-list-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Author ID</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr key={book.id}>
                            <td>{book.id}</td>
                            <td>{book.title}</td>
                            <td>{book.author_id}</td>
                            <td>{book.prize}</td>
                        </tr>
                    </tbody>
                </table>
            )}
        </div>
    );
}
 
export default GetBookById;
 