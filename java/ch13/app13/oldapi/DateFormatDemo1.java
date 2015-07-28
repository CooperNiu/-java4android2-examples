package app13.oldapi;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
public class DateFormatDemo1 {
    public static void main(String[] args) {
        DateFormat shortDf = 
                DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat mediumDf =
                DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat longDf = 
                DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat fullDf = 
                DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(shortDf.format(new Date()));
        System.out.println(mediumDf.format(new Date()));
        System.out.println(longDf.format(new Date()));
        System.out.println(fullDf.format(new Date()));
        
        // parsing
        try {
            Date date = shortDf.parse("12/12/2016");
        } catch (ParseException e) {
        }
    }
}