// Interface that all shapes implement
interface Shape {
    void paint();
}

// Circle implements Shape
class Circle implements Shape {
    public void paint() {
        System.out.println("Painting a circle.");
    }
}

// Rectangle implements Shape
class Rectangle implements Shape {
    public void paint() {
        System.out.println("Painting a rectangle.");
    }
}

// Robot works with any shape
class Robot {
    public void paint(Shape shape) {
        shape.paint();
    }
}

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();

        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        robot.paint(circle);    // Painting a circle.
        robot.paint(rectangle); // Painting a rectangle.

        // Adding a new shape, Triangle, without modifying Robot.
        Shape triangle = new Triangle();
        robot.paint(triangle); // Painting a triangle.
    }
}

// Adding a new shape (Triangle) without changing the Robot class
class Triangle implements Shape {
    public void paint() {
        System.out.println("Painting a triangle.");
    }
}
