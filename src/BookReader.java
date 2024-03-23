import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class BookReader extends Human implements Serializable {
    @Override
    public String toString() {
        return "BookReader{" +
                "id=" + id +
                ", books=" + books +
                '}';
    }

    @Serial
    private static final long serialVersionUID = 1L;
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
