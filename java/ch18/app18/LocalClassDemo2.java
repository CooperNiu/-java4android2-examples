package app18;
import java.util.Date;

interface PrefixLogger {
    public void log(String message);
}

public class LocalClassDemo2 {
    public PrefixLogger getLogger(final String prefix) {
        class LoggerImpl implements PrefixLogger {
            public void log(String message) {
                System.out.println(prefix + " : " + message);
            }
        }
        return new LoggerImpl();
    }
  
    public static void main(String[] args) {
        LocalClassDemo2 test = new LocalClassDemo2();
        PrefixLogger logger = test.getLogger("DEBUG");
        logger.log("Local class example");
    }
}