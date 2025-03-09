import axios from "axios";
const API_URL="http://localhost:2020/api/authors";
class BookService {
    //fetch all books
    getAllAuthors() {
        return axios.get(API_URL);
    }
    //fetch book by id
    getAuthorkById(id){
        return axios.get(`${API_URL}/${id}`);
    }
    //add new book
    addAuthor(book){
        return axios.post(API_URL,book);
    }
    //delete a book by id
    deleteAuthor(id){
        return axios.delete(`${API_URL}/${id}`);
    }
    //update book by id
    updateAuthor(id,book){
        return axios.put(`${API_URL}/${id}`,book);
    }
}
export default new BookService();
 