import java.io.*;
import java.util.ArrayList;

public class BookStore implements Serializable {
    private transient ArrayList<Book> books;
    private String storeName;

    public BookStore(ArrayList<Book> books, String storeName) {
        this.books = books;
        this.storeName = storeName;
    }
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(books.size());
        for (Book b : books) {
            out.writeObject(b.getName());
            out.writeInt(b.getPublishYear());
            out.writeInt(b.getPublishNumber());
            out.writeInt(b.getAuthors().size());
            for (Author a : b.getAuthors()) {
                out.writeObject(a.getName());
                out.writeObject(a.getSurname());
                out.writeObject(a.getPseudonym());
            }
        }
    }
    @Serial
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        books = new ArrayList<>();
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            Book b = new Book((String)in.readObject(), in.readInt(), in.readInt());
            int authorSize = in.readInt();
            ArrayList<Author> authors = new ArrayList<>();
            for (int j = 0; j < authorSize; j++) {
                Author a = new Author((String) in.readObject(), (String) in.readObject(), (String) in.readObject());
                authors.add(a);
            }
            b.addAuthors(authors);
        }
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
    public String toString() {
        return "BookStore{" +
                "books=" + books +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
