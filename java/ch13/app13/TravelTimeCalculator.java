package app13;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TravelTimeCalculator {
    
    public Duration calculateTravelTime(
            ZonedDateTime departure, ZonedDateTime arrival) {
        return Duration.between(departure, arrival);
    }

    public static void main(String[] args) {
        TravelTimeCalculator calculator = 
                new TravelTimeCalculator();
        ZonedDateTime departure1 = ZonedDateTime.of(
                LocalDateTime.of(2014, Month.MARCH, 8, 
                        8, 0), 
                ZoneId.of("America/Denver"));
        ZonedDateTime arrival1 = ZonedDateTime.of(
                LocalDateTime.of(2014, Month.MARCH, 9, 
                        8, 0), 
                ZoneId.of("America/Toronto"));
        Duration travelTime1 = calculator
                .calculateTravelTime(departure1, arrival1);
        System.out.println("Travel time 1: " 
                + travelTime1.toHours() + " hours");
        
        ZonedDateTime departure2 = ZonedDateTime.of(
                LocalDateTime.of(2014, Month.MARCH, 18, 
                        8, 0), 
                ZoneId.of("America/Denver"));
        ZonedDateTime arrival2 = ZonedDateTime.of(
                LocalDateTime.of(2014, Month.MARCH, 19, 
                        8, 0), 
                ZoneId.of("America/Toronto"));
        Duration travelTime2 = calculator
                .calculateTravelTime(departure2, arrival2);
        System.out.println("Travel time 2: " 
                + travelTime2.toHours() + " hours");
    }
}