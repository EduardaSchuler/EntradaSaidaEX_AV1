import java.util.ArrayList;

public class Group {
    private ArrayList<Author> authors;

    public Group() {
        authors = new ArrayList<>();
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public boolean registerNewAuthor(Author author){
        if(authors.contains(author.getCode())){
            return false;
        } else {
            return authors.add(author);
        }
    }

    public Author SearchAuthor(int code){
        for (int i = 0; i < authors.size(); i++) {
            int a = authors.get(i).getCode();
            if (a == code){
                return authors.get(i);
            }
        }
        return null;
    }
}
