package app05;
public class ClassDemo {
    public static void main(String[] args) {
        String country = "Fiji";
        Class myClass = country.getClass();
        System.out.println(myClass.getName());
        Class klass = null;
        try {
            klass = Class.forName("app05.Test");
        } catch (ClassNotFoundException e) {
        }

        if (klass != null) {
            try {
                Test test = (Test) klass.newInstance();
                test.print();
            } catch (IllegalAccessException e) {
            } catch (InstantiationException e) {
            }
        }
    }
}