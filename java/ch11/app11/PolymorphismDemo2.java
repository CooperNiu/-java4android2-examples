package app11;
import java.util.Scanner;

public class PolymorphismDemo2 {

    public static void main(String[] args) {
        String instruction = "What is your chosen language?" +
                "\nType 'English' or 'French'.";
        Greeting greeting = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println(instruction);
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("english")) {
                greeting = new EnglishGreeting();
                break;
            } else if (input.equalsIgnoreCase("french")) {
                greeting = new FrenchGreeting();
                break;
            } else {
                System.out.println(instruction);
            }
        }

        scanner.close();
        greeting.greet();
    }
}