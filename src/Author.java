import java.util.ArrayList;

public class Author {
    private int isbn;
    private String name;
    private ArrayList<Book> books;

    public Author(int isbn, String name, Book book) {
        this.isbn = isbn;
        this.name = name;
        books = new ArrayList<>();
        books.add(book);
    }

}
