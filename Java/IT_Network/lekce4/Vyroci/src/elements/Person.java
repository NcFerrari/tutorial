package elements;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person implements Comparable<Person> {

    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Jméno je příliš krátké");
        }
        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Datum narození nesmí být v budoucnosti");
        }
        if (name.contains(";")) {
            throw new IllegalArgumentException("Jméno nesmí obsahovat středník");
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

    public int countAge() {
        return (int) getBirthDate().until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public int getDaysToNextBirth() {
        LocalDate birthDay = getBirthDate().withYear(LocalDate.now().getYear());
        if (birthDay.isBefore(LocalDate.now())) {
            birthDay = birthDay.plusYears(1);
        }
        return (int) LocalDate.now().until(birthDay, ChronoUnit.DAYS);
    }

    @Override
    public int compareTo(Person person) {
        return this.getDaysToNextBirth() - person.getDaysToNextBirth();
    }

    @Override
    public String toString() {
        return getName();
    }

}
