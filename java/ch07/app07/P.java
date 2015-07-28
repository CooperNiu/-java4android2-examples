package app07;
public class P {
    public void publicMethod() {
    }
    protected void protectedMethod() {
    }
    void defaultMethod() {
    }
}
class C extends P {
    public void testMethods() {
        publicMethod();
        protectedMethod();
        defaultMethod();
    }
}