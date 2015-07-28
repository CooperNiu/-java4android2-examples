package app18;
interface Printable {
    void print(String message);
}

public class AnonymousInnerClassDemo1 {
    public static void main(String[] args) {

        Printable printer = new Printable() {
            public void print(String message) {
                System.out.println(message);
            }
        }; // this is a semicolon

        printer.print("Beach Music");
    }
}