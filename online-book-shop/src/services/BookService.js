import axios from "axios";
const API_URL="http://localhost:2020/api/books";
class BookService {
    //fetch all books
    getAllBooks() {
        return axios.get(API_URL);
    }
    //fetch book by id
    getBookById(id){
        return axios.get(`${API_URL}/${id}`);
    }
    //add new book
    addBook(book){
        return axios.post(API_URL,book);
    }
    //delete a book by id
    deleteBook(id){
        return axios.delete(`${API_URL}/${id}`);
    }
    //update book by id
    updateBook(id,book){
        return axios.put(`${API_URL}/${id}`,book);
    }
}
export default new BookService();
 