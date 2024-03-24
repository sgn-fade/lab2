import java.io.*;
import java.util.ArrayList;

public class BookReader extends Human implements Externalizable {
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

    public BookReader() {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getId());
        out.writeInt(books.size());
        for(Externalizable b: books) {
           b.writeExternal(out);
        }
    }

    @Override
    public String toString() {
        return "BookReader{" +
                "id=" + id +
                ", books=" + books +
                '}';
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setId(in.readInt());
        int bookSize = in.readInt();
        books = new ArrayList<>();

        for (int i = 0; i < bookSize; i++) {
            Book ext = new Book();
            ext.readExternal(in);
            books.add(ext);
        }
    }
}
