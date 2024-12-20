package abstractDemo;

public class Employee extends Leader {

    // subclass
    // here we implemented abstractmethod details

    @Override
    void assignTask() { // Child overrides the task 
        System.out.println("Completing the assigned task!");
    }



}
