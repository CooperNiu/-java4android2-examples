package app18;
class TopLevel {
    private int value = 9;
    class Inner {
        int calculate() {
            return value; 
        }
    }
}

public class MemberInnerDemo1 {
    public static void main(String[] args) {
        TopLevel topLevel = new TopLevel ();
        TopLevel.Inner inner = topLevel.new Inner();
        System.out.println(inner.calculate());
    }
}