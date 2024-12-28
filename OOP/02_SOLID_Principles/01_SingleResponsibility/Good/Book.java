// Class that only handles book details
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getDetails() {
        return "Title: " + title + ", Author: " + author;
    }
}