package library.management.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static BookDAO bookDAO = new BookDAO();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Update Book Details");
            System.out.println("6. Delete a Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        viewAllBooks();
                        break;
                    case 3:
                        searchBookById();
                        break;
                    case 4:
                        searchBookByTitle();
                        break;
                    case 5:
                        updateBook();
                        break;
                    case 6:
                        deleteBook();
                        break;
                    case 7:
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addBook() throws SQLException {
        System.out.println("\nAdd a New Book");

        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Is the book available? (true/false): ");
        boolean availability = scanner.nextBoolean();

        Book book = new Book(bookId, title, author, genre, availability);
        bookDAO.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void viewAllBooks() throws SQLException {
        System.out.println("\nAll Books in Library");
        List<Book> books = bookDAO.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books found in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void searchBookById() throws SQLException {
        System.out.println("\nSearch Book by ID");
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book book = bookDAO.searchBookById(bookId);
        if (book != null) {
            System.out.println("\nBook Found:");
            System.out.println(book);
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    private static void searchBookByTitle() throws SQLException {
        System.out.println("\nSearch Book by Title");
        System.out.print("Enter Title (or part of title): ");
        String title = scanner.nextLine();

        List<Book> books = bookDAO.searchBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found with title containing: " + title);
        } else {
            System.out.println("\nFound " + books.size() + " book(s):");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void updateBook() throws SQLException {
        System.out.println("\nUpdate Book Details");
        System.out.print("Enter Book ID to update: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book book = bookDAO.searchBookById(bookId);
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        System.out.println("\nCurrent Book Details:");
        System.out.println(book);

        System.out.println("\nEnter new details (leave blank to keep current value):");

        System.out.print("Title [" + book.getTitle() + "]: ");
        String title = scanner.nextLine();
        if (!title.isEmpty()) {
            book.setTitle(title);
        }

        System.out.print("Author [" + book.getAuthor() + "]: ");
        String author = scanner.nextLine();
        if (!author.isEmpty()) {
            book.setAuthor(author);
        }

        System.out.print("Genre [" + book.getGenre() + "]: ");
        String genre = scanner.nextLine();
        if (!genre.isEmpty()) {
            book.setGenre(genre);
        }

        System.out.print("Availability [" + (book.isAvailabilityStatus() ? "Yes" : "No") + "] (true/false): ");
        String availabilityInput = scanner.nextLine();
        if (!availabilityInput.isEmpty()) {
            book.setAvailabilityStatus(Boolean.parseBoolean(availabilityInput));
        }

        bookDAO.updateBook(book);
        System.out.println("Book updated successfully!");
    }

    private static void deleteBook() throws SQLException {
        System.out.println("\nDelete a Book");
        System.out.print("Enter Book ID to delete: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book book = bookDAO.searchBookById(bookId);
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        System.out.println("\nBook to be deleted:");
        System.out.println(book);

        System.out.print("Are you sure you want to delete this book? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            bookDAO.deleteBook(bookId);
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}
