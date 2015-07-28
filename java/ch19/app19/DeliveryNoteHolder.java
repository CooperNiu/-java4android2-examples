package app19;
public class DeliveryNoteHolder {
    private String deliveryNote;
    private boolean available = false;

    public synchronized String get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        available = false;
        System.out.println(System.currentTimeMillis() 
                + ": got " + deliveryNote);
        notifyAll();
        return deliveryNote;
    }

    public synchronized void put(String deliveryNote) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        this.deliveryNote = deliveryNote;
        available = true;
        System.out.println(System.currentTimeMillis() + 
                ": Put " + deliveryNote);
        notifyAll();
    }
}