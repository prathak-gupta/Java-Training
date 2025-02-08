package day3_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookManagement {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Book Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Issue Multiple Books");
            System.out.println("5. Return Book");
            System.out.println("6. Search Book");
            System.out.println("7. Update Book Details");
            System.out.println("8. Delete Book");
            System.out.println("9. Check Availability");
            System.out.println("10. List Books by Author/Publisher");
            System.out.println("11. Sort Books");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        addBook(scanner);
                        break;
                    case 2:
                        displayAllBooks();
                        break;
                    case 3:
                        issueBook(scanner);
                        break;
                    case 4:
                        issueMultipleBooks(scanner);
                        break;
                    case 5:
                        returnBook(scanner);
                        break;
                    case 6:
                        searchBook(scanner);
                        break;
                    case 7:
                        updateBookDetails(scanner);
                        break;
                    case 8:
                        deleteBook(scanner);
                        break;
                    case 9:
                        checkAvailability(scanner);
                        break;
                    case 10:
                        listBooksByAuthorPublisher(scanner);
                        break;
                    case 11:
                        sortBooks(scanner);
                        break;
                    case 12:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  
                choice = 0;
            }
        } while (choice != 14);

        scanner.close();
    }

    private static void addBook(Scanner scanner) {
		// TODO Auto-generated method stub
        try {
            System.out.print("Enter Book ID: ");
            int bookId = scanner.nextInt();
            System.out.print("Enter ISBN: ");
            int isbNo = scanner.nextInt();
            System.out.print("Enter Number of Pages: ");
            int noOfPages = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Author Name: ");
            String authName = scanner.nextLine();
            System.out.print("Enter Publisher: ");
            String publisher = scanner.nextLine();
            System.out.print("Enter Publisher Address: ");
            String publisherAddress = scanner.nextLine();
            System.out.print("Enter Availability: ");
            int isAvailable = scanner.nextInt();
            System.out.print("Enter Prize: ");
            double prize = scanner.nextDouble();
            System.out.print("Enter Discount: ");
            float discount = scanner.nextFloat();

            Book book = new Book(bookId, isbNo, noOfPages, title, authName, publisher, publisherAddress, isAvailable, prize, discount);
            books.add(book);
            System.out.println("Book added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next();  
        }
    }

    private static void displayAllBooks() {
		// TODO Auto-generated method stub
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                book.displayInfo();
            }
        }
    }

    private static void issueBook(Scanner scanner) {
		// TODO Auto-generated method stub
        try {
            System.out.print("Enter Book ID to issue: ");
            int bookId = scanner.nextInt();
            Book book = findBookById(bookId);
            if (book != null) {
                book.issueBook();
                System.out.println("Book issued successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next(); 
        }
    }

    private static void issueMultipleBooks(Scanner scanner) {
		// TODO Auto-generated method stub
        try {
            System.out.print("Enter Book ID to issue: ");
            int bookId = scanner.nextInt();
            System.out.print("Enter number of copies to issue: ");
            int noOfCopies = scanner.nextInt();
            Book book = findBookById(bookId);
            if (book != null) {
                book.issueMultiple(noOfCopies);
                System.out.println("Books issued successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next(); 
        }
    }

    private static void returnBook(Scanner scanner) {
		// TODO Auto-generated method stub
        try {
            System.out.print("Enter Book ID to return: ");
            int bookId = scanner.nextInt();
            Book book = findBookById(bookId);
            if (book != null) {
                book.returnBook();
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next();
        }
    }

    private static void searchBook(Scanner scanner) {
		// TODO Auto-generated method stub
        System.out.print("Enter search term (title, author, or ISBN): ");
        String searchTerm = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTerm) ||
                book.getAuthName().toLowerCase().contains(searchTerm) ||
                String.valueOf(book.getIsbNo()).contains(searchTerm)) {
                book.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found matching the search term.");
        }
    }

    private static void updateBookDetails(Scanner scanner) {
		// TODO Auto-generated method stub
        try {
            System.out.print("Enter Book ID to update: ");
            int bookId = scanner.nextInt();
            scanner.nextLine();
            Book book = findBookById(bookId);
            if (book != null) {
                System.out.print("Enter new Title: ");
                String title = scanner.nextLine();
                
                System.out.print("Enter new Author Name: ");
                String authName = scanner.nextLine();
                
                System.out.print("Enter new Publisher: ");
                String publisher = scanner.nextLine();
                
                System.out.print("Enter new Publisher Address: ");
                String publisherAddress = scanner.nextLine();
                
                System.out.print("Enter new Availability: ");
                int isAvailable = scanner.nextInt();
                
                System.out.print("Enter new Prize: ");
                double prize = scanner.nextDouble();
                
                System.out.print("Enter new Discount: ");
                float discount = scanner.nextFloat();

                book.setTitle(title);
                book.setAuthName(authName);
                book.setPublisher(publisher);
                book.setPublisherAddress(publisherAddress);
                book.setAvailable(isAvailable);
                book.setPrize(prize);
                book.setDiscount(discount);

                System.out.println("Book details updated successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next();
        }
    }

    private static void deleteBook(Scanner scanner) {
		// TODO Auto-generated method stub
        try {
            System.out.print("Enter Book ID to delete: ");
            int bookId = scanner.nextInt();
            Book book = findBookById(bookId);
            if (book != null) {
                books.remove(book);
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next();
        }
    }

    private static void checkAvailability(Scanner scanner) {
		// TODO Auto-generated method stub
        try {
            System.out.print("Enter Book ID to check availability: ");
            int bookId = scanner.nextInt();
            Book book = findBookById(bookId);
            if (book != null) {
                System.out.println("Availability: " + book.getIsAvailable());
            } else {
                System.out.println("Book not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next();
        }
    }

    private static void listBooksByAuthorPublisher(Scanner scanner) {
		// TODO Auto-generated method stub
        System.out.print("Enter Author or Publisher: ");
        String searchTerm = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : books) {
            if (book.getAuthName()
            		.toLowerCase()
            		.contains(searchTerm) ||
                book.getPublisher()
                .toLowerCase()
                .contains(searchTerm)) {
                book.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found for the given author or publisher.");
        }
    }

    private static void sortBooks(Scanner scanner) {
		// TODO Auto-generated method stub
        System.out.println("Sort by: \n1. Title \n2. Author \n3. Price");
        int sortChoice = scanner.nextInt();

        switch (sortChoice) {
            case 1:
                Collections.sort(books, Comparator
                		.comparing(Book::getTitle));
                break;
            case 2:
                Collections.sort(books, Comparator
                		.comparing(Book::getAuthName));
                break;
            case 3:
                Collections.sort(books, Comparator
                		.comparingDouble(Book::getPrize));
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Books sorted successfully.");
    }


    private static Book findBookById(int bookId) {
		// TODO Auto-generated method stub
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}
