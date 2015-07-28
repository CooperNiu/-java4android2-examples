package app09;
import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double balance = 9.99;
        balance -= 0.10F;
        System.out.println(balance); // prints 9.889999769628048

        BigDecimal balance2 = BigDecimal.valueOf(9.99);
        BigDecimal accountFee = BigDecimal.valueOf(.1);
        BigDecimal r = balance2.subtract(accountFee);
        System.out.println(r.doubleValue()); // prints 9.89
    }
}