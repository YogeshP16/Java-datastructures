class Robot {
    public void paint(Object shape) {
        if (shape instanceof Circle) {
            System.out.println("Painting a circle.");
        } else if (shape instanceof Rectangle) {
            System.out.println("Painting a rectangle.");
        }
    }
}

class Circle {}
class Rectangle {}

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.paint(new Circle());    // Painting a circle.
        robot.paint(new Rectangle()); // Painting a rectangle.
        // Adding a triangle requires modifying the Robot class.
    }
}
