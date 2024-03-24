import java.io.*;
import java.util.ArrayList;

public class BookStore implements Externalizable {
    @Serial
    private static final long serialVersionUID = 1L;
    private ArrayList<Book> books;
    private String storeName;

    public BookStore(ArrayList<Book> books, String storeName) {
        this.books = books;
        this.storeName = storeName;
    }

    public BookStore() {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getStoreName());
        out.writeInt(books.size());
        for(Externalizable b: books) {
            b.writeExternal(out);
        }
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "books=" + books +
                ", storeName='" + storeName + '\'' +
                '}';
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setStoreName((String) in.readObject());
        int bookSize = in.readInt();
        books = new ArrayList<>();

        for (int i = 0; i < bookSize; i++) {
            Book ext = new Book();
            ext.readExternal(in);
            books.add(ext);
        }
    }
}
