package app14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListDemo2 {
    public static void main(String[] args) {
        List numbers = Arrays.asList(9, 4, -9, 100);
        Collections.sort(numbers);
        for (Object i : numbers) {
            System.out.println(i);
        }
    }
}