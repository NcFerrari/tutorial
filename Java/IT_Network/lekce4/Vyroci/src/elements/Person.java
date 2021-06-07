package elements;

import java.time.LocalDate;

public class Person {

    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Jméno je příliš krátké");
        }
        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Datum narození nesmí být v budoucnosti");
        }
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return getName();
    }

}
