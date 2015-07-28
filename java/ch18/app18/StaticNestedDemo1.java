package app18;
class Outer1 {
    private static int value = 9;
    static class Nested1 {
        int calculate() {
            return value; 
        }
    }
}

public class StaticNestedDemo1 {
    public static void main(String[] args) {
        Outer1.Nested1 nested = new Outer1.Nested1();
        System.out.println(nested.calculate());
    }
}