import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Joanne", "Rowling", "none"));
        books.add(new Book("Harry Potter", authors, 1997, 1));
        ArrayList<BookReader> readers = new ArrayList<>();
        readers.add(new BookReader("Ivan", "Migun", 1, books));
        ArrayList<BookStore> store = new ArrayList<>();
        store.add(new BookStore(books, "fantasy"));
        Library library =  new Library("first lib", readers, store);

        serializeObject("library.ser", library);
        System.out.println(deSerializeObject("library.ser"));
    }

    public static void serializeObject(String fileName, Object obj) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new
                    FileOutputStream(fileName));
            os.writeObject(obj);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Object deSerializeObject(String fileName) {
        Object obj = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new
                    FileInputStream(fileName));
            obj = is.readObject();
            is.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
}
