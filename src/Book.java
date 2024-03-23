import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public Book(String name, ArrayList<Author> authors, int publish_year, int publish_number) {
        Name = name;
        this.authors = authors;
        this.publish_year = publish_year;
        this.publish_number = publish_number;
    }

    private String Name;

    @Override
    public String toString() {
        return "Book{" +
                "Name='" + Name + '\'' +
                ", authors=" + authors +
                ", publish_year=" + publish_year +
                ", publish_number=" + publish_number +
                '}';
    }

    private ArrayList<Author> authors;
    private int publish_year;
    private int publish_number;

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
}
