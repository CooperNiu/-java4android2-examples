package app20;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    AtomicInteger userCount = new AtomicInteger(0);

    public int getUserCount() {
        return userCount.get();
    }

    public void increment() {
        userCount.getAndIncrement();
    }

    public void decrement() {
        userCount.getAndDecrement();
    }
}