public class Author extends Human {
    private String pseudonym;
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
