import java.awt.*;

public abstract class Shape {
    protected Turtle turtle;
    protected Point location;
    protected Color color;
    protected int border;

    public Shape(Turtle turtle, Point location, Color color, int border) {
        this.turtle = turtle;
        this.location = location;
        this.color = color;
        this.border = border;
    }

    public abstract void paint();
    protected void setTurtleProperties() {
        turtle.penUp();
        turtle.goTo(location.getX(), location.getY());
        turtle.penDown();
        turtle.setColor(color);
        turtle.setPenWidth(border);
    }
}
