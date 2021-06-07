package elements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class PersonManager {

    private final DefaultListModel<Person> personList = new DefaultListModel<>();
    private final String path = "persons.csv";

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

    public Person getNext() {
        List<Person> persons = getPersons();
        Collections.sort(persons);
        return persons.get(0);
    }

    public void save() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Person person : getPersons()) {
                bw.write(person.getName() + ";" + Date.zformatuj(person.getBirthDate()));
                bw.newLine();
            }
        }
    }

    public void load() throws IOException {
        if (new File(path).exists()) {
            personList.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(";");
                    Person person = new Person(data[0], Date.naparsuj(data[1]));
                    personList.addElement(person);
                }
            }
        }
    }
}
