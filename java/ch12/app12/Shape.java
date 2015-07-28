package app12;
public class Shape {
    private enum ShapeType {
        RECTANGLE, TRIANGLE, OVAL
    };
    private ShapeType type = ShapeType.RECTANGLE;
    public String toString() {
        if (this.type == ShapeType.RECTANGLE) {
            return "Shape is rectangle";
        }
        if (this.type == ShapeType.TRIANGLE) {
            return "Shape is triangle";
        }    
        return "Shape is oval";
    }
}