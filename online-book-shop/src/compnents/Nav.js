import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import BookList from './BookList';
import DeleteBook from './DeleteBookById';
import UpdateBook from './UpdateBook';
import AddBook from './AddBook';
import GetBookById from './GetBookById';
 
const Nav = () => {
    return (
        <Router>
            <div>
                <nav>
                    <ul style={{display:'flex', gap:40}}>
                        <li>
                            <Link to="/books">Books</Link>
                        </li>
                        <li>
                            <Link to="/delete-book">Delete Book</Link>
                        </li>
                        <li>
                            <Link to="/update-book">Update book</Link>
                        </li>
                        <li>
                            <Link to="/add-book">Add Book</Link>
                        </li>
                        <li>
                            <Link to="/get-book-by-id">Get Book By Id</Link>
                        </li>
                    </ul>
                </nav>
                <Routes>
                    <Route path="/books" element={<BookList/>} />
                    <Route path="/delete-book" element={<DeleteBook />} />
                    <Route path="/update-book" element={<UpdateBook/>} />
                    <Route path="/add-book" element={<AddBook />} />
                    <Route path="/get-book-by-id" element={<GetBookById />} />
                </Routes>
            </div>
        </Router>
    );
};
 
export default Nav;
 