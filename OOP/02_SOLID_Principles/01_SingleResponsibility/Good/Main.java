public class Main {
    public static void main(String[] args) {
        // Create a book object
        Book book = new Book("The Alchemist", "Paulo Coelho");

        // Create instances of Printer and Saver
        BookPrint printer = new BookPrint();
        BookSave saver = new BookSave();

        // Print the book details
        printer.print(book);

        // Save the book details
        saver.save(book);
    }
}
