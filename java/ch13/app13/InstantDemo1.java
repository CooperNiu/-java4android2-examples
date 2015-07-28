package app13;
import java.time.Duration;
import java.time.Instant;

public class InstantDemo1 {
    public static void main(String[] args) {
        Instant start = Instant.now();
        // do something here
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }
}