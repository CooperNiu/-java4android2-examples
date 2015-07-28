package app07;
class Parent {
    public Parent(String s) {
        System.out.println("Parent(String)");
    }
}

public class Child extends Parent {
    /* compile error */
    public Child() {
    }
}