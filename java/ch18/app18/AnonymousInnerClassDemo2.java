package app18;
abstract class Printable2 {
    void print(String message) {
    }
}

public class AnonymousInnerClassDemo2 {
    public static void main(String[] args) {
        Printable2 printer = new Printable2() {
            public void print(String message) {
                System.out.println(message);
            }
        }; // this is a semicolon

        printer.print("Beach Music");
    }
}