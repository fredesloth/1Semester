package group01_personmany;

import java.util.ArrayList;

public class Group {
    private String name;
    // association: --> 0..* Person
    private ArrayList<Person> persons = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    // -------------------------------------------------------------------------

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(Person person) {
        persons.remove(person);
    }
}
