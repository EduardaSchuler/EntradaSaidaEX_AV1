import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ACMEPublishing {
    private Scanner in;
    private Library library = new Library();
    private Group group = new Group();

    public ACMEPublishing() {
        in = new Scanner(System.in);
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dados.txt"));
            in = new Scanner(streamEntrada);
            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
        } catch (Exception e) {
            System.out.println(e);
        }
        in.useLocale(Locale.ENGLISH);
    }

    public void executar(){
        registerNewBook();
        numberRegisteredBooks();
        registerNewAuthor();
        numberRegisteredAuthors();
        addBookToAuthor();
        getAllBooksByAnAuthor();
        getAllAuthorByAnBook();
        getBookByYear();

        menu();
    }

    public void menu(){
        System.out.println("Menu de opções: ");
        System.out.println("[1] Cadastrar novo autor e livro correspondente");
        System.out.println("[2] Mostrar todos os autores cadastrados e livros correspondentes");
        System.out.println("[0] Sair do sistema");

    }

    public void registerNewBook(){
        String isbn;
        String title;
        String year;
        do {
            isbn = in.nextLine();
            if (isbn.equals("-1"))
                break;
            title = in.nextLine();
            year = in.nextLine();
            Book book = new Book(isbn, title, Integer.parseInt(year));
            if (library.registerNewBook(book) == true) {
                System.out.println("1;" + book.getIsbn() + ";" + book.getTitle() + ";" + book.getYear());
            } else {
                System.out.println("erro: não foi possivel cadastrar o livro, código ja existente");
            }
        } while (isbn != "-1");
    }

    public void numberRegisteredBooks(){
        System.out.println("2;" + library.getBooks().size());
    }

    public void registerNewAuthor(){
        String code;
        String name;
        Book isbn;
        do {
            code = in.nextLine();
            if (code.equals("-1"))
                break;
            name = in.nextLine();
            isbn = library.searchBook(in.nextLine());
            Author author = new Author(Integer.parseInt(code), name, isbn);
            if (group.registerNewAuthor(author) == true) {
                System.out.println("3;" + author.getCode() + ";" + author.getName() + ";" + author.getBooks().get(0).getIsbn());
            } else {
                System.out.println("erro: não foi possivel cadastrar o livro, código ja existente");
            }
        } while (code != "-1");
    }

    public void numberRegisteredAuthors(){
        System.out.println("4;" + group.getAuthors().size());
    }

    public void addBookToAuthor(){
        String code;
        do {
            code = in.nextLine();
            if (code.equals("-1"))
                break;
            String isbn = in.nextLine();
            group.SearchAuthor(Integer.parseInt(code)).addBook(library.searchBook(isbn));
            library.searchBook(isbn).addAuthor(group.SearchAuthor(Integer.parseInt(code)));
            System.out.println("5;" + group.SearchAuthor(Integer.parseInt(code)).getCode() + ";" +
                    group.SearchAuthor(Integer.parseInt(code)).getName() + ";" +
                    library.searchBook(isbn).getIsbn() + ";" + library.searchBook(isbn).getTitle()
                    + ";" + library.searchBook(isbn).getYear());
        } while (code != "-1");
    }

    public void getAllBooksByAnAuthor(){
        String code = in.nextLine();
        Author author = group.SearchAuthor(Integer.parseInt(code));
        ArrayList<Book> books = author.getBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.println("6;" + code +";"+ author.getName() +";"+ books.get(i).getTitle() +";"+ books.get(i).getYear());
        }
    }
    public void getAllAuthorByAnBook(){
        String isbn = in.nextLine();
        Book book = library.searchBook(isbn);
        String name = ";";
        String aux = "7;" + book.getIsbn();
        for (int i = 0; i < book.getAuthors().size(); i++) {
            name = name + library.searchBook(isbn).getAuthors().get(i).getName();
        }
        System.out.println(aux + name);
    }

    public void

    public void getBookByYear(){
        String year = in.nextLine();
        ArrayList<Book> books = library.searchBook(Integer.parseInt(year));
        for (int i = 0; i < books.size(); i++) {
            System.out.println("10;" + books.get(i).getIsbn() + ";" + books.get(i).getTitle() + ";" + books.get(i).getYear());
        }
    }
}
