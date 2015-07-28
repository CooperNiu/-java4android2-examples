package app14;

public class Person implements Comparable {
    private String firstName;
    private String lastName;
    private int age;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int compareTo(Object anotherPerson) 
            throws ClassCastException {
        if (!(anotherPerson instanceof Person)) {
            throw new ClassCastException(
                    "A Person object expected.");
        }
        int anotherPersonAge = ((Person) anotherPerson).getAge();
        return this.age - anotherPersonAge;
    }
}