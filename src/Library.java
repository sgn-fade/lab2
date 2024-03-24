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
        for(BookReader reader : readers){
            out.writeObject(reader);
        }
        out.writeInt(stores.size());
        for(BookStore store: stores){
            out.writeObject(store);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setName((String) in.readObject());
        int readersSize = in.readInt();
        for (int i = 0; i < readersSize; i++) {
            readers.add((BookReader) in.readObject());
        }
        int storesSize = in.readInt();
        for (int i = 0; i < storesSize; i++) {
            stores.add((BookStore) in.readObject());
        }
    }
}
