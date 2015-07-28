package app16;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ObjectSerializationDemo1 {

    public static void main(String[] args) {
        // Serialize
        Path path = Paths.get("C:\\temp\\objectOutput");
        Customer customer = new Customer(1, "Joe Blog", 
                "12 West Cost");
        try (OutputStream outputStream = 
                Files.newOutputStream(path, 
                        StandardOpenOption.CREATE);
            ObjectOutputStream oos = new 
                    ObjectOutputStream(outputStream)) {

            // write first object
            oos.writeObject(customer);
            // write second object
            oos.writeObject("Customer Info");
        } catch (IOException e) {
            System.out.print("IOException");
        }

        // Deserialize
        try (InputStream inputStream = Files.newInputStream(path, 
                StandardOpenOption.READ);
            ObjectInputStream ois = new 
                    ObjectInputStream(inputStream)) {
            // read first object
            Customer customer2 = (Customer) ois.readObject();
            System.out.println("First Object: ");
            System.out.println(customer2.id);
            System.out.println(customer2.name);
            System.out.println(customer2.address);

            // read second object
            System.out.println();
            System.out.println("Second object: ");
            String info = (String) ois.readObject();
            System.out.println(info);
        } catch (ClassNotFoundException ex) { // readObject still throws this exception
            System.out.print("ClassNotFound " + ex.getMessage());
        } catch (IOException ex2) {
            System.out.print("IOException " + ex2.getMessage());
        }
    }
}