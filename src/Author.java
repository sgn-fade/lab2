import java.io.*;

public class Author extends Human implements Externalizable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String pseudonym;
    public Author(String name, String surname, String pseudonym) {
        this.setName(name);
        this.setSurname(surname);
        this.pseudonym = pseudonym;
    }

    public Author() {
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getName());
        out.writeObject(getSurname());
        out.writeObject(getPseudonym());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setName((String) in.readObject());
        setSurname((String) in.readObject());
        setPseudonym((String) in.readObject());
    }
}
