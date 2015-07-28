package app15;

import java.util.Collections;
import java.util.List;

public class GenericMethodDemo1 {
    public static <T> boolean compare(T obj1, T obj3, List<T> obj2) {
        return obj1.equals(obj2);
    }
    
    public static void main(String[] args) {
        compare(new Integer(2), "", Collections.emptyList());
        
        List<Integer> l = Collections.<Integer>emptyList();
        System.out.println(l);
        Collections.emptyList();
    }
}
