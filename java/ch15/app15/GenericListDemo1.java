package app15;
import java.util.List;
import java.util.ArrayList;

public class GenericListDemo1 {
    public static void main(String[] args) {
        // without generics
        List stringList1 = new ArrayList();
        stringList1.add("Java");
        stringList1.add("without generics");
        // cast to java.lang.String
        String s1 = (String) stringList1.get(0);
        System.out.println(s1.toUpperCase());
    
        // with generics and diamond
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("Java");
        stringList2.add("with generics");
        // no type casting is necessary
        String s2 = stringList2.get(0);
        System.out.println(s2.toUpperCase());
    }
}