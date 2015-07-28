package app07;
public class Box {
    public int length;
    public int width;
    public int height;

    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "I am a Box.";
    }

    @Override
    public Object clone() {
        return new Box(1, 1, 1);
    }
}