public class NSVISM {  //ACCESING NON STATIC VARIABLE INSIDE STATIC METHODS

    int instanceVar = 20;  // Non static variable 

    static void x(){
        // Attempting to directly access a non-static variable will cause an error
        // Cannot make a static reference to the non-static field instanceVar
        // System.out.println(instanceVar);  // this will thrown an error

        // To access non-static members, create an instance of the class
        NSVISM obj = new NSVISM();
        System.out.println("Accessing non-static variable via object: " + obj.instanceVar);
    }


    public static void main(String[] args) {
        // calling the static method
        NSVISM.x();  // output ---> Accessing non-static variable via object: 20
    }

    /*
     * Direct Access is Not Allowed:
     
        Static methods cannot directly access non-static members because static methods belong to the class
         and are not tied to any specific instance.

     * Access Through an Object:
     
        By creating an instance of the class (Example obj = new Example();), 
        the static method can access the non-static members using the object reference (obj.instanceVariable).
     */

}
