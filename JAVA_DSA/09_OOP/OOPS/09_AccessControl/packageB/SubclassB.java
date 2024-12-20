

//import packageA.ClassA; // Import ClassA from packageA

public class SubclassB extends ClassA {
    public SubclassB(int age, int score, int percentage) {
        super("SubclassB Name", age, score, percentage); // Calling superclass constructor
    }

    public void displayDetails() {
        // Accessing protected field 'score' directly as it's inherited
        System.out.println("Score from SubclassB: " + score);
    }

    
}
