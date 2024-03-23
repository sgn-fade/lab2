import java.util.ArrayList;

public class BookReader extends Human {
    private int id;
    private ArrayList<Book> books;

    public BookReader(String name, String surname, int id, ArrayList<Book> books) {
        this.setName(name);
        this.setSurname(surname);
        this.id = id;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
