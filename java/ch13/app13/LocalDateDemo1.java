package app13;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo1 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate oneDecadeAgo = today.minus(1, 
                ChronoUnit.DECADES);
        System.out.println("Day of month: " 
                + today.getDayOfMonth());
        System.out.println("Today is " + today);
        System.out.println("Tomorrow is " + tomorrow);
        System.out.println("A decade ago was " + oneDecadeAgo);
        System.out.println("Year : " 
                + today.get(ChronoField.YEAR));
        System.out.println("Day of year:" + today.getDayOfYear());    
    }
}