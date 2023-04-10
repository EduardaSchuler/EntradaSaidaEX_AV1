import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public boolean registerNewBook(Book book){
        if(books.contains(book.getIsbn())){
            return false;
        } else {
            return books.add(book);
        }
    }

    public Book searchBook(String isbn){
        for(Book book : books){
            if(book.getIsbn().equals(isbn)) {
                return book;
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
        if(selectedBooks.isEmpty()){
            return null;
        } else {
            return selectedBooks;
        }
    }
}
