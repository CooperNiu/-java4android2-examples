package app22;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com/");
            InputStream inputStream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(inputStream));
            String line = bufferedReader.readLine();
            while (line!= null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}