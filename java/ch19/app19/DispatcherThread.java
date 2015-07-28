package app19;

public class DispatcherThread extends Thread {
    private DeliveryNoteHolder deliveryNoteHolder;

    String[] deliveryNotes = { "XY23. 1234 Arnie Rd.", 
            "XY24. 3330 Quebec St.",
            "XY25. 909 Swenson Ave.", 
            "XY26. 4830 Davidson Blvd.",
            "XY27. 9900 Old York Dr." };

    public DispatcherThread(DeliveryNoteHolder holder) {
        deliveryNoteHolder = holder;
    }

    public void run() {
        for (int i = 0; i < deliveryNotes.length; i++) {
            String deliveryNote = deliveryNotes[i];
            deliveryNoteHolder.put(deliveryNote);
            try {
                sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}