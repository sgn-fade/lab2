import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private ArrayList<BookReader> readers;
    private ArrayList<BookStore> stores;

    public Library(String name, ArrayList<BookReader> readers, ArrayList<BookStore> stores) {
        this.name = name;
        this.readers = readers;
        this.stores = stores;
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

    public void setReaders(ArrayList<BookReader> readers) {
        this.readers = readers;
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
