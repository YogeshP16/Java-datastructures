

public class Main {
    public static void main(String[] args) {
        ClassA person = new ClassA("Yogesh", 12, 78, 90);
        
        // Access the private field 'name' through the getter method
        System.out.println("Name: " + person.getName());
        
        // Modify the private field using the setter method
        person.setName("Zeke");
        System.out.println("Updated Name: " + person.getName());

        // Creating an instance of SubclassA and displaying details
        SubclassA obj = new SubclassA(25, 95, 88);
        obj.displayDetails();  // Displays the name (through getter) and other details
    }
}


/*
Name: Yogesh
Updated Name: Zeke
Name: Default Name
Age: 25
Score: 95
Percentage: 88
 */