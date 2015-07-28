package app17;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings(value={"unchecked","serial"})
public class SuppressWarningsDemo1 implements Serializable {
    public void openFile() {
        ArrayList a = new ArrayList();
        File file = new File("X:/java/doc.txt");
    }  
}