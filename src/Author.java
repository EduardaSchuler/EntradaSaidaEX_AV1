import java.util.ArrayList;

public class Author {
    private int code;
    private String name;
    private ArrayList<Book> books;

    public Author(int code, String name, Book book) {
        this.code = code;
        this.name = name;
        books = new ArrayList<>();
        books.add(book);
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Boolean addBook(Book book){
        if(books.contains(book.getIsbn())){
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Book> getBooks(){
        for (int i = 0; i < books.size(); i++) {
            ArrayList<Book> aux = new ArrayList<>();
            aux.add(books.get(i));
            return aux;
        }
        return null;
    }
}
