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
    public Boolean addBook(Book book){
        if (books.add(book) == true){
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<Book> searchBooks(){
        for (int i = 0; i < books.size(); i++) {
            ArrayList<Book> a = new ArrayList<>();
            a.add(books.get(i));
            return a;
        }
        return null;
    }
}
