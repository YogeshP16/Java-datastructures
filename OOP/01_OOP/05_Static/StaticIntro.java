public class StaticIntro {

        static int x = 10;     // static variable

        static void y(){       // static methods
            System.out.println("this is static method");

            System.out.println("you can access static variable directly: " + x );
        }
//-------------------------------------------------------------------------------------------
        int instanceVar = 20;   // non static variable

        void instanceMethod(){  // non static method

            System.out.println("This is a non-static method.");
            // Can access both static and instance variables
            System.out.println("Instance Variable: " + instanceVar);   // instance variable
            System.out.println("Static Variable: " + x);               // static variable
        }

    public static void main(String[] args) {

         // Accessing static method without creating an object
         // Accessing via classname --> StaticIntro.y(); --> Static is the classname
         // Static Belongs to the Class:
         // A static method is not tied to any object or instance of the class. 
         // It is loaded into memory when the class is loaded by the JVM, making it accessible at the class level.
         StaticIntro.y();  

         // Acessing non static methods--> need to create object
         StaticIntro obj = new StaticIntro();
         obj.instanceMethod(); 
    }
}

/*
 * Static variable (staticVariable): Shared across all instances of the class.
 * Static method (staticMethod): Can be called without creating an instance.
 * Instance method (instanceMethod): Requires an object to call and can access both static and instance variables.
 */

/*
this is static method
you can access static variable directly: 10
This is a non-static method.
Instance Variable: 20
Static Variable: 10
 */