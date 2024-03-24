import java.io.*;
import java.util.ArrayList;

public class Library implements Serializable {
    private String name;
    private transient ArrayList<BookReader> readers;
    private ArrayList<BookStore> stores;
    public Library(String name, ArrayList<BookReader> readers, ArrayList<BookStore> stores) {
        this.name = name;
        this.readers = readers;
        this.stores = stores;
    }
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(readers.size());
        for (BookReader r : readers) {
            out.writeObject(r.getName());
            out.writeObject(r.getSurname());
            out.writeInt(r.getId());
            out.writeInt(r.getBooks().size());
            for (Book b : r.getBooks()) {
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
    }
    @Serial
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        readers = new ArrayList<>();
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            BookReader reader = new BookReader((String) in.readObject(), (String) in.readObject(), in.readInt());
            int bookSize = in.readInt();
            ArrayList<Book> books = new ArrayList<>();
            for (int j = 0; j < bookSize; j++) {
                Book b = new Book((String) in.readObject(), in.readInt(), in.readInt());
                int authorSize = in.readInt();
                ArrayList<Author> authors = new ArrayList<>();
                for (int k = 0; k < authorSize; k++) {
                    Author a = new Author((String) in.readObject(), (String) in.readObject(), (String) in.readObject());
                    authors.add(a);
                }
                b.addAuthors(authors);
                books.add(b);
            }
            reader.addBooks(books);
            readers.add(reader);

        }
    }

    public void setReaders(ArrayList<BookReader> readers) {
        this.readers = readers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BookReader> getReaders() {
        return readers;
    }

    public ArrayList<BookStore> getStores() {
        return stores;
    }

    public void setStores(ArrayList<BookStore> stores) {
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", readers=" + readers +
                ", stores=" + stores +
                '}';
    }
}
