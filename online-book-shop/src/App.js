import logo from './logo.svg';
import './App.css';
import BookList from './compnents/BookList';
import AddBook from './compnents/AddBook';
import UpdateBook from './compnents/UpdateBook';
import GetBookById from './compnents/GetBookById';
import DeleteBook from './compnents/DeleteBookById';
import Nav from './compnents/Nav';

function App() {
  return (
    <div className="App">
      {/* <BookList/> */}
      {/* <AddBook/> */}
      {/* <UpdateBook/> */}
      {/* <GetBookById/> */}
      {/* <DeleteBook/> */}
      <Nav/>
    </div>
  );
}

export default App;
