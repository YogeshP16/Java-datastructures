package abstractDemo;

public class MainFunc {
    public static void main(String[] args) {
        Leader leader = new Employee(); // Parent reference, child object
        leader.greet(); // Calls parent method
        leader.assignTask(); // Calls child's overridden method
        
    }

}


/* --> output
Welcome to the team!
Completing the assigned task!
 */