import java.io.Serial;
import java.io.Serializable;

public class Author extends Human implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String pseudonym;

    @Override
    public String toString() {
        return "Author{" +
                "pseudonym='" + pseudonym + '\'' +
                '}';
    }

    public Author(String name, String surname, String pseudonym) {
        this.setName(name);
        this.setSurname(surname);
        this.pseudonym = pseudonym;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }
}
