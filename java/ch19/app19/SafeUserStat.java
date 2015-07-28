package app19;
public class SafeUserStat {
    int userCount;

    public synchronized int getUserCount() {
        return userCount;
    }

    public synchronized void increment() {
        userCount++;
    }

    public synchronized void decrement() {
        userCount--;
    }
}