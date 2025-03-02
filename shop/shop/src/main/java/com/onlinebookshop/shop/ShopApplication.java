package com.onlinebookshop.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.model.Order;
import com.onlinebookshop.shop.service.AuthorService;
import com.onlinebookshop.shop.service.BookService;
import com.onlinebookshop.shop.service.OrderService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ShopApplication implements CommandLineRunner{

	@Autowired
	private BookService bs;
	
	@Autowired
	private AuthorService as;
	
	@Autowired
	private OrderService os;
	
	//AppConfig method
	@Autowired
	private Order order1;
	@Autowired
	private Order order2;

	@Autowired
	private Book book1;
	@Autowired
	private Book book2;
	
	@Autowired
	private Author author1;
	@Autowired
	private Author author2;
	
	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		// ------------------------- Book Service ------------------------
//		//Add Books..
////		Book book1 = new Book(1, "Atomic Habits", 250.00);
////		Book book2 = new Book(2, "JABC New Edition", 350.00);
//		
//		bs.addBook(book1);
//		bs.addBook(book2);
//		
//		System.out.println("Books Added Successfully..");
//		System.out.println("------------- Available Books -----------..");
//		
//		// Fetch All Books..
//		List<Book> allbooks = bs.getAllBooks();
//		allbooks.forEach(bk-> System.out.println("Book ID: "+bk.getId()+"	Book Title: "+bk.getTitle()+"	Price: "+bk.getPrize()));
//		
//		// Get Book by Id
//		Book b = bs.getBookById(1);
//		System.out.println("Book by ID: "+b);
//		
//		// update
//		b.setPrize(450.00);
//		if(bs.updatebook(b)>0)
//			System.out.println("Book Updated");
//		else
//			System.out.println("Unable to update Book..");
//		
//		int dbook =3;
//		
//		if(bs.deleteBook(dbook)>0)
//			System.out.println("Book Deleted..");
//		else
//			System.out.println("Unable to Delete Book..");
//		
//		
//		bs.getAllBooks().forEach(bk-> System.out.println("Book ID: "+bk.getId()+"	Book Title: "+bk.getTitle()+"	Price: "+bk.getPrize()));
//		
//		
//
//		// --------------------- Authors Service -----------------------------
////	Author author1 = new Author("Ram", "India");
////	Author author2 = new Author("Shyam", "India");
//	
//	
//	as.addAuthor(author1);
//	as.addAuthor(author2);
//	
//	System.out.println("Author Added Successfully..");
//	System.out.println("------------- Authors -----------..");
//	
//	// Fetch All Authors..
//	List<Author> allAuth= as.getAllAuthors();
//	allAuth.forEach(au-> System.out.println("Author ID: "+au.getId()+"	Author Name: "+au.getName()+"	Author Country: "+au.getCountry()));
//	
//	
//	// Get Author by Id
//	Author a = as.getAuthById(1);
//	System.out.println("Author by ID: "+a);
//	
//	// update
//	if(as.updateAuthor(1, "UpdatedAuthor")>0)
//		System.out.println("Author Updated");
//	else
//		System.out.println("Unable to update Author..");
//	
//	int auth =3;
//	
//	if(as.deleteAuth(auth)>0)
//		System.out.println("Author Deleted..");
//	else
//		System.out.println("Unable to Delete Author..");
//	
//	
//	as.getAllAuthors().forEach(as-> System.out.println("Book ID: "+as.getId()+"	Author Name: "+as.getName()+"	Country: "+as.getCountry()));
//	
//	
//		
//		// --------------------- Orders Service -----------------------------
////Tradtional way..
//	//		Order order1= new Order(1,21);
////		Order order2 = new Order(2, 33);
//		
//
//		
//		os.addOrder(order1);
//		os.addOrder(order2);
//		
//		System.out.println("Order Added Successfully..");
//		System.out.println("------------- Orders -----------..");
//		
//		// Fetch All Authors..
//		List<Order> allOrders= os.getAllOrders();
//		allOrders.forEach(order-> System.out.println("Order ID: "+order.getId()+"	Ordered Book Id: "+order.getBookId()+"	Order Quantity: "+order.getQuantity() + "	Date: "+order.getDate()));
//		
//		
//		// Get Order by Id
//		Order o = os.getOrderById(1);
//		System.out.println("Order by ID: "+o);
//		
//		// update
//		int qty=44;
//		if(os.updateOrder(1, qty)>0)
//			System.out.println("Order Updated by Quantity by "+ qty);
//		else
//			System.out.println("Unable to update Order Quantity..");
//		
//		int ord =3;
//		
//		if(os.deleteOrder(ord)>0)
//			System.out.println("Order Deleted..");
//		else
//			System.out.println("Unable to Delete Order..");
//		
//		
//		os.getAllOrders().forEach(order-> System.out.println("Order ID: "+order.getId()+"	Ordered Book Id: "+order.getBookId()+"	Order Quantity: "+order.getQuantity() + "	Date: "+order.getDate()));
//
//
	}

}
