package app15;
import java.util.ArrayList;
import java.util.List;

public class WildCardDemo1 {
    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("World");
        printList(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(200);
        printList(list2);
    }
}