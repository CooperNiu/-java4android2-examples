package app09;
import java.util.Scanner;

public class NumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        try {
            int i = Integer.parseInt(userInput);
            System.out.println("The number entered: " + i);
        } catch (NumberFormatException e) {
            System.out.println("Invalid user input");
        }
    }
}