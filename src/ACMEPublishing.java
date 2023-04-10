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
            in = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
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
        showAllBooksByAnAuthor();
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
                library.getBooks().add(book);
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
                group.getAuthors().add(author);
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
        String isbn;
        do {
            code = in.nextLine();
            if (code.equals("-1"))
                break;
            isbn = in.nextLine();
            Book book = library.searchBook(isbn);
            Author author = group.SearchAuthor(Integer.parseInt(code));
            group.SearchAuthor(Integer.parseInt(code)).addBook(book);
            library.searchBook(isbn).addAuthor(author);

            System.out.println("5;" + code +";"+ author.getName() +";"+ isbn +";"+ book.getTitle() +";"+ book.getYear());
        } while (code != "-1");
    }

    public void showAllBooksByAnAuthor(){
        String code = in.nextLine();
        Author author = group.SearchAuthor(Integer.parseInt(code));
        ArrayList<Book> books = author.getBooksByAuthor();
        for (int i = 0; i < books.size(); i++) {
            System.out.println("6;" + code +";"+ author.getName() +";"+ books.get(i).getTitle() +";"+ books.get(i).getYear());
        }
    }

}
