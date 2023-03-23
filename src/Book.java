import java.util.ArrayList;

public class Book {
    private String title;
    private int year;
    private String isbn;
    private ArrayList<Author> authors;

    public Book(String isbn, String title, int year){
        this.title = title;
        this.year = year;
        this.isbn = isbn;
    }

    public Book(){ }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean addAuthor(Author author){
        return authors.add(author);
    }
}
