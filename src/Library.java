import java.io.*;
import java.util.ArrayList;

public class Library implements Externalizable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private ArrayList<BookReader> readers;
    private ArrayList<BookStore> stores;

    public Library() {
    }

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
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getName());
        out.writeInt(readers.size());
        for(Externalizable reader : readers){
            reader.writeExternal(out);

        }
        out.writeInt(stores.size());
        for(Externalizable store: stores){
            store.writeExternal(out);

        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", readers=" + readers +
                ", stores=" + stores +
                '}';
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setName((String) in.readObject());
        int readersSize = in.readInt();
        readers = new ArrayList<>();

        for (int i = 0; i < readersSize; i++) {
            BookReader ext = new BookReader();
            ext.readExternal(in);
            readers.add(ext);
        }
        int storesSize = in.readInt();
        stores = new ArrayList<>();

        for (int i = 0; i < storesSize; i++) {
            BookStore ext = new BookStore();
            ext.readExternal(in);
            stores.add(ext);
        }
    }
}
