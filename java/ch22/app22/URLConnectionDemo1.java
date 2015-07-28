package app22;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLConnectionDemo1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.java.com/");
            URLConnection urlConnection = url.openConnection();
            Map<String, List<String>> headers = 
                    urlConnection.getHeaderFields();
            Set<Map.Entry<String, List<String>>> entrySet = 
                    headers.entrySet();
            for (Map.Entry<String, List<String>> entry : entrySet){
                String headerName = entry.getKey();
                System.out.println("Header Name:" + headerName);
                List<String> headerValues = entry.getValue();
                for (String value : headerValues) {
                    System.out.print("Header value:" + value);
                }
                System.out.println();
                System.out.println();
            }
            InputStream inputStream = 
                    urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(inputStream));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}