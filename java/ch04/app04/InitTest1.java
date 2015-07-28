package app04;

public class InitTest1 {
    int x = 3;
    int y;
    // instance initialization code
    {
        y = x * 2;
        System.out.println(y);
    }
    
    // static initialization code
    static {
        System.out.println("Static initialization");
    }
    public static void main(String[] args) {
        InitTest1 test = new InitTest1();
        InitTest1 moreTest = new InitTest1();
    }
}