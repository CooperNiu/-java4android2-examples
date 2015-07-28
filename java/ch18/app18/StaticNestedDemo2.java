package app18;
class Outer2 {
    private static int value = 9;
    static class Nested2 {
        int value = 10;
        int calculate() {
            return value; 
        }
        int getOuterValue() {
            return Outer2.value;
        }
    }
}

public class StaticNestedDemo2 {
    public static void main(String[] args) {
        Outer2.Nested2 nested = new Outer2.Nested2();
        System.out.println(nested.calculate());     // returns 10
        System.out.println(nested.getOuterValue()); // returns 9
    }
}