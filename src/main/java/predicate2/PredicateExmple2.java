package predicate2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExmple2 {

    public static void main(String[] args) {
        List<Person> persons = PersonFactory.createPersons();

        List<Person> filteredPersons = getFiltered(persons, PersonPredicates.getSpesificZipPersonPredicate(50131));

        filteredPersons.forEach(System.out::println);

    }

    public static List<Person> getFiltered(List<Person> persons, Predicate<Person> personPredicate){
        List<Person> filteredPersons = new ArrayList<>();
        for (Person p : persons){
            if (personPredicate.test(p)){
                filteredPersons.add(p);
            }
        }

        return filteredPersons;

    }
}
