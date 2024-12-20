package abstractDemo;

public abstract class Leader {   // abstract class (super class)
     // Abstract method - task assigned ---> without  implemetation
     // it must be implemented in subclass 
    abstract void assignTask();

     // Concrete (Normal method) --> with implementation
    void greet() {
        System.out.println("this is normal method ---> Welcome to the team!"); // Shared behavior
    }

    /*  you can have normal constructor 
    int year;
    public Leader(int year){
        this.year= year;

    } */

    // you can have static method
    static void hello(){
        System.out.println("you can have static methods");
        
    }

    // you cannot create object for superclass

}
