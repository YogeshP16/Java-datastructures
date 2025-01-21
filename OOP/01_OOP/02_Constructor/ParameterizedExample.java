class Student {
    int rollNo;
    String name;

    // Parameterized Constructor
    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    // Display method
    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }
}

public class ParameterizedExample {
    public static void main(String[] args) {
        // Creating objects with custom values using parameterized constructor
        Student s1 = new Student(101, "John");
        Student s2 = new Student(102, "Jane");

        // Displaying values
        s1.display();  // Roll No: 101, Name: John
        s2.display();  // Roll No: 102, Name: Jane
    }
}

// Parameterized Constructor = Constructor with arguments to initialize objects with custom values.