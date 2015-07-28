package app16;
import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    public int id;
    public String name;
    public String address;
    public Customer (int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}