package app16;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SeekableByteChannelDemo1 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(12);
        System.out.println(buffer.position()); // prints 0
        buffer.putInt(10);
        System.out.println(buffer.position()); // prints 8
        buffer.putLong(1234567890L);
        System.out.println(buffer.position()); // prints 16
        buffer.rewind(); // sets position to 0
        System.out.println(buffer.getInt()); // prints 10000
        System.out.println(buffer.getLong()); // prints 1234567890
        buffer.rewind();
        System.out.println(buffer.position()); // prints 0

        Path path = Paths.get("C:/temp/channel");
        System.out.println("-------------------------");
        try (SeekableByteChannel byteChannel = 
                Files.newByteChannel(path, 
                    StandardOpenOption.CREATE,
                    StandardOpenOption.READ, 
                    StandardOpenOption.WRITE);) {
            System.out.println(byteChannel.position()); // prints 0
            byteChannel.write(buffer);
            System.out.println(byteChannel.position()); //prints 20
            
            // read file
            ByteBuffer buffer3 = ByteBuffer.allocate(40);
            byteChannel.position(0);
            byteChannel.read(buffer3);
            buffer3.rewind();
            System.out.println("get int:" + buffer3.getInt());
            System.out.println("get long:" + buffer3.getLong());
            System.out.println(buffer3.getChar());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}