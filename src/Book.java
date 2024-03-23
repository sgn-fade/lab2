import java.util.ArrayList;

public class Book {
    private String Name;
    private ArrayList<Author> authors;
    private int publishYear;
    private int publishNumber;

    @Override
    public String toString() {
        return "Book{" +
                "Name='" + Name + '\'' +
                ", authors=" + authors +
                ", publishYear=" + publishYear +
                ", publishNumber=" + publishNumber +
                '}';
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

    public void addAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public Book(String name, int publishYear, int publishNumber) {
        Name = name;
        this.publishYear = publishYear;
        this.publishNumber = publishNumber;
    }

    public Book(String name, ArrayList<Author> authors, int publishYear, int publishNumber) {
        Name = name;
        this.authors = authors;
        this.publishYear = publishYear;
        this.publishNumber = publishNumber;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPublishNumber() {
        return publishNumber;
    }

    public void setPublishNumber(int publishNumber) {
        this.publishNumber = publishNumber;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
}
