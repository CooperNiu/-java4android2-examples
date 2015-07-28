package app19;
public class UserStat {
    int userCount;

    public int getUserCount() {
        return userCount;
    }

    public void increment() {
        userCount++;
    }

    public void decrement() {
        userCount--;
    }
}