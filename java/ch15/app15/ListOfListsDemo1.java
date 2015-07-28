package app15;
import java.util.ArrayList;
import java.util.List;
public class ListOfListsDemo1 {
    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Hello again");
        List<List<String>> listOfLists = 
                new ArrayList<>();
        listOfLists.add(listOfStrings);
        String s = listOfLists.get(0).get(0);
        System.out.println(s); // prints "Hello again"
    }
}