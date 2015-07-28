package app05;
import java.io.IOException;

public class InputDemo {
    public String getUserInput() {
        StringBuilder sb = new StringBuilder();
        try {
            char c = (char) System.in.read();
            while (c != '\r' && c != '\n') {
                sb.append(c);
                c = (char) System.in.read();
            }
        } catch (IOException e) {
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        InputDemo demo = new InputDemo();
        String input = demo.getUserInput();
        System.out.println(input);
    }
}