
import java.util.ArrayList;

class Book implements Cloneable {
    String title;
    ArrayList<String> authors;

    // Constructor to initialize title and authors
    Book(String title, String string) {
        this.title = title;
        this.authors = new ArrayList<>();
    }

    // Add an author to the book
    void addAuthor(String author) {
        authors.add(author);
    }

    // Shallow Copy: Copies the book but not the authors list, so both books will share the same authors list
    @Override
    protected Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();  // Shallow copy, just copying the reference of the authors list
    }

    // Deep Copy: Copies the book and creates a new authors list
    protected Book deepClone() throws CloneNotSupportedException {

        /*  - This creates a new Book object using super.clone().
            - It copies the title ("Java Programming") from the original Book to the new deepCopyBook.
            - Important: It does not copy the authors list yet, it just copies the reference (the address of the authors list) from the original object. */
        Book deepCopyBook = (Book) super.clone(); 

         //  copy of the original list of authors.
         //  This new list is independent of the original list, means completely new in memory
        deepCopyBook.authors = new ArrayList<>(this.authors); // Creating a new authors list
        return deepCopyBook;
    }

    @Override
    public String toString() {
        return "Book(title=" + title + ", authors=" + authors + ")";
    }

    public char[] getDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDetails'");
    }
}

public class ShallowDeepCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Creating a book and adding authors
        Book originalBook = new Book("Java Programming");
        originalBook.addAuthor("John Doe");
        originalBook.addAuthor("Jane Smith");

        // Shallow Copy of the Book
        Book shallowCopyBook = originalBook.clone();

        // Deep Copy of the Book
        Book deepCopyBook = originalBook.deepClone();

        // Display the original, shallow copy, and deep copy
        System.out.println("Original Book: " + originalBook);
        System.out.println("Shallow Copy Book: " + shallowCopyBook);
        System.out.println("Deep Copy Book: " + deepCopyBook);

        // Modify the original book's authors
        originalBook.authors.set(0, "Updated Author");

        System.out.println("\nAfter modifying the original book's authors:");
        System.out.println("Original Book: " + originalBook);
        System.out.println("Shallow Copy Book: " + shallowCopyBook); // Will reflect change because of shared reference
        System.out.println("Deep Copy Book: " + deepCopyBook); // Will not reflect change, as it's an independent list
    }
}


/*
Original Book: Book(title=Java Programming, authors=[John Doe, Jane Smith])
Shallow Copy Book: Book(title=Java Programming, authors=[John Doe, Jane Smith])
Deep Copy Book: Book(title=Java Programming, authors=[John Doe, Jane Smith])

After modifying the original book's authors:
Original Book: Book(title=Java Programming, authors=[Updated Author, Jane Smith])
Shallow Copy Book: Book(title=Java Programming, authors=[Updated Author, Jane Smith])
Deep Copy Book: Book(title=Java Programming, authors=[John Doe, Jane Smith])
 */