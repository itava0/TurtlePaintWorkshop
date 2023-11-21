import java.awt.*;

public class Triangle extends Shape {
    public Triangle(Turtle turtle, Point location, Color color, int border) {
        super(turtle, location, color, border);
    }

    @Override
    public void paint() {
        setTurtleProperties();

        for (int i = 0; i < 3; i++) {
            turtle.forward(100);
            turtle.turnRight(120);
        }
    }
}