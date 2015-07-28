package app18;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

interface Logger {
    public void log(String message);
}

public class LocalClassDemo1 {
    String appStartTime = LocalDateTime.now().format(
            DateTimeFormatter
            .ofLocalizedDateTime(FormatStyle.MEDIUM));
    public Logger getLogger() {
        class LoggerImpl implements Logger {
            public void log(String message) {
                System.out.println(appStartTime + " : " + message);
            }
        }
        return new LoggerImpl();
    }
  
    public static void main(String[] args) {
        LocalClassDemo1 test = new LocalClassDemo1();
        Logger logger = test.getLogger();
        logger.log("Local class example");
    }
}