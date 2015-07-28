package app04;
public class InitTest2 {
    int x = 3;
    int y;
    // instance initialization code
    public InitTest2() {
        y = x * 2;
        System.out.println(y);
    }
    // static initialization code
    static {
        System.out.println("Static initialization");
    }
    public static void main(String[] args) {
        InitTest2 test = new InitTest2();
        InitTest2 moreTest = new InitTest2();
    }
}