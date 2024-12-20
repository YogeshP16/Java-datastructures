

public class SubclassA extends ClassA {

    // Constructor for SubclassA
    public SubclassA(int age, int score, int percentage) {
        // You can access 'age', 'score', and 'percentage' directly
        super("Default Name", age, score, percentage); // Calling superclass constructor
    }

    // Method to demonstrate name access
    public void displayDetails() {
        // Accessing 'name' through the getter method (private field)
        System.out.println("Name: " + getName());  
        System.out.println("Age: " + age);
        System.out.println("Score: " + score);
        System.out.println("Percentage: " + percentage);
    }
}