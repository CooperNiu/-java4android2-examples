package app22;
import java.net.URL;

public class URLDemo1 {
    public static void main(String[] args) throws Exception {
        URL url = new URL(
          "http://www.yahoo.com:80/en/index.html?name=john#first");
        System.out.println("protocol:" + url.getProtocol());
        System.out.println("port:" + url.getPort());
        System.out.println("host:" + url.getHost());
        System.out.println("path:" + url.getPath());
        System.out.println("file:" + url.getFile());
        System.out.println("query:" + url.getQuery());
        System.out.println("ref:" + url.getRef());
    }
}