import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class BookStore implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private ArrayList<Book> books;
    private String storeName;

    @Override
    public String toString() {
        return "BookStore{" +
                "books=" + books +
                ", storeName='" + storeName + '\'' +
                '}';
    }

    public BookStore(ArrayList<Book> books, String storeName) {
        this.books = books;
        this.storeName = storeName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
