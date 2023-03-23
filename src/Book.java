import java.util.ArrayList;

public class Book {
    private String title;
    private int year;
    private int isbn;
    private ArrayList<Author> authors;

    public Book(int isbn, String title, int year){
        this.title = title;
        this.year = year;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getIsbn() {
        return isbn;
    }

    public boolean addAuthor(Author author){
        if(authors.add(author) == true){
            return true;
        } else {
            return false;
        }
    }
}
