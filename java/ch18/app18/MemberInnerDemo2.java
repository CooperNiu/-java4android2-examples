package app18;
interface Printer {
    void print(String message);
}
class PrinterImpl implements Printer {
    public void print(String message) {
        System.out.println(message);
    }
}
class SecretPrinterImpl {
    private class Inner implements Printer {
        public void print(String message) {
            System.out.println("Inner:" + message);
        }
    }
    public Printer getPrinter() {
        return new Inner();
    }
}
public class MemberInnerDemo2 {
    public static void main(String[] args) {
        Printer printer = new PrinterImpl();
        printer.print("oh");
        // downcast to PrinterImpl
        PrinterImpl impl = (PrinterImpl) printer;
  
        Printer hiddenPrinter = 
                (new SecretPrinterImpl()).getPrinter();
        hiddenPrinter.print("oh");
        // cannot downcast hiddenPrinter to Outer.Inner 
        // because Inner is private
    }
}