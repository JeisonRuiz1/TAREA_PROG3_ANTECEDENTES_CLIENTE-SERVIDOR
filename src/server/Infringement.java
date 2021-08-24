package server;

public class Infringement {

    private Person person;
    private String infringement;

    public Infringement(Person person, String infringement){
        this.person = person;
        this.infringement = infringement;
    }

    public Person getPerson() {
        return person;
    }
}
