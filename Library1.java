import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    String name;
    String statusOfTheBook;

    Book(String name) {
        this.name = name;
        this.statusOfTheBook = "available"; // Default status
    }
}

class Library1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Book> bookList = new ArrayList<>();

        // Adding initial books
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter name of book:");
            String name = sc.next();
            bookList.add(new Book(name));
        }

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Quit");
            System.out.println("Enter your choice:");
            int option = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (option) {
                case 1: // Add Book
                    System.out.println("Enter book name:");
                    String addName = sc.nextLine();
                    bookList.add(new Book(addName));
                    break;

                case 2: // Borrow Book
                    System.out.println("Enter book name to borrow:");
                    String borrowName = sc.nextLine();
                    boolean foundBorrow = false;

                    for (Book book : bookList) {
                        if (book.name.equalsIgnoreCase(borrowName)) {
                            foundBorrow = true;
                            if (book.statusOfTheBook.equals("available")) {
                                book.statusOfTheBook = "not available";
                                System.out.println("Book is borrowed.");
                            } else {
                                System.out.println("Book is already issued.");
                            }
                            break;
                        }
                    }

                    if (!foundBorrow) {
                        System.out.println("Book not found in the library.");
                    }
                    break;

                case 3: // Return Book
                    System.out.println("Enter book name to return:");
                    String returnName = sc.nextLine();
                    boolean foundReturn = false;

                    for (Book book : bookList) {
                        if (book.name.equalsIgnoreCase(returnName)) {
                            foundReturn = true;
                            if (book.statusOfTheBook.equals("not available")) {
                                book.statusOfTheBook = "available";
                                System.out.println("Book returned successfully.");
                            } else {
                                System.out.println("Book was not issued.");
                            }
                            break;
                        }
                    }

                    if (!foundReturn) {
                        System.out.println("Book not found in the library.");
                    }
                    break;

                case 4: // Display Books
                    System.out.println("Books in Library:");
                    for (Book book : bookList) {
                        System.out.println(book.name + " - " + book.statusOfTheBook);
                    }
                    break; // Added break to prevent unintended execution

                case 5: // Quit
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        }
    }
}
