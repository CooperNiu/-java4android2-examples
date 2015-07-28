package app14;
import java.util.Arrays;

public class ElephantTest {
    public static void main(String[] args) {
        Elephant elephant1 = new Elephant();
        elephant1.weight = 100.12F;
        elephant1.age = 20;
        Elephant elephant2 = new Elephant();
        elephant2.weight = 120.12F;
        elephant2.age = 20;
        Elephant elephant3 = new Elephant();
        elephant3.weight = 100.12F;
        elephant3.age = 25;
        
        Elephant[] elephants = new Elephant[3];
        elephants[0] = elephant1;
        elephants[1] = elephant2;
        elephants[2] = elephant3;
        
        System.out.println("Before sorting");
        for (Elephant elephant : elephants) {
            System.out.println(elephant.weight + ":" + 
                    elephant.age);
        }
        Arrays.sort(elephants);
        System.out.println("After sorting");
        for (Elephant elephant : elephants) {
            System.out.println(elephant.weight + ":" + 
                    elephant.age);
        }
    }
}