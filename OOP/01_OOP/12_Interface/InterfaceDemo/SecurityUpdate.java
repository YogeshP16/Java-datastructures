public interface SecurityUpdate {

    // Abstract Method --> must implement in subclass
    // In SmartPhone class --> Implemneted
    void downloadSecurityPatch(String PatchVersion);  // Abstract Method

    // Defaault method  --> Add new methods to interfaces without breaking old code.
    default void installSecurityPatch(String PatchVersion){
        System.out.println("Installing security patch version: " + PatchVersion );
    }

    // Static method
    static String getSecurityInfo() {
        return "Security Patch - Version 1.5";
    }


    
} 
