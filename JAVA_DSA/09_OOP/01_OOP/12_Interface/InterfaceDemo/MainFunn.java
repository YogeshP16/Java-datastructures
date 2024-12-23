public class MainFunn {

    public static void main(String[] args) {
        SmartPhone smartphone = new SmartPhone();

        // Download and install both updates
        smartphone.downloadUpdate("15.0");  // Downloading Android update version 15.0
        smartphone.downloadSecurityPatch("1.5"); // Downloading security patch version 1.5

        // Install updates using default methods
        smartphone.installUpdate("15.0"); // Installing OS: 15.0
        smartphone.installSecurityPatch("1.5");  // Installing security patch version: 1.5
        
        // Static method
        System.out.println(SecurityUpdate.getSecurityInfo());
    }
}
/*  output
Downloading Android update version 15.0
Downloading security patch version 1.5
Installing OS: 15.0
Installing security patch version: 1.5
Security Patch - Version 1.5
 */

/*
Achieves Multiple Inheritance: By implementing multiple interfaces (AndroidUpdate and SecurityUpdate).
Default Methods: Ensure that new methods can be added without breaking old code.
Static Methods: Used for data that belongs to the interface itself, not the object instance.
 */