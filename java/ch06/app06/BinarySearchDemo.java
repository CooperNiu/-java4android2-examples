package app06;
import java.util.Arrays;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19 };
        int index = Arrays.binarySearch(primes, 13);
        System.out.println(index); // prints 5
        index = Arrays.binarySearch(primes, 4);
        System.out.println(index); // prints -3
    }
}