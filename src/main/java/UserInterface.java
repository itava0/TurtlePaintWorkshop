import java.awt.*;
import java.util.Scanner;

public class UserInterface {
    public static void display() {
        Scanner scanner = new Scanner(System.in);
        double worldWidth;
        double worldHeight;

        System.out.println("Welcome to Turtle Drawer!");

        System.out.print("Enter the width of the world canvas:");
        worldWidth = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter the height of the world canvas:");
        worldHeight = scanner.nextDouble();
        scanner.nextLine();

        World world = new World((int) worldWidth, (int) worldHeight);
        Turtle turtle = new Turtle(world, 0, 0);
        turtle.setDelay(.000001);

        while (true) {
            displayMenu();
           int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addShape(scanner, turtle);
                    break;
                case 2:
                    world.saveAs("src/main/resources/saveCurrentScreen.png");
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void displayMenu() {
        System.out.println("1) Add Shape");
        System.out.println("2) Save Image");
        System.out.println("0) Exit");
        System.out.println("Enter your choice:");
    }

    private static void addShape(Scanner scanner, Turtle turtle) {
        int chosenShape;
        int borderWidth;
        String color;
        Color borderColor;
        Point location;
        double radius = 0;

        System.out.print("Which shape (1. square, 2. circle, 3. triangle)? ");
        chosenShape = scanner.nextInt();
        scanner.nextLine();

        if (chosenShape == 2) {
            System.out.print("Enter the radius: ");
            radius = scanner.nextDouble();
            scanner.nextLine();
        }

        System.out.print("Enter the border width: ");
        borderWidth = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the border color (Red, Green, Blue): ");
        color = scanner.nextLine().toLowerCase().trim();
        borderColor = getColor(color);

        System.out.println("Enter the location of the shape (x, y): ");
        location = inputCoordinate(scanner);

        switch (chosenShape) {
            case 1:
                Square square = new Square(turtle, location, borderColor, borderWidth);
                square.paint();
                break;
            case 2:
                Circle circle = new Circle(turtle, location, borderColor, borderWidth, radius);
                circle.paint();
                break;
            case 3:
                Triangle triangle = new Triangle(turtle, location, borderColor, borderWidth);
                triangle.paint();
                break;
            default:
                System.out.println("Invalid shape choice.");
        }
    }

    private static Point inputCoordinate(Scanner scanner) {
        System.out.print("Enter the x-coordinate: ");
        int x = scanner.nextInt();
        System.out.print("Enter the y-coordinate: ");
        int y = scanner.nextInt();
        scanner.nextLine();
        return new Point(x, y);
    }

    public static Color getColor(String color) {
        return switch (color) {
            case "red" -> Color.RED;
            case "green" -> Color.GREEN;
            case "blue" -> Color.BLUE;
            default -> Color.BLACK;
        };
    }

}
