package app22.webserver;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 HTTP Response = 
 Status-Line (( general-header | response-header | entity-header ) CRLF)
 CRLF
 [ message-body ]
 Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
 */

public class Response {

    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        Path path = Paths.get(System.getProperty("user.dir"), 
                "webroot", request.getUri()); 
        System.out.println("path:" + path);
        if (Files.exists(path)) {
            try (InputStream inputStream = 
                        Files.newInputStream(path)) {
                int ch = inputStream.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    output.write(bytes, 0, ch);
                    ch = inputStream.read(bytes, 0, BUFFER_SIZE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // file not found
            String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
                    + "Content-Type: text/html\r\n"
                    + "Content-Length: 23\r\n" + "\r\n"
                    + "<h1>File Not Found</h1>";
            output.write(errorMessage.getBytes());
        }
    }
}