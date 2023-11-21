import java.awt.*;

public class Circle extends Shape {
    private final double radius;
    public Circle(Turtle turtle, Point location, Color color, int border, double radius) {
        super(turtle, location, color, border);
        this.radius = radius;
    }

    @Override
    public void paint() {
        setTurtleProperties();
        int numSegments = 360;
        double angleIncrement = 360.0 / numSegments;

        for (int i = 0; i < numSegments; i++) {
            turtle.forward(radius * Math.PI * angleIncrement / 180.0);
            turtle.turnRight(angleIncrement);
        }
    }
}