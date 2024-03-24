import java.io.*;
import java.util.ArrayList;

public class Book implements Externalizable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String Name;
    private ArrayList<Author> authors;
    private int publish_year;
    private int publish_number;

    public Book() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Author> getAuthor() {
        return authors;
    }

    public void addAuthor(ArrayList<Author> authors) {
        this.authors = authors;
    }


    public int getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(int publish_year) {
        this.publish_year = publish_year;
    }

    public int getPublish_number() {
        return publish_number;
    }

    public void setPublish_number(int publish_number) {
        this.publish_number = publish_number;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getName());
        out.writeInt(authors.size());
        for(Author author: authors) {
            out.writeObject(author);
        }
        out.writeInt(getPublish_year());
        out.writeInt(getPublish_number());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setName((String) in.readObject());
        int authSize = in.readInt();
        for (int i = 0; i < authSize; i++) {
            authors.add((Author) in.readObject());
        }
        setPublish_year(in.readInt());
        setPublish_number(in.readInt());
    }

    public Book(String name, int publish_year, int publish_number) {
        Name = name;
        this.publish_year = publish_year;
        this.publish_number = publish_number;
    }

    public Book(String name, ArrayList<Author> authors, int publish_year, int publish_number) {
        Name = name;
        this.authors = authors;
        this.publish_year = publish_year;
        this.publish_number = publish_number;
    }
}
