package predicate2;

import java.util.function.Predicate;

public class PersonPredicates {
    public static Predicate<Person> malePersonPredicate = person -> person.getGender().equals(Gender.MALE);

    public static Predicate<Person> femalePersonPredicate = person -> person.getGender().equals(Gender.FEMALE);

    public static Predicate<Person> getSpesificZipPersonPredicate(int zip){
        return person -> person.getAreaCode() == zip ;
    }

}
