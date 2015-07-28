package app04;
import java.time.LocalDate;

public class Discount {
    private int value;
    private Discount(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static Discount createSmallCustomerDiscount() {
        return new Discount(10);
    }

    public static Discount createBigCustomerDiscount() {
        return new Discount(12);
    }
}