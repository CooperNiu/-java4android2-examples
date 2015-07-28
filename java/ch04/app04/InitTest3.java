package app04;

public class InitTest3 {
    int x = 3;
    int y;
    // instance initialization code
    public InitTest3() {
        init();
    }
    public InitTest3(int x) {
        this.x = x;
        init();
    }
    private void init() {
        y = x * 2;
        System.out.println(y);
    }
    // static initialization code
    static {
        System.out.println("Static initialization");
    }
    public static void main(String[] args) {
        InitTest3 test = new InitTest3();
        InitTest3 moreTest = new InitTest3();
    }
}