package app19;
public class ThreadCoordinationDemo {
    public static void main(String[] args) {
        DeliveryNoteHolder c = new DeliveryNoteHolder();
        DispatcherThread dispatcherThread = 
                new DispatcherThread(c);
        DriverThread driverThread1 = new DriverThread(c, "Eddie");
        dispatcherThread.start();
        driverThread1.start();
    }
}