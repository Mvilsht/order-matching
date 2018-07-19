package predicate_simple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicatesQuestion {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person(20, Gender.MALE),
                new Person(45, Gender.FEMALE), new Person(50, Gender.MALE),
                new Person(65, Gender.MALE));

        people.stream()
                .filter(personIsBetweenAges(16, 25))
                .forEach(person -> {
                    System.out.println(person.getAge() + ", " + person.getGender());
                });

        people.stream()
                .filter(couldBePilot().and(personIsBetweenAges(45, 56)))
                .forEach(person -> {
                    System.out.println(person.getAge() + ", " + person.getGender());
                });

    }


    private static Predicate<Person> personIsMale() {
        return person -> person.getGender() == Gender.MALE;
    }

    private static Predicate<Person> personIsBetweenAges(int lower, int upper) {
        return personIsAtLeast(lower).and(personIsYoungerThan(upper));
    }

    private static Predicate<Person> personIsAtLeast(int age) {
        return person -> person.getAge() >= age;
    }

    private static Predicate<Person> personIsYoungerThan(int age) {
        return person -> person.getAge() < age;
    }

    private static Predicate<Person> personIsOfDrivingAge() {
        return personIsAtLeast(17);
    }

    private static Predicate<Person> couldBePilot() {
        return personIsBetweenAges(23, 65).and(personIsMale());

    }

}
