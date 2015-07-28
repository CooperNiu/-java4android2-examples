package app14;
import java.util.Comparator;

public class LastNameComparator implements Comparator {
    public int compare(Object person, Object anotherPerson) {
        String lastName1 = ((Person) 
                person).getLastName().toUpperCase();
        String firstName1 = 
                ((Person) person).getFirstName().toUpperCase();
        String lastName2 = ((Person) 
                anotherPerson).getLastName().toUpperCase();
        String firstName2 = ((Person) anotherPerson).getFirstName()
                .toUpperCase();
        if (lastName1.equals(lastName2)) {
            return firstName1.compareTo(firstName2);
        } else {
            return lastName1.compareTo(lastName2);
        }
    }
}