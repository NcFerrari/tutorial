package elements;

import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class PersonManager {

    private final DefaultListModel<Person> personList = new DefaultListModel<>();

    public ListModel getModel() {
        return personList;
    }

    public void addPerson(Person person) {
        personList.addElement(person);
    }

    public void removePerson(Person person) {
        personList.removeElement(person);
    }

    public List<Person> getPersons() {
        return Collections.list(personList.elements());
    }
}
