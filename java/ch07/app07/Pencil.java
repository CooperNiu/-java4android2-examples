package app07;
class Tool {
    @Override
    public String toString() {
        return "Generic tool";
    }
}

public class Pencil extends Tool {
    @Override
    public String toString() {
        return "I am a Pencil";
    }

    public void write() {
        System.out.println(super.toString());
        System.out.println(toString());
    }

    public static void main(String[] args) {
        Pencil pencil = new Pencil();
        pencil.write();
    }
}