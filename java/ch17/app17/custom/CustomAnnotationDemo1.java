package app17.custom;

public class CustomAnnotationDemo1 {
    public static void printClassInfo(Class c) {
        System.out.print(c.getName() + ". ");
        Author author = (Author) c.getAnnotation(Author.class);
        if (author != null) {
            System.out.println("Author:" + author.firstName() 
                    + " " + author.lastName());
        } else {
            System.out.println("Author unknown");
        }    
    }

    public static void main(String[] args) {
        CustomAnnotationDemo1.printClassInfo(Test1.class);
        CustomAnnotationDemo1.printClassInfo(Test2.class);
        CustomAnnotationDemo1.printClassInfo(Test3.class);
        CustomAnnotationDemo1.printClassInfo(
                CustomAnnotationDemo1.class);
    }
}