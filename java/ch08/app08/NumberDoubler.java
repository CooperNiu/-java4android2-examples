package app08;
import java.util.Scanner;

public class NumberDoubler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        try {
            double number = Double.parseDouble(input);
            System.out.printf("Result: %s", number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
        scanner.close();
    }
}