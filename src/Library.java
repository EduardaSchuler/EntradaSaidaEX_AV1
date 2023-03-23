import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public boolean registerNewBook(Book book){
        return books.add(book);
    }

    public Book searchBook(String isbn){
        for (int i = 0; i < books.size(); i++) {
            String a = books.get(i).getIsbn();
            if(isbn.equals(a)){
                return books.get(i);
            }
        }
        return null;
    }

    public ArrayList<Book> searchBook(int year){
        ArrayList<Book> selectedBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            int a = books.get(i).getYear();
            if (books.get(i).getYear() == year){
                selectedBooks.add(books.get(i));
            }
        }
        return null;
    }
}
