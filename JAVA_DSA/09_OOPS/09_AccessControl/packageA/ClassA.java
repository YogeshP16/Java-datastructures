package packageA;

public class ClassA {
    // Private field, accessible only within ClassA
    private String name;
    
    // Public field, accessible from anywhere
    public int age;
    
    // Protected field, accessible within the package and by subclasses of different package
    protected int score;
    
    // Default field, accessible within the same package
    int percentage;

    // Constructor to initialize fields
    public ClassA(String name, int age, int score, int percentage) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.percentage = percentage;
    }

    // Getter for private field 'name'
    public String getName() {
        return name;
    }

    // Setter for private field 'name'
    public void setName(String name) {
        this.name = name;
    }
}
