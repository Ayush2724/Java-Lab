import java.util.Scanner;


class Book {
    private String name;
    private String author;
    private double price;
    private int num_pages;

    
     Book(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    
    public String toString() {
  return "Book Details:\n" +
               "Name: " + name + "\n" +
               "Author: " + author + "\n" +
               "Price: ₹" + price + "\n" +
               "Pages: " + num_pages;

    }
}


public class BookDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of books to create: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        Book[] books = new Book[n];

        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            System.out.print("Number of Pages: ");
            int num_pages = scanner.nextInt();
            scanner.nextLine(); 
        
            books[i] = new Book(name, author, price, num_pages);
        }

        
        System.out.println("\n--- Book Details ---");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book " + (i + 1) + " Details:");
            System.out.println(books[i].toString());
            System.out.println("--------------------");
        }

        scanner.close();
    }
}