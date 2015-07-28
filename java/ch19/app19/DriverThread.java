package app19;
public class DriverThread extends Thread {
    DeliveryNoteHolder deliveryNoteHolder;
    boolean stopped = false;
    String driverName;

    public DriverThread(DeliveryNoteHolder holder, String    
                driverName) {
        deliveryNoteHolder = holder;
        this.driverName = driverName;
    }

    public void run() {
        while (!stopped) {
            String deliveryNote = deliveryNoteHolder.get();
            try {
                sleep(300);
            } catch (InterruptedException e) {
            }
        }
    }
}