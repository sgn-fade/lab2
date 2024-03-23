import java.util.ArrayList;

public class Book {
    private String Name;
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
